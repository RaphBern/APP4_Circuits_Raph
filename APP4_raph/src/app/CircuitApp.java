package app;

import electronique.Composant;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CircuitApp {
   public CircuitApp() {
//       CircuitBuiler builer = new CircuitBuiler();
//       Composant c = builer.construireCircuit(System.getProperty("user.dir") + "\\APP4_raph\\src\\donnees\\fichiers_json\\reseau_secours_hopital.json");
//       System.out.println(c.calculerResistance());

       Scanner s = new Scanner(System.in);
       if (s.nextLine().equals("R")) {
          new CircuitApp();
       } else if (s.nextLine().equals("Q")) {
           System.out.println("Au revoir");
           s.close();
       }

   }

    public static void main(String[] args) {
      new CircuitApp();
    }
}
