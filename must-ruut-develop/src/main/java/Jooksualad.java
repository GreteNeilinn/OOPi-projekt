import java.util.List;

public class Jooksualad extends Spordialad {

    protected double METjooks = 7.0;

    public Jooksualad(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ├╝lekatmine
    public double arvutaKaloreid() {
        double p├ÁletatudKaloreidMin = kestusMin * (METjooks*3.5*kaal)/200;
        return Math.round(p├ÁletatudKaloreidMin);
    }
}
