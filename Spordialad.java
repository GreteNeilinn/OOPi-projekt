package com.company.tree;

import java.util.ArrayList;
import java.util.List;

public class Spordialad {

    protected double MET = 4;
    protected String nimetus;
    protected int kestusMin;
    protected static List<Integer> nädalaMahud = new ArrayList<>();
    protected double kaal;
    private List<Spordialad> Spordialad;

    public Spordialad(String nimetus, int kestusMin, double kaal) {
        this.nimetus = nimetus;
        this.kestusMin = kestusMin;
        this.kaal = kaal;
    }

    public Spordialad(double kaal, int kestusMin) { //konstruktor jooksude jaoks
        this.kestusMin = kestusMin;
        this.kaal = kaal;
    }

    public int getKestusMin() {
        return kestusMin;
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
        return "treeningu tüüp: " + nimetus +
                ", treeningu kestus: " + kestusMin + " min" +
                ", põletasid " + arvutaKaloreid()  + " kCal" +".";
    }
}
