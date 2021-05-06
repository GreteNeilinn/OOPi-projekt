public class AeglaneHüpits extends Hüpits {

    protected double METslowHüpits = 8.0;

    public AeglaneHüpits(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METslowHüpits*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }
}
