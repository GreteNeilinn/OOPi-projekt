import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Spordialad {

    protected double MET = 4;
    protected String kuupäev;
    protected int kestusMin;
    protected static List<Integer> nädalaMahud = new ArrayList<>();
    protected double kaal;
    private List<Spordialad> Spordialad;

    public Spordialad(double kaal, int kestusMin) {
        this.kaal = kaal;
        this.kestusMin = kestusMin;
    }

    public double getMET() {
        return MET;
    }

    public String getKuupäev() {
        return kuupäev;
    }

    public int getKestusMin() {
        return kestusMin;
    }

    public static List<Integer> getNädalaMahud() {
        return nädalaMahud;
    }

    public double getKaal() {
        return kaal;
    }

    public List<Spordialad> getSpordialad() {
        return Spordialad;
    }

    public Spordialad(String kuupäev, int kestusMin, double kaal) {
        this.kuupäev = kuupäev;
        this.kestusMin = kestusMin;
        this.kaal = kaal;
    }

    public List<Integer> NädalaMahud() {
        for (Spordialad k : Spordialad)  {
            nädalaMahud.add(kestusMin);
        }
        return nädalaMahud;
    }

    public static int arvutaNädalasKokku(){
        int summa = 0;
        for (int kord = 0; kord < nädalaMahud.size(); kord++) {
            summa += nädalaMahud.get(kord);
        }
        return summa;
    }

    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (MET*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }

    @Override
    public String toString() {
        LocalDate kuupäevana = LocalDate.parse(kuupäev);
        return  kuupäevana.toString() + "                " + kestusMin + "                           " + arvutaKaloreid()  + " kCal";
    }
}
