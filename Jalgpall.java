package com.company.tree;

public class Jalgpall extends Pallimängud{

    protected double METjalka = 7.0;

    public Jalgpall(String nimetus, int kestusMin, double kaal) {
        super(nimetus, kestusMin, kaal);
    }

    @Override    // ülekatmine
    public double arvutaKaloreid() {
        double põletatudKaloreidMin = kestusMin * (METjalka*3.5*kaal)/200;
        return Math.round(põletatudKaloreidMin);
    }

}
