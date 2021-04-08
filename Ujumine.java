package com.company.tree;

public class Ujumine extends Spordialad{

    protected double METjooks = 5.8;

    public Ujumine(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METjooks*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }
}
