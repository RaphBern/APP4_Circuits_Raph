package app;

import electronique.*;

import java.util.ArrayList;
import java.util.List;

public class CircuitApp {
   public CircuitApp() {
//      Resistance r = new Resistance(34);
//       System.out.println(r.calculerResistance());
//       ArrayList<Composant> comp = new ArrayList<>();
//       comp.add(new Resistance(35));
//       comp.add(new Resistance(100));
//       ArrayList<Composant> komp = new ArrayList<>();
//       komp.add(new Resistance(20));
//       CircuitSerie c2 = new CircuitSerie(komp);
//       comp.add(c2);
//       CircuitSerie c = new CircuitSerie(comp);
//       ArrayList<Composant> composants = new ArrayList<>();
//       composants.add(c);
//       composants.add(new Resistance(34));
//       CircuitSerie circuitPrincipal = new CircuitSerie(composants);
//       System.out.println(circuitPrincipal.calculerResistance());

       ArrayList<Composant> compo2 = new ArrayList<>();
       compo2.add(new Resistance(200));
       compo2.add(new Resistance(300));
       CircuitSerie sousCirc = new CircuitSerie(compo2);
       ArrayList<Composant> compo = new ArrayList<>();
       compo.add(new Resistance(100));
       compo.add(sousCirc);

       CircuitParallele circPrincipal = new CircuitParallele(compo);
       System.out.println(circPrincipal.calculerResistance());


   }

    public static void main(String[] args) {
      new CircuitApp();
    }
}
