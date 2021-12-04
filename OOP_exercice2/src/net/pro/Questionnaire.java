package net.pro;

import java.util.Arrays;

public class Questionnaire {
    private String titre;
    private Question[] questions;

    public Questionnaire(String titre, Question[] questions) {
        this.titre = titre;
        this.questions = questions;
    }

    @Override
    public String toString() {
        String quest =  "titre='"+this.titre+ '\'';
        for (Question q: this.questions) {
            quest += "\n"+ q.toString();
        }
        return quest;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
