package net.pro.consoleViews;

import net.pro.models.Client;
import net.pro.models.Produit;
import net.pro.workers.MetierClientImp;
import net.pro.workers.MetierProduitImp;

import java.util.Scanner;

public class ConsoleView {
    /*
    le menu suivant :
    1. Afficher la liste des produits.
    2. Rechercher un produit par son nom (si plusieurs produits ont le même nom,
    on ne retournera que le premier produit trouvé).
    3. Ajouter un nouveau produit dans la liste.
    4. Supprimer un produit par nom (si plusieurs produits ont le même nom, on
    supprime toutes les occurrences trouvées).
    5. Sauvegarder les produits : cette option permet de sauvegarder la liste des
    produits dans fichier nommé produits.dat.
    6. Quitter ce programme.
     */

    private static String MENU = "\n"+"=".repeat(15)+" MENU "+ "=".repeat(15) + "\n"+
            "    *******[ Gestion des {__}s ]*****\n"+
            "    1. Afficher la liste des {__}s.\n" +
            "    2. Rechercher un {__} par son nom (si plusieurs produits ont le même nom,\n" +
            "    on ne retournera que le premier produit trouvé).\n" +
            "    3. Ajouter un nouveau {__} dans la liste.\n" +
            "    4. Supprimer un {__} par nom (si plusieurs produits ont le même nom, on\n" +
            "    supprime toutes les occurrences trouvées).\n" +
            "    5. Sauvegarder les {__}s : cette option permet de sauvegarder la liste des\n" +
            "    produits dans fichier nommé {__}s.dat.\n" +
            "    6. Quitter ce programme.\n" +
            "=".repeat(30+" MENU ".length());
    private static final String QUESTION_GESTION = "\n Tapez 1 pour geger les produits, ou 2 pour gerer les clients: ";
    private static int toBeManage = 1; // 1 for produits, 2 pour les clients;

    private static  Scanner scanner = new Scanner(System.in);

    private static MetierClientImp metierClientImp= new MetierClientImp();
    private static MetierProduitImp metierProduitImp= new MetierProduitImp();


    public static int choosenMenuItem(){
        System.out.println("\nEnter a choice: ");
        return scanner.nextInt();
    }

    public static void showMenu(){
        //demandeWhatToManage();
        if(toBeManage == 1){

            System.out.println(MENU.replace("{__}", "produit"));
        }
        else{
            System.out.println(MENU.replace("{__}", "client"));
        }
    }

    public static void showListItems(){
        //demandeWhatToManage();
        if(toBeManage ==1){
           if(metierProduitImp.getProduits() != null){
               for (Produit p: metierProduitImp.getProduits()) {
                   System.out.println(p+"\n");
               }
           }
           else{
               System.out.println("List is null//");
           }
        }
        else {
            if(metierClientImp.getClients() != null){
                for (Client c: metierClientImp.getClients()) {
                    System.out.println(c+"\n");
                }
            }
            else {
                System.out.println("List null//");
            }
        }
    }

    private static void demandeWhatToManage(){
        System.out.println(QUESTION_GESTION);
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice ==1){
            toBeManage =1;
        }
        else {
            toBeManage = 2;
        }
    }

    public static void findItemByNom(){
        //demandeWhatToManage();
        String nom="";
        System.out.print("\nEntrer nom: ");
        nom = scanner.nextLine();
        if(toBeManage ==1){
            //produits
            Produit produit = metierProduitImp.findByNom(nom);
            if (produit == null){
                System.out.println("No result!");
            }
           else{
                System.out.println(produit);
            }
        }
        else {
            //clients
            Client client = metierClientImp.findByNom(nom);
            if (client == null){
                System.out.println("No result!");
            }
            else{
                System.out.println(client);
            }
        }
    }

    public static void addNewItem(){
        //demandeWhatToManage();
        if(toBeManage ==1){
            //produits
            Produit produit;
            String nom="", marque="", description="";
            int nombreStock = 0;
            float prix = 0f;

            System.out.println("Entrer nom: ");
            nom = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Entrer marque: ");
            marque = scanner.nextLine();
            //scanner.nextLine();

            System.out.println("Entrer description: ");
            description = scanner.nextLine();
            //scanner.nextLine();

            System.out.println("Entrer prix: ");
            prix = scanner.nextFloat();
            scanner.nextLine();

            System.out.println("Entrer nombre en stock: ");
            nombreStock = scanner.nextInt();
            scanner.nextLine();

            produit  = new Produit(nom, marque, description, prix, nombreStock);

            // add to list
            metierProduitImp.add(produit);
        }
        else {
            //clients
            Client client;
            String nom="", prenom="", adresse="", tel="", email="";


            System.out.println("Entrer nom: ");
            nom = scanner.nextLine();
            scanner.nextLine();

            System.out.println("Entrer adresse: ");
            adresse = scanner.nextLine();
            //scanner.nextLine();

            System.out.println("Entrer tel: ");
            tel = scanner.nextLine();
            //scanner.nextLine();

            System.out.println("Entrer email: ");
            email = scanner.nextLine();
            //scanner.nextLine();

            client  = new Client(nom, prenom, adresse, email, tel);

            // add to list
            metierClientImp.add(client);

        }


    }
    public static void deleteItem(){
        demandeWhatToManage();

        String nom="";
        System.out.print("\nEntrer nom: ");
        nom = scanner.nextLine();
        if(toBeManage ==1){
            //produits
            Produit produit = metierProduitImp.findByNom(nom);
            if (produit == null){
                System.out.println("No result!");
            }
            else{
                metierProduitImp.delete(nom);
                System.out.println("Deleted! ");
            }
        }
        else {
            //clients
            Client client = metierClientImp.findByNom(nom);
            if (client == null){
                System.out.println("No result!");
            }
            else{
                metierClientImp.delete(nom);
                System.out.println("Deleted! ");
            }
        }

    }
    public static void saveItemsToFile(){
        demandeWhatToManage();

        if(toBeManage ==1){
            //produits
            metierProduitImp.saveAll();
        }
        else {
            //clients
            metierClientImp.saveAll();
        }
    }

    public static void quitTheProgramm(){
        saveItemsToFile();
        System.out.println("Save ... Quite !!");
    }
}
