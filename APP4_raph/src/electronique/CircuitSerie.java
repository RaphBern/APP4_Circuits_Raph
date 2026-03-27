package electronique;


import java.util.ArrayList;
import java.util.List;


public class CircuitSerie extends Circuit{

    public CircuitSerie(List<Composant> composants){
        super(composants);
    }

    @Override
    public double calculerResistance() {
        double resistance = 0;
       for (int i = 0; i < composants.size(); i++) {

       }


        return resistance;
    }
}
