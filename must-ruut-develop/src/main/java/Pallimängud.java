public class Pallimängud extends Spordialad{

    protected double METpall = 4.2;

    public Pallimängud(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METpall*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }
}
