import java.time.LocalDateTime;

public class Golf extends Spordialad {

    protected double METgolf = 4.5;

    public Golf(String kuupäev, int kestusMin, double kaal) {
        super(kuupäev, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METgolf*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }
}