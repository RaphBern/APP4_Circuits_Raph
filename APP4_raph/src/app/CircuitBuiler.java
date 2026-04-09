package app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import electronique.*;


import java.io.*;
import java.util.ArrayList;

public class CircuitBuiler {

    public Composant lireComposant(JsonNode noeud) {
        String type = noeud.get("type").asText();

        if ("resistance".equals(type)) {
            return new Resistance(noeud.get("valeur").asDouble());

        } else if ("serie".equals(type)) {
            ArrayList<Composant> sousCircuitSerie = new ArrayList<>();
            for (JsonNode composantNode : noeud.get("composants")) {
                sousCircuitSerie.add(lireComposant(composantNode));
            }
            return new CircuitSerie(sousCircuitSerie);
        } else if ("parallele".equals(type)) {
            ArrayList<Composant> sousCircuitPar = new ArrayList<>();
            for (JsonNode composantNode : noeud.get("composants")) {
                sousCircuitPar.add(lireComposant(composantNode));
            }
            return new CircuitParallele(sousCircuitPar);
        } else throw new IllegalArgumentException("type de composant invalide");
    }

    public Composant construireCircuit(String pathIn) {
        Composant c = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            InputStream is =  CircuitBuiler.class.getClassLoader().getResourceAsStream(pathIn);
            if (is == null) {
                throw new RuntimeException("");
            }
//            FileReader reader = new FileReader(pathIn);
            JsonNode donnees = mapper.readTree((is));
            for (JsonNode noeud : donnees) {
                c = lireComposant(noeud);
            }

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return c;
    }
}
