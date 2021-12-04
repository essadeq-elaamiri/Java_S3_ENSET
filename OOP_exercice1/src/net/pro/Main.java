package net.pro;

public class Main {
    public static void main(String[] args) {
        Adherent ad1 = new Adherent("Hassan", "Elaamiri", "+2126112233", 19, 124);
        Auteur aut1 = new Auteur("Hamid", "Alghazali", "_", 81, 556609);
        Livre livre1 = new Livre(aut1, "Ihyae aalum addin", 6675009);

        System.out.println("Adherent= {"+ad1.afficher()+"}");
        System.out.println("Livre= {"+livre1.afficher()+"}");
    }
}
