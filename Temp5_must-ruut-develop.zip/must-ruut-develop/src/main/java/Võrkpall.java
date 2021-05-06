
public class Võrkpall extends Pallimängud {

    protected double METkoss = 6.0;

    public Võrkpall(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METkoss*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }

}
