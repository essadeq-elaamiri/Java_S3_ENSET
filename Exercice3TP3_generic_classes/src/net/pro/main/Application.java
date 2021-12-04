package net.pro.main;

import net.pro.consoleViews.ConsoleView;

public class Application {
    public static void main(String[] args) {
        int choice = 1;

        do {
            ConsoleView.showMenu();
            choice = ConsoleView.choosenMenuItem();
            switch (choice) {
                case 1:
                    ConsoleView.showListItems();
                    break;
                case 2:
                    ConsoleView.findItemByNom();
                    break;

                case 3:
                    //
                    ConsoleView.addNewItem();
                    break;

                case 4:
                    //
                    ConsoleView.deleteItem();
                    break;

                case 5:
                    //
                    ConsoleView.saveItemsToFile();
                    break;


            }
        } while (choice != 6);
    }
}
