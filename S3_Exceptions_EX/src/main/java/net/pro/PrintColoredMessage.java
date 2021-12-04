package net.pro;

public abstract class PrintColoredMessage {
    private static final String ANSI_RESET = "\u001B[0m";


    // ex: System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "This text has a green background and red text!" + ANSI_RESET);

    public static void println(String message,String background, String textColor ){
        if (background == null){
            System.out.println(textColor+message+ANSI_RESET);
        }
        else if(textColor == null){
            System.out.println(background+message+ANSI_RESET);
        }
        else if(textColor == null && background == null){
            System.out.println(message);
        }
    }
}
