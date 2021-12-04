package net.pro.models;

import java.io.Serializable;
import java.util.Objects;

public class Produit implements Serializable {
    /*
    Créez une classe Produit avec les attributs nom, marque, prix, description, et nombre
en stock. La classe produit doit implémenter l’interface Serializable
     */
    private String nom, marque, description;
    private float prix;
    private int nombreOnStock;

    public Produit(String nom, String marque, String description, float prix, int nombreOnStock) {
        this.nom = nom;
        this.marque = marque;
        this.description = description;
        this.prix = prix;
        this.nombreOnStock = nombreOnStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Float.compare(produit.prix, prix) == 0 && nombreOnStock == produit.nombreOnStock && Objects.equals(nom, produit.nom) && Objects.equals(marque, produit.marque) && Objects.equals(description, produit.description);
    }



    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", nombreOnStock=" + nombreOnStock +
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNombreOnStock() {
        return nombreOnStock;
    }

    public void setNombreOnStock(int nombreOnStock) {
        this.nombreOnStock = nombreOnStock;
    }
}
