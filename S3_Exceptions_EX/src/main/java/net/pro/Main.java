package net.pro;

public class Main {
    public static void main(String[] args) {
        try {
            EntierNaturel e1 = new EntierNaturel(11);
            System.out.println("Valeur: "+e1.getVal());
            e1.setVal(-3);
            System.out.println("Valeur: "+e1.getVal());

        } catch (NombreNegatifException e) {
            System.err.println(e.getMessage());
            PrintColoredMessage.println(e.getMessage(), MsgColor.ANSI_RED_BACKGROUND, null);
            System.err.println("Valeur erronee: "+e.getValeurErronee());
        }
    }

}
