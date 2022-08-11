package com.example.gestiunefarmacie;

public enum CategoriiMedicamente {
    Analgezic, Antiinflamator, Antibiotic, Vitamine, Anabolizant;

    private CategoriiMedicamente(){}

    public String value(){
        return name();
    }

    public static CategoriiMedicamente fromvalue(String v){
        return valueOf(v);
    }
}
