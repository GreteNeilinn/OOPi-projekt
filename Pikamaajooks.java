public class Pikamaajooks extends Jooksualad{

    protected double MET = 7.5;

    public Pikamaajooks(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (MET*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }

}
