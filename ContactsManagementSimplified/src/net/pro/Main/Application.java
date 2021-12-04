package net.pro.Main;

import net.pro.controller.ContactController;
import net.pro.model.Contact;
import net.pro.view.ConsoleView;

import java.util.Scanner;

public class Application {


    public static void main(String[] args) {

        ContactController cc = new ContactController();
        int choice=0;
        Scanner scanner = new Scanner(System.in);
        do {
            ConsoleView.showMenu();
            choice = ConsoleView.getChoice(scanner);
            switch (choice){
                case 1:
                    //TODO: show all
                    ConsoleView.showAllContacts();
                    break;
                case 2:
                    //TODO: search one
                    ConsoleView.searchForAContact(scanner);
                    break;
                case 3:
                    //TODO: add contact
                    ConsoleView.addContact(scanner);
                    break;
                case 4:
                    //TODO: edit contact
                    ConsoleView.editContactPhone(scanner);
                    break;
                case 5:
                    //TODO: remove contact
                    ConsoleView.removeContact(scanner);
                    break;
                default:
                    String msg;

                    msg = choice !=6 ? "Invalid choice! ": "";
                    ConsoleView.sendConsoleMessage(msg);
                    break;
            }
        }while(choice != 6);
        ConsoleView.saveContactsToFiles();

            /*
            try {
            /*
            cc.addContact(c1, c2, c3);
            cc.showAllContactsFromSystem();
            System.out.println("find : " + cc.findContact("name:2"));
            cc.editContactPhoneNumber(11, "+212-6222-933-11");
            cc.saveContactsToSystem();


        cc.showAllContacts();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
             */



    }

}
