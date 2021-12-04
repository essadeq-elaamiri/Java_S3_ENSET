package net.pro.metier;

public class Ordinateur {
    private String nom;
    private String marque;
    private String desc;
    private int nombre_stock;
    private double prix;

    public Ordinateur(String nom, String marque, String desc, int nombre_stock, double prix) {
        this.nom = nom;
        this.marque = marque;
        this.desc = desc;
        this.nombre_stock = nombre_stock;
        this.prix = prix;
    }

    public double prixDeQualiteX(String qualite){
        return 0d; /*TODO: implementation ?? */
    }



    @Override
    public boolean equals(Object obj) {
        Ordinateur ordinateur = (Ordinateur) obj;
        return this.nom == ordinateur.nom &&
                this.marque == ordinateur.marque &&
                this.desc == ordinateur.desc &&
                this.prix == ordinateur.prix &&
                this.nombre_stock == ordinateur.nombre_stock;
    }

    @Override
    public String toString() {
        return "{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", desc='" + desc + '\'' +
                ", nombre_stock=" + nombre_stock +
                ", prix=" + prix +
                '}';
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNombre_stock() {
        return nombre_stock;
    }

    public void setNombre_stock(int nombre_stock) {
        this.nombre_stock = nombre_stock;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
