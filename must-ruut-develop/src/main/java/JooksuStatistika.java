
import java.util.List;

public class JooksuStatistika {

    protected List<Pikamaajooks> jooksmised;

    public JooksuStatistika(List<Pikamaajooks> jooksmised) {
        this.jooksmised = jooksmised;
    }

    public String pikimJooks(){  //Leiab kõige pikema vahemaaga jooksu
        String tulemus;
        double max = 0;
        int indeks = 0;
        for (int i = 0; i < jooksmised.size(); i++) {
            if (jooksmised.get(i).km > max){
                max = jooksmised.get(i).km;
                indeks = i;
            }
        }
        tulemus = "Pikim jooks oli " + max + " km ajaga " + jooksmised.get(indeks).kestusMin + " min";
        return tulemus;
    }

    public String keskmineVahemaa(){  //Arvutab kõikide jooksude keskmise vahemaa
        String tulemus;
        double summa = 0;
        for (int i = 0; i < jooksmised.size(); i++) {
            summa += jooksmised.get(i).km;
        }
        tulemus = "Keskmine vahemaa: " + Math.round((summa/jooksmised.size())*100.0)/100.0 + " km";
        return tulemus;
    }

    public String kõigeKauem(){  // Leiab jooksu, mis on kõige kauem kestnud
        String tulemus;
        int max = 0;
        int indeks = 0;
        for (int i = 0; i < jooksmised.size(); i++) {
            if (jooksmised.get(i).kestusMin > max){
                max = jooksmised.get(i).kestusMin;
                indeks = i;
            }
        }
        tulemus = "Kõige kauem joostud aeg: " + max + " min, mille jooksul jõudsid joosta " + jooksmised.get(indeks).km + " km";
        return tulemus;
    }

    public String keskmineKiirus(){ //Arvutab kõikide jooksude keskmise kiiruse
        String tulemus;
        double summa = 0.0;
        for (int i = 0; i < jooksmised.size(); i++) {
            summa += jooksmised.get(i).keskmineKiirus();
        }
        double keskKiirus = Math.round((summa/jooksmised.size())*100.0)/100.0;
        tulemus = "Keskmine jooksmiskiirus: " + keskKiirus + " min/km";
        return tulemus;
    }

    public String kiireimKiirus(){ //Leiab jooksu, mille keskmine kiirus oli kõige kiirem
        String tulemus;
        double min = 20.0;
        int indeks = 0;
        for (int i = 0; i < jooksmised.size(); i++) {
            if(jooksmised.get(i).keskmineKiirus() < min){
                min = jooksmised.get(i).keskmineKiirus();
                indeks = i;
            }
        }
        tulemus = "Kiireim ühe jooksu keskmine kiirus: " + min + " min/km, vahemaa: " + jooksmised.get(indeks).km + " km";
        return tulemus;
    }
}