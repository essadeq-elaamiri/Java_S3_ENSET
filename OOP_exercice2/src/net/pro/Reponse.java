package net.pro;

public class Reponse {
    private String contenue;
    private boolean isCorrect;

    public Reponse(String contenue, boolean isCorrect) {
        this.contenue = contenue;
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return this.contenue;
    }

    public String getContenue() {
        return contenue;
    }

    public void setContenue(String contenue) {
        this.contenue = contenue;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
