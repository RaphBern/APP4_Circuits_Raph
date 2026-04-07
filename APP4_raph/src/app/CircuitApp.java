package app;

import electronique.Composant;

import java.io.FileReader;
import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class CircuitApp {

public ArrayList<String> imprimerFichiersDispo() {
String pathIn = System.getProperty("user.dir") + "\\APP4_raph\\src\\donnees\\fichier_json";
return null;
}

    public CircuitApp() {
//       CircuitBuiler builer = new CircuitBuiler();
//       Composant c = builer.construireCircuit(System.getProperty("user.dir") + "\\APP4_raph\\src\\donnees\\fichiers_json\\reseau_secours_hopital.json");
//       System.out.println(c.calculerResistance());
       Scanner s = new Scanner(System.in);
       String command = s.nextLine();

   }

    public static void main(String[] args) {
      new CircuitApp();
    }
}
