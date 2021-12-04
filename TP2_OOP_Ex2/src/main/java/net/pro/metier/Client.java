package net.pro.metier;

import java.util.ArrayList;

public class Client {
    private String nom, prenom, adresse, email, ville, telephone;
    private ArrayList<LigneCommande> lignes_commande;

    public Client(String nom,
                  String prenom,
                  String adresse,
                  String email,
                  String ville,
                  String telephone,
                  ArrayList<LigneCommande> lignes_commande) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.ville = ville;
        this.telephone = telephone;
        this.lignes_commande = lignes_commande;
    }

    @Override
    public String toString() {
        String lcStr = "";
        if(this.lignes_commande.isEmpty()){
            lcStr = "List is empty";
        }else{
            for (LigneCommande lc:
                    this.lignes_commande) {
                lcStr += lc.toString();

            }
        }
        return "{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", ville='" + ville + '\'' +
                ", telephone='" + telephone + '\'' +
                ", lignes_commande=[" + lcStr +
                "]}";
    }

    public boolean ajouterCommande(LigneCommande lc){
        for (LigneCommande lcIter: this.lignes_commande) {
            if(lcIter.equals(lc)) return false;
        }
        return this.lignes_commande.add(lc);

    }

    public boolean supprimerLigneCommande(LigneCommande lc){
        for (LigneCommande lcIter: this.lignes_commande) {
            if (lcIter.equals(lc)) {
                //delete
                return this.lignes_commande.remove(lc);
            }
        }
        return false;
    }



}
