public class Golf extends Spordialad {

    protected double METgolf = 4.5;

    public Golf(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METgolf*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }
}