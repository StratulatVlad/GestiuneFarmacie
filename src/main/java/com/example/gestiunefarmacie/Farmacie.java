package com.example.gestiunefarmacie;

public class Farmacie {
    private String nume;
    private String adresa;

    private String oras;
    private String telefon;

    public String getNume() {
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }
    public String getOras() {
        return oras;
    }

    public String getTelefon() {
        return telefon;
    }


    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Farmacie(String nume, String adresa,String telefon) {
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Farmacie(String nume, String oras) {
        this.nume = nume;
        this.oras = oras;
    }
}
