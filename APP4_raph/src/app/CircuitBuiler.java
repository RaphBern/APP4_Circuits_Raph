package app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import electronique.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CircuitBuiler {

    private Composant lireComposant(JsonNode noeud) {
        String type = noeud.get("type").asText();

        if ("resistance".equals(type)) {
            return new Resistance(noeud.get("valeur").asDouble());

        }
       else if ("serie".equals(type)) {
           ArrayList<Composant> sousCircuitSerie = new ArrayList<>();
           for (JsonNode composantNode : noeud.get("composants")) {
               sousCircuitSerie.add(lireComposant(composantNode));
           }
           return new CircuitSerie(sousCircuitSerie);
        }
       else if ("parallele".equals(type)) {
           ArrayList<Composant> sousCircuitPar = new ArrayList<>();
           for (JsonNode composantNode : noeud.get("composants")) {
               sousCircuitPar.add(lireComposant(composantNode));
           }
           return new CircuitParallele(sousCircuitPar);
        }
       else throw new IllegalArgumentException("type de composant invalide");
    }

    private static char fSep = File.separatorChar;
    public static final String pathIn = System.getProperty("user.dir") + fSep + "APP4_raph" + fSep + "src" + fSep + "donnees";

    public Composant construireCircuit(String pathIn ) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode donnees = mapper.readTree(new File(pathIn) );
            for (JsonNode node : donnees) {
              lireComposant(node);

            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture : " + e.getMessage());
        }
        return null;
    }
}
