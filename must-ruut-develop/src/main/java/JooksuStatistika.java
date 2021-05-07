
/*import java.util.List;

public class JooksuStatistika {

    protected List<Pikamaajooks> jooksmised;

    public JooksuStatistika(List<Pikamaajooks> jooksmised) {
        this.jooksmised = jooksmised;
    }

    public void pikimJooks(){  //Leiab kõige pikema vahemaaga jooksu
        double max = 0;
        int indeks = 0;
        for (int i = 0; i < jooksmised.size(); i++) {
            if (jooksmised.get(i).km > max){
                max = jooksmised.get(i).km;
                indeks = i;
            }
        }
        System.out.println("Pikim jooks oli " + max + " km ajaga " + jooksmised.get(indeks).kestusMin + " min");
    }

    public void keskmineVahemaa(){  //Arvutab kõikide jooksude keskmise vahemaa
        double summa = 0;
        for (int i = 0; i < jooksmised.size(); i++) {
            summa += jooksmised.get(i).km;
        }
        System.out.println("Keskmine vahemaa: " + Math.round((summa/jooksmised.size())*100.0)/100.0 + " km");
    }

    public void kõigeKauem(){  // Leiab jooksu, mis on kõige kauem kestnud
        int max = 0;
        int indeks = 0;
        for (int i = 0; i < jooksmised.size(); i++) {
            if (jooksmised.get(i).kestusMin > max){
                max = jooksmised.get(i).kestusMin;
                indeks = i;
            }
        }
        System.out.println("Kõige kauem joostud aeg: " + max + " min, mille jooksul jõudsid joosta " + jooksmised.get(indeks).km + " km");
    }

    public void keskmineKiirus(){ //Arvutab kõikide jooksude keskmise kiiruse
        double summa = 0.0;
        for (int i = 0; i < jooksmised.size(); i++) {
            summa += jooksmised.get(i).keskmineKiirus();
        }
        double keskKiirus = Math.round((summa/jooksmised.size())*100.0)/100.0;
        System.out.println("Keskmine jooksmiskiirus: " + keskKiirus + " min/km");
    }

    public void kiireimKiirus(){ //Leiab jooksu, mille keskmine kiirus oli kõige kiirem
        double min = 20.0;
        int indeks = 0;
        for (int i = 0; i < jooksmised.size(); i++) {
            if(jooksmised.get(i).keskmineKiirus() < min){
                min = jooksmised.get(i).keskmineKiirus();
                indeks = i;
            }
        }
        System.out.println("Kiireim ühe jooksu keskmine kiirus: " + min + " min/km, vahemaa: " + jooksmised.get(indeks).km + " km");
    }
}*/