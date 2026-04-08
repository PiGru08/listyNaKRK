package com.example.myapplication;

public class GraPlanszowa {

    private String nazwa;
    private int minLiczbaGraczy;
    private int maxLiczbaGraczy;
    private int czasRozgrywki;
    private String gatunek;
    private int liczbaGier;

    public GraPlanszowa(String nazwa, int maxLiczbaGraczy, int minLiczbaGraczy, String gatunek, int czasRozgrywki) {
        this.nazwa = nazwa;
        this.maxLiczbaGraczy = maxLiczbaGraczy;
        this.minLiczbaGraczy = minLiczbaGraczy;
        this.gatunek = gatunek;
        this.czasRozgrywki = czasRozgrywki;
        this.liczbaGier = 0;
    }
public void zwiekszLicznikGier(){
        liczbaGier++;
}

    @Override
    public String toString() {
        return
                "nazwa: " + nazwa +
                ", minLiczbaGraczy: " + minLiczbaGraczy +
                ", maxLiczbaGraczy: " + maxLiczbaGraczy +
                ", czasRozgrywki: " + czasRozgrywki +
                ", gatunek: " + gatunek+
                        ", liczba rozegranych gier: "+ liczbaGier;
    }
}
