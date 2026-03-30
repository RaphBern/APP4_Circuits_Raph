package app;

import electronique.Circuit;
import electronique.CircuitSerie;
import electronique.Composant;
import electronique.Resistance;

import java.util.ArrayList;
import java.util.List;

public class CircuitApp {
   public CircuitApp() {
      Resistance r = new Resistance(34);
       System.out.println(r.calculerResistance());


   }

    public static void main(String[] args) {
      new CircuitApp();
    }
}
