package electronique;

import java.util.ArrayList;

public class CircuitParallele extends Circuit{
    public CircuitParallele(ArrayList<Composant> composants){
    super(composants);
}

    @Override
    public double calculerResistance() {
        double resistanceTotale = 0;

        for (int i = 0; i<composants.size(); i++){
            if (composants.get(i) instanceof Resistance) {
                resistanceTotale += 1/composants.get(i).calculerResistance();
            }
            else resistanceTotale += 1/composants.get(i).calculerResistance();
        }

        return 1/resistanceTotale;
    }
}
