package com.example.gestiunefarmacie;

public enum Orase {
    Timisoara, Cluj, Bucuresti, Iasi;

    private Orase(){}

    public String value(){
        return name();
    }

    public static Orase fromvalue(String v){
        return valueOf(v);
    }
}
