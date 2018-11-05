package getToKnowBSU;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestXMLParser {

    @Test
    public void testParser() {
        XMLParser parser = new XMLParser();
        parser.parseXML();
        List<Question> questions = parser.getQuestions();
        Question question = questions.get(0);
        String text = question.getQuestion();
        Assert.assertEquals("What is the name of the statue of a woman located in the lobby of the library?", text);
    }
}
