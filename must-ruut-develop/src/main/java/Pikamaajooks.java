import java.util.List;

public class Pikamaajooks extends Spordialad{

    protected double MET = 7.5;
    protected double km;

    public Pikamaajooks(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    public Pikamaajooks(int aeg, double kaal, double km){
        super(kaal, aeg);
        this.km = km;
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (MET*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }

    public double keskmineKiirus(){ //Arvutab jooksu keskmise kiiruse
        return Math.round((getKestusMin()/km)*100.0)/100.0;
    }

    @Override
    public String toString() {
        return "Joostud vahemaa: " + km +
                " km, aeg minutites: " + kestusMin +
                " min, kulutatud kalorid: " + arvutaKaloreid() + " cal";
    }
}