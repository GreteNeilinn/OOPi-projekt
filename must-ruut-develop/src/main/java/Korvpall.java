public class Korvpall extends Pallimängud {

    protected double METvõrk = 5.7;

    public Korvpall(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METvõrk*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }

}
