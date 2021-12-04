package net.pro;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;

public class InitQuestionnaire {
    public static Questionnaire initQuestionnaire(){
        Questionnaire questionnaire = null;
        Question [] questions = new Question[5];

        try {
            //reading xml file
            File xml_quiz = new File("C:\\Users\\Essadeq\\IdeaProjects\\OOP_exercice2\\src\\net\\pro\\ressources\\quiz.xml");
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xml_quiz);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("question");
            // nodeList is not iterable, so we are using for loop
            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;

                    String []incorrectResps = {eElement.getElementsByTagName("incorrect_answers").item(0).getTextContent(),
                            eElement.getElementsByTagName("incorrect_answers").item(1).getTextContent(),
                            eElement.getElementsByTagName("incorrect_answers").item(2).getTextContent()};

                    //generate questions
                    questions[itr] = new Question(
                            eElement.getElementsByTagName("question_content").item(0).getTextContent(),
                            "desc",
                            100,
                            generateResponses(
                                    eElement.getElementsByTagName("correct_answer").item(0).getTextContent(),
                                    incorrectResps));
                }
            }
        }catch (Exception e){
                System.out.println(e.getMessage());
            }




        //initializing responses
        //for every 3 responses initialize question
        //initialize  Questionnaire
        //return Questionnaire
        questionnaire = new Questionnaire("Quiz en informatique ", questions);
        return questionnaire;
    }


    private static Reponse[] generateResponses(String correctResp, String [] incorrectResp){
        Reponse [] reponses = new Reponse[4];
        reponses[0] = new Reponse(correctResp, true);

        for (int i=1; i< reponses.length; i++){
            reponses[i] = new Reponse(incorrectResp[i-1], false);
        }


        return reponses;
    }
}

