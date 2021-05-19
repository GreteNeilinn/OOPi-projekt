public class Ujumine extends Spordialad{
    protected double METujumine = 5.8;

    public Ujumine(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METujumine*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }
}