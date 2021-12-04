package net.pro;

import net.pro.metier.*;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Ordinateur or1 = new Ordinateur("Dell Rita 102","Dell", "desc", 300, 10000.00);
        Ordinateur or2 = new Ordinateur("HP X500","HP", "desc", 19, 6400);
        Ordinateur or3 = new Ordinateur("Lenovo L520","lenovpo", "desc", 55, 5999.0);

        ArrayList<Ordinateur> ordinateurs = new ArrayList<>();
        ordinateurs.add(or1);
        ordinateurs.add(or2);
        ordinateurs.add(or3);

        Category category = new Category("PC gamer", "desc", ordinateurs);

        Commande c1 = new Commande("C123", "01-11-2021", "A");
        //Commande c2 = new Commande("C564", "01-11-2021", "A");

        LigneCommande l1 = new LigneCommande(12, c1, or1);
        LigneCommande l2 = new LigneCommande(4, c1, or2);
        LigneCommande l3 = new LigneCommande(34, c1, or3);

        ArrayList<LigneCommande> listLignesComm = new ArrayList<>();
        listLignesComm.add(l1);
        listLignesComm.add(l2);
        listLignesComm.add(l3);

        Client cl = new Client("Essadeq",
                "Elaamiri",
                "123 rue Salami Casa",
                "essa0701@gmail.com",
                "Casa",
                "+212137768",
                listLignesComm
                );

        System.out.println(cl);


    }
}
