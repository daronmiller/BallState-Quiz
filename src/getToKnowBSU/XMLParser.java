package getToKnowBSU;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

class XMLParser {
    private DocumentMaker documentMaker = new DocumentMaker("QuizData.xml");
    private  List<Question> questions = new ArrayList<>();

    List<Question> getQuestions() {
        parseXML();
        for (int i = 0; i < 6; i++) {
            Collections.shuffle(questions.get(i).getAnswers());
        }
        return questions;
    }

    void parseXML() {
        try {
            Document doc = documentMaker.buildDocument();
            NodeList problems = doc.getElementsByTagName("problem");

            for (int i = 0; i < problems.getLength(); i++) {
                Node problem = problems.item(i);
                List<Answer> answers = getAnswers(problem);
                Element element = (Element) problem;
                String question = element.getElementsByTagName("question").item(0).getTextContent();
                Question q = new Question(question, answers);
                questions.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Answer> getAnswers(Node problem) {
        List<Answer> answers = new ArrayList<>();
        Element element = (Element) problem;
        NodeList answerList = element.getElementsByTagName("answer");
        for (int i = 0; i < answerList.getLength(); i++) {
            Element e = (Element) answerList.item(i);
            String text = e.getTextContent();
            boolean isCorrect = false;
            if (e.hasAttribute("status")) {
                isCorrect = true;
            }
            Answer current = new Answer(text, isCorrect);
            answers.add(current);
        }
        return answers;
    }


}
