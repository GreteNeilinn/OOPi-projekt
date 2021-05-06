public class Kiirehüpits extends Hüpits {

    protected double METkiireHüpits = 12.0;

    public Kiirehüpits(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METkiireHüpits*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }

}
