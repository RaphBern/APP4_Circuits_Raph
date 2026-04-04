package app;

import electronique.Composant;

public class CircuitApp {
   public CircuitApp() {
       CircuitBuiler builer = new CircuitBuiler();
       Composant c = builer.construireCircuit(System.getProperty("user.dir") + "\\APP4_raph\\src\\donnees\\fichiers_json\\complexe_industriel_zone_nord.json");
       System.out.println(c.calculerResistance());

   }

    public static void main(String[] args) {
      new CircuitApp();
    }
}
