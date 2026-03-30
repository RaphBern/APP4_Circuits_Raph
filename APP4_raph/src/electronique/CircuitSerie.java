package electronique;


import java.util.ArrayList;
import java.util.List;


public class CircuitSerie extends Circuit{
    public CircuitSerie(ArrayList<Composant> composants){
        super(composants);

    }

    @Override
    public double calculerResistance() {
        double resistanceTotale = 0;
       for (int i = 0; i< composants.size(); i++) {
           if (composants.get(i) instanceof Resistance) {
                resistanceTotale += composants.get(i).calculerResistance();
           }
           else resistanceTotale += composants.get(i).calculerResistance();
       }


        return resistanceTotale;
    }
}
