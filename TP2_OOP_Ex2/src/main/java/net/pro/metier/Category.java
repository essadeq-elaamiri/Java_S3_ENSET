package net.pro.metier;

import java.util.ArrayList;
import java.util.Iterator;

public class Category {
    private String nom, desc;
    private ArrayList<Ordinateur> ordinateurs = null;

    public Category(String nom, String desc, ArrayList<Ordinateur> ordinateurs) {
        this.nom = nom;
        this.desc = desc;
        this.ordinateurs = ordinateurs;
    }

    public boolean ajouterOrdinateur(Ordinateur ordinateur){
        for (Ordinateur or: this.ordinateurs) {
            if (or.equals(ordinateur)) return false;
        }
        this.ordinateurs.add(ordinateur);
        return true;
    }

    public boolean supprimerOrdinateur(Ordinateur ordinateur){
        for (Ordinateur or: this.ordinateurs) {
            if (or.equals(ordinateur)) {
                //delete
                return this.ordinateurs.remove(or);
            }
        }
        return false;
    }
    public ArrayList<Ordinateur> rechercheParPrix(double prix){
        ArrayList<Ordinateur> ordinateurs_meme_prix = new ArrayList<>();
        Iterator<Ordinateur> iter = this.ordinateurs.iterator();
        Ordinateur or;
        while (iter.hasNext()){
            or = iter.next();
            if(or.getPrix() == prix) ordinateurs_meme_prix.add(or);
        }
        return ordinateurs_meme_prix;

    }

    @Override
    public String toString() {
        String ordinateursStr = "";
        for (Ordinateur or:
             this.ordinateurs) {
            ordinateursStr.concat(or.toString());
        }
        return "{" +
                "nom='" + nom + '\'' +
                ", desc='" + desc + '\'' +
                ", ordinateurs=]" + ordinateursStr +
                "]}";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Ordinateur> getOrdinateurs() {
        return ordinateurs;
    }

    public void setOrdinateurs(ArrayList<Ordinateur> ordinateurs) {
        this.ordinateurs = ordinateurs;
    }
}
