package com.example.gestiunefarmacie;

public class Medicament {
    private String nume_med;

    private String categorie;

    private Integer cantitate;

    private Integer pret;

    public String getNume_med() {
        return nume_med;
    }

    public String getCategorie() {
        return categorie;
    }

    public Integer getCantitate() {
        return cantitate;
    }

    public Integer getPret() {
        return pret;
    }

    public void setNume_med(String nume_med) {
        this.nume_med = nume_med;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setCantitate(Integer cantitate) {
        this.cantitate = cantitate;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }


}
