package com.example.gestiunefarmacie;

public enum CategoriiMedicamente {
    Analgezice, Antiinflamatoare, Antibiotice, Vitamine, Anabolizante;

    private CategoriiMedicamente(){}

    public String value(){
        return name();
    }

    public static CategoriiMedicamente fromvalue(String v){
        return valueOf(v);
    }
}
