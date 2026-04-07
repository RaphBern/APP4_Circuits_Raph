package electronique;

public class Resistance extends Composant{
    private double valeurR;

    public Resistance(double valeurR) {
        this.valeurR = valeurR;
    }

    public double getValeurR() {
        return valeurR;
    }

    public void setValeurR(double valeurR) {
        if (valeurR < 0){
            throw new IllegalArgumentException("valeur impossible");
        }
        this.valeurR = valeurR;
    }
@Override
    public double calculerResistance() {
        return getValeurR();
    }
}
