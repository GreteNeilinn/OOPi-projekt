

public class Võrkpall extends Pallimängud {

    protected double METvõrk = 5.7;

    public Võrkpall(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METvõrk*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }

}
