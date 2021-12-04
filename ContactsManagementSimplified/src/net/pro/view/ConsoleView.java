package net.pro.view;


import net.pro.controller.ContactController;
import net.pro.model.Contact;

import java.util.Scanner;

public class ConsoleView {
    private static final String MENU = "\n\n"+"=".repeat(12)+" MENU " +"=".repeat(12)+"\n"+
            "1. Afficher tous les contacts.\n" +
            "2. Chercher un contact.\n" +
            "3. Ajouter un contact.\n" +
            "4. Changer le numéro de téléphone d’un contact.\n" +
            "5. Supprimer un contact.\n"+
            "6. Quitter le programme.\n"
            +"=".repeat(30);
    private static ContactController cc = new ContactController();
    //private static Scanner scanner = new Scanner(System.in);

    public ConsoleView(){

    }

    public static void showAllContacts(){
        System.out.println("\n[ Show All Contacts ]\n");
        cc.showAllContacts();
    }

    public static void searchForAContact(Scanner scanner){
        if (cc.getContacts().isEmpty()){
            sendConsoleMessage("Contacts Folder is empty!");
            return;
        }
        Contact contact = null;
        System.out.println("\n[ Search for Contacts ]\n");
        System.out.print("You want to search with (1-name, 2-email, 3-phoneNumber): ");

        int searchFilter = scanner.nextInt();

        switch(searchFilter){
            case 1:
                contact = searchContact("name", scanner);
                break;
            case 2:
                contact = searchContact("email", scanner);
                break;
            case 3:
                contact = searchContact("phone", scanner);
                break;
            default:
                System.out.println("Invalid choice! ");
                break;
        }

        if(contact == null){
            System.out.println("No result found!");
        }else{
            System.out.println("Found: \n"+contact);
        }
    }

    private static Contact searchContact(String filter, Scanner scanner){
        String searchWord = "";
        System.out.print("Enter the "+filter+" or a part of it :");
        scanner.nextLine();
        searchWord = scanner.nextLine();
        try {
            return cc.findContact(filter+":"+searchWord);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void addContact(Scanner scanner){
        Contact c;
        String name, email, phone;
        System.out.println("\n[ Add a contact ]\n");
        System.out.print("Enter the name: ");
        scanner.nextLine();
        name = scanner.nextLine();

        System.out.print("Enter the email 'example@example.com': ");
        //scanner.nextLine();
        email = scanner.nextLine();

        System.out.print("Enter the phone '+212-6222-222-22': ");
        phone = scanner.nextLine();

        c = new Contact(0,name, email, phone);
        try{
            cc.addContact(c);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void editContactPhone(Scanner scanner){
        if(cc.getContacts().isEmpty()){
            sendConsoleMessage("Contacts folder is empty!");
            return;
        }
        // require the id
        System.out.println("\n[Edit Contact Number phone]\n");
        int inputId;
        String newNumber;
        System.out.println("Enter the contact id: ");
        inputId = scanner.nextInt();
        System.out.println("Enter the new number phone '+212-6222-222-22': ");
        scanner.nextLine();
        newNumber = scanner.nextLine();
       try{
           cc.editContactPhoneNumber(inputId, newNumber);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }

    public static void removeContact(Scanner scanner){
        if(cc.getContacts().isEmpty()){
            sendConsoleMessage("Contacts folder is empty!");
            return;
        }
        System.out.println("\n[Remove Contact Number phone]\n");
        int id;
        System.out.println("Enter the id of the contact to remove: ");
        id = scanner.nextInt();

        if(cc.removeContact(id)){
            System.out.println(id +" Removed !");
        }else{
            System.out.println("Can not remove file! ");
        }

    }

    public static void saveContactsToFiles(){
        cc.saveContactsToSystem();
        System.out.println("Contacts saved to system! ");
        System.out.println("Quite ...");
    }

    public static void sendConsoleMessage(String msg){
        System.out.println("Msg: "+msg);
    }

    public static void showMenu(){
        System.out.println(MENU);
        System.out.print("Enter Action: ");

    }
    public static int getChoice(Scanner scanner){
        return scanner.nextInt();
    }
}
