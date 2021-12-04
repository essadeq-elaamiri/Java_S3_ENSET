package net.pro;

import java.util.Arrays;

public class Question {
    private String titre;
    private String description;
    private int score;
    private Reponse [] reponses;

    public Question(String titre, String description, int score, Reponse[] reponses) {
        this.titre = titre;
        this.description = description;
        this.score = score;
        this.reponses = reponses;
    }

    @Override
    public String toString() {
        String qust =  "Question[score: "+this.score+"]: "+this.titre;
        for (Reponse a: this.reponses) {
            qust += "\n\t"+ a.toString();
        }
        return qust;
    }

    public Reponse[] getReponses() {
        return reponses;
    }

    public void setReponses(Reponse[] reponses) {
        this.reponses = reponses;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
