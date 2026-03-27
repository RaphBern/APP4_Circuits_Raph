package electronique;

import java.util.ArrayList;

public class CircuitParallele extends Circuit{  public CircuitParallele(){
    super(new ArrayList<>());
}

    @Override
    public double calculerResistance() {
        return 0;
    }
}
