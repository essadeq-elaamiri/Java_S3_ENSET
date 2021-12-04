package net.pro;

public class Livre {
    private Auteur auteur;
    private String titre;
    private int ISBN;

    public Livre(Auteur auteur, String titre, int ISBN) {
        this.auteur = auteur;
        this.titre = titre;
        this.ISBN = ISBN;
    }


    public String afficher() {
        return  this.auteur.afficher() +
                ", titre='" + titre + '\'' +
                ", ISBN=" + ISBN;
    }
}
