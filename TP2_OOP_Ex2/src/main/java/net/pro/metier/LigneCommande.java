package net.pro.metier;

import java.util.Objects;

public class LigneCommande {
    private int quantite;
    private Commande commande;
    private Ordinateur ordinateur;

    public LigneCommande(int quantite, Commande commande, Ordinateur ordinateur) {
        this.quantite = quantite;
        this.commande = commande;
        this.ordinateur = ordinateur;
    }

    @Override
    public String toString() {
        return "{" +
                "quantite=" + quantite +
                ", commande=" + commande +
                ", ordinateur=" + this.ordinateur.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommande that = (LigneCommande) o;
        return quantite == that.quantite && this.commande.equals(((LigneCommande) o).commande) && this.ordinateur.equals(((LigneCommande) o).ordinateur);
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Ordinateur getOrdinateur() {
        return ordinateur;
    }

    public void setOrdinateur(Ordinateur ordinateur) {
        this.ordinateur = ordinateur;
    }
}
