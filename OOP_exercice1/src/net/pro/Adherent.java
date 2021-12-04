package net.pro;

public class Adherent extends Personne{
    private int numAdherent;

    public Adherent(String nom, String prenom, String tel, int age, int numAdherent) {
        super(nom, prenom, tel, age);
        this.numAdherent = numAdherent;
    }

    @Override
    public String afficher() {
         return  super.afficher() +"\nnumAdherent: " +
                this.numAdherent;

    }
}
