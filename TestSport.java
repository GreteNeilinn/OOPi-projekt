

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestSport {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("\nTegemist on programmiga, mis kalkuleerib sinu nädala jooksul tehtud treeningute kaloreid.");
        System.out.println("Kaloreid on võimalik arvutada jägmiste spordialade korral: ");
        System.out.println("võrkpall, jalgpall, pikamaajooks, korvpall, ujumine, kiirehüpits, aeglanehüpits, golf");
        System.out.println("Samuti on võimalik sisestada ainult jooksmiseid, et saada tagasisidet nädala jooksmistest.");
        System.out.println("\nSisestage T kui soovite treeninguid lisada ning J kui soovite ainult jooksmiseid lisada");
        String vastus = sc.nextLine();

        if (vastus.equalsIgnoreCase("t")){
            treeniguteArvutus();
        } else if (vastus.equalsIgnoreCase("j")){
            jooksudeArvutus();
        }

    }


    public static boolean kasOigeNimi(String ala){
        if (ala.equals("pikamaajooks") || ala.equals("jalgpall") || ala.equals("võrkpall") || ala.equals("pallimängud") || ala.equals("ujumine") || ala.equals("golf") || ala.equals("korvpall") || ala.equals("aeglanehüpits") || ala.equals("kiirehüpits"))
            return true;
        return false;
    }


    public static String sisestatudAlaKontroll(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nSisestage spordiala, mille treeningu kaloreid tee sooviks arvutada: ");
        String ala = sc.nextLine();
        if (!kasOigeNimi(ala)) {
            do {
                System.out.println("Sellist ala ei eksisteeri. Proovige uuesti");
                ala = sc.nextLine();
            } while (!kasOigeNimi(ala));
        }
        return ala;
    }


    public static void treeniguteArvutus(){
        List<Spordialad> treeningud = new ArrayList<>();
        List<String> spordialad = new ArrayList<>();
        List<Integer> kestvused = new ArrayList<>();
        double kaal;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nValisite programmi, mis kalkuleerib sinu nädala jooksul tehtud treeningute kaloreid.");
        System.out.println("Kaloreid on võimalik arvutada jägmiste spordialade korral: ");
        System.out.println("võrkpall, jalgpall, pikamaajooks, korvpall, ujumine, kiirehüpits, aeglanehüpits, golf");
        spordialad.add(sisestatudAlaKontroll());

        System.out.println("Sisestage treeningu pikkus minutites: ");
        int kestvus = Integer.parseInt(sc.nextLine());
        kestvused.add(kestvus);

        System.out.println("Sisestage enda kehakaal kilogrammides: " );
        kaal = Double.parseDouble(sc.nextLine());

        System.out.println("Uue treeningu lisamiseks sisestage X: ");
        String vastus = sc.nextLine();

        while (vastus.equalsIgnoreCase("x")){
            spordialad.add(sisestatudAlaKontroll());
            System.out.println("Sisestage treeningu pikkus minutites: ");
            kestvus = Integer.parseInt(sc.nextLine());
            kestvused.add(kestvus);
            System.out.println("Uue treeningu lisamiseks sisestage X: ");
            vastus = sc.nextLine();
        }

        for (int i = 0; i < spordialad.size(); i++) {
            if (spordialad.get(i).equals("pikamaajooks")){
                Spordialad treening = new Pikamaajooks(spordialad.get(i), kestvused.get(i), kaal);
                treeningud.add(treening);
            } else if (spordialad.get(i).equals("võrkpall")){
                Spordialad treening = new Võrkpall(spordialad.get(i), kestvused.get(i), kaal);
                treeningud.add(treening);
            } else if (spordialad.get(i).equals("jalgpall")){
                Spordialad treening = new Jalgpall(spordialad.get(i), kestvused.get(i), kaal);
                treeningud.add(treening);
            } else if (spordialad.get(i).equals("pallimängud")){
                Spordialad treening = new Pallimängud(spordialad.get(i), kestvused.get(i), kaal);
                treeningud.add(treening);
            } else if (spordialad.get(i).equals("ujumine")){
                Spordialad treening = new Ujumine(spordialad.get(i), kestvused.get(i), kaal);
                treeningud.add(treening);
            } else if (spordialad.get(i).equals("aeglanehüpits")){
                Spordialad treening = new AeglaneHüpits(spordialad.get(i), kestvused.get(i), kaal);
                treeningud.add(treening);
            } else if (spordialad.get(i).equals("golf")){
                Spordialad treening = new Golf(spordialad.get(i), kestvused.get(i), kaal);
                treeningud.add(treening);
            } else if (spordialad.get(i).equals("kiirehüpits")){
                Spordialad treening = new Kiirehüpits(spordialad.get(i), kestvused.get(i), kaal);
                treeningud.add(treening);
            } else if (spordialad.get(i).equals("korvpall")){
                Spordialad treening = new Korvpall(spordialad.get(i), kestvused.get(i), kaal);
                treeningud.add(treening);
            }
        }
        System.out.println("Nädalajooksul tehtud treeningud");
        double summa = 0;
        for (int treening = 0; treening < treeningud.size(); treening++) {
            System.out.println(treeningud.get(treening));
            summa += treeningud.get(treening).arvutaKaloreid();
        }
        System.out.println("\nKokku kulutatud kaloreid: " + summa);
    }



    public static void jooksudeArvutus(){
        List<Pikamaajooks> jooksmised = new ArrayList<>();
        List<Double> km = new ArrayList<>();
        List<Integer> kestvused = new ArrayList<>();
        double kaal;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nValisite programmi, mis kalkuleerib sinu nädala jooksul tehtud jooksude statistikat.");
        System.out.println("Sisestage joostud vahemaa kilomeetrites: ");
        double vahemaa = Double.parseDouble(sc.nextLine());
        km.add(vahemaa);

        System.out.println("Sisestage jooksu pikkus minutites: ");
        int kestvus = Integer.parseInt(sc.nextLine());
        kestvused.add(kestvus);

        System.out.println("Sisestage enda kehakaal kilogrammides: " );
        kaal = Double.parseDouble(sc.nextLine());

        System.out.println("Uue jooksu lisamiseks sisestage X: ");
        String vastus = sc.nextLine();

        while (vastus.equalsIgnoreCase("x")){
            System.out.println("Sisestage joostud vahemaa kilomeetrites: ");
            vahemaa = Double.parseDouble(sc.nextLine());
            km.add(vahemaa);

            System.out.println("Sisestage jooksu pikkus minutites: ");
            kestvus = Integer.parseInt(sc.nextLine());
            kestvused.add(kestvus);

            System.out.println("Uue treeningu lisamiseks sisestage X: ");
            vastus = sc.nextLine();
        }

        for (int i = 0; i < km.size(); i++) {
            Pikamaajooks jooks1 = new Pikamaajooks(kestvused.get(i), kaal, km.get(i));
            jooksmised.add(jooks1);
        }

        double summa = 0;
        System.out.println("\nSelle nädala statistika: ");
        for (int i = 0; i < jooksmised.size(); i++) {
            System.out.println(jooksmised.get(i).km + " km pikkuse jooksuga põletasid " + jooksmised.get(i).arvutaKaloreid() + " kalorit");
            summa += jooksmised.get(i).arvutaKaloreid();
        }

        System.out.println("\nKokku põletasid " + summa + " kalorit");
        JooksuStatistika tulemused  = new JooksuStatistika(jooksmised);
        System.out.println();
        tulemused.keskmineVahemaa();
        tulemused.keskmineKiirus();
        tulemused.pikimJooks();
        tulemused.kõigeKauem();
        tulemused.kiireimKiirus();

    }

}
