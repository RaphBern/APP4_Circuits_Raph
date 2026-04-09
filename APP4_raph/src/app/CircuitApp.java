package app;

import electronique.Circuit;
import electronique.Composant;

import java.io.File;
import java.io.FileReader;
import java.io.FilterOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class CircuitApp {

    public ArrayList<String> imprimerFichiersDispo(String path) {
        ArrayList<String> fichiers = new ArrayList<>();

        ClassLoader classLoader = CircuitApp.class.getClassLoader();
        URL ressource = classLoader.getResource(path);

        File dossier = new File(ressource.getFile());

        for (File file : dossier.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".json")) {
                fichiers.add(file.getName());
            }

        }
        return fichiers;
    }

    public CircuitApp() {
//       CircuitBuiler builer = new CircuitBuiler();
//       Composant c = builer.construireCircuit(System.getProperty("user.dir") + "\\APP4_raph\\src\\donnees\\fichiers_json\\reseau_secours_hopital.json");
//       System.out.println(c.calculerResistance());

        Scanner s = new Scanner(System.in);

        boolean relancer = true;
        while (relancer) {
            ArrayList<String> fichiersJson = imprimerFichiersDispo("");

            System.out.println("Veuillez choisir un fichier: ");
            for (int i = 0; i < fichiersJson.size(); i++) {
                System.out.println("[" + (i + 1) + "]" + fichiersJson.get(i));
            }

            int commande = 0;
            System.out.println("entrer le numéro du fichier voulu: ");
            try {
                if (s.hasNextInt()) {
                    commande = s.nextInt();
                    if (commande >= 1 && commande <= fichiersJson.size()) {
                        relancer = false;
                    } else {
                        System.out.println("commande introuvable: réessayez");
                    }
                } else {
                    System.out.println("Entree invalide: réessayez");
                    s.next();
                }


                String fichierSelectionne = fichiersJson.get(commande - 1);

                s.nextLine();

                CircuitBuiler circuit = new CircuitBuiler();
                Composant c = circuit.construireCircuit(fichierSelectionne);
                System.out.println("Résistance du circuit: " + c.calculerResistance());

                System.out.println("Entrez 'R' pour accéder à un autre fichier et 'Q' pour arreter le programme");
                String commande2 = s.nextLine().toUpperCase();
              while (!commande2.equals("R") && !commande2.equals("Q")){
                  System.out.println("Commande invalide: recommencez");
                  commande2 = s.nextLine().toUpperCase();
              }
                    if (commande2.equals("Q")) {
                        relancer = false;
                    }else if (commande2.equals("R")) {
                        relancer = true;
                    }

            } catch (IndexOutOfBoundsException e) {
                System.out.println( e.getMessage());

            }
        }
        s.close();
        System.out.println("programme terminé. Au revoir. ");
    }

    public static void main(String[] args) {
        new CircuitApp();
    }
}
