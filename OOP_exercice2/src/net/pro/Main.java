package net.pro;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final String MENU_HEADRE = "\n" +
            "▒█▀▀█ ▒█░▒█ ▀█▀ ▒█▀▀▀█ \n" +
            "▒█░▒█ ▒█░▒█ ▒█░ ░▄▄▄▀▀ \n" +
            "░▀▀█▄ ░▀▄▄▀ ▄█▄ ▒█▄▄▄█";
    static final String MENU = "1- Start the quiz" +
            "\n2- Check responses" +
            "\n0- Quite" +
            "\n--------------------";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        //Menu
        //start the quiz /or/ quite
        //if start, show a random question, score, responses
        //store results in a table using the index of the question
        //show score at the end
        //show error responses and their questions
        Questionnaire questionnaire = InitQuestionnaire.initQuestionnaire();
        Question [] questions = questionnaire.getQuestions();
        int score = 0;
        Question incorrect_answers [] = new Question[questions.length];
        Arrays.fill(incorrect_answers, null);
        int response_choice = -1;

        System.out.println(MENU_HEADRE+"\n"+MENU);

        do {
            System.out.print("Choix d'opération: ");
            choix = scanner.nextInt();
            if (choix == 1){
                /**
                 * TODO: start the quiz, save responses, score
                 */
                int resp = 0;
                System.out.println("[0- to quite]");
                for (int i=0; i< questions.length; i++){
                    do {
                        System.out.println(questions[i]);
                        System.out.println("response:[0-3]");
                        System.out.print("Reponse: ");
                        response_choice = scanner.nextInt();
                    }while (response_choice>3 || response_choice<0);
                    if (questions[i].getReponses()[response_choice].isCorrect()){

                        score += questions[i].getScore();
                    }
                    else {
                        incorrect_answers[i] = questions[i];
                    }
                }
            }
            else if(choix == 2){
                System.out.println("Score: "+ score);
                System.out.println("Les reponses incorrects:");
                for (int i=0; i< incorrect_answers.length; i++){
                    if(incorrect_answers[i] != null){
                        System.out.println("Q: "+incorrect_answers[i].toString());
                        for (Reponse r:incorrect_answers[i].getReponses() ) {
                            if (r.isCorrect()){
                                System.out.println("Correct response: "+r.getContenue());
                            }
                        }
                    }
                }


            }
        }while (choix != 0);


    }

    public static void startQuiz(Question [] questions){

    }
}
