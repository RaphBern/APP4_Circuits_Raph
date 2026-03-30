package electronique;
import java.util.ArrayList;
import java.util.List;

public abstract class Circuit extends Composant {
    protected ArrayList<Composant> composants;
    public Circuit(ArrayList <Composant> composants ) {
        this.composants = composants;

    }

    @Override
    public double calculerResistance() {
        return 0;
    }
}
