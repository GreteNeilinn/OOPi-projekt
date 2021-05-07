import java.util.List;

public class Jooksualad extends Spordialad {

    protected double METjooks = 7.0;

    public Jooksualad(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METjooks*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }
}
