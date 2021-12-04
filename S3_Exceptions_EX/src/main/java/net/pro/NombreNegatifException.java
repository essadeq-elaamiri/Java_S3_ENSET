package net.pro;

public class NombreNegatifException extends Exception{
    private int valeurErronee;
    private String message;
    public NombreNegatifException(String message, int valeurErronee){
        super(message);
        this.valeurErronee = valeurErronee;
    }

    public int getValeurErronee() {
        return this.valeurErronee;
    }
}
