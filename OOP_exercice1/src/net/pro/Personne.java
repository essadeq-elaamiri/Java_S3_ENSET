package net.pro;

public class Personne {
    private String nom;
    private String prenom;
    private String tel;
    private int age;

    public Personne(String nom, String prenom, String tel, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.age = age;
    }

    public String afficher() {
        return  "" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", tel='" + tel + '\'' +
                ", age=" + age ;
    }
}
