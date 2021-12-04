package net.pro;

public class Auteur extends Personne{
    private int numAuteur;

    public Auteur(String nom, String prenom, String tel, int age, int numAuteur) {
        super(nom, prenom, tel, age);
        this.numAuteur = numAuteur;
    }

    @Override
    public String afficher() {
        return super.afficher()+"\nnumAuteur: " +
                this.numAuteur;

    }
}
