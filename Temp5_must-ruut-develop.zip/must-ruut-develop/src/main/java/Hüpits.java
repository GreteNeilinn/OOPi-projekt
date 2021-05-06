public class Hüpits extends Spordialad {

    protected double METhüpits = 10;

    public Hüpits(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METhüpits*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }
}
