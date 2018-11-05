package getToKnowBSU;

import org.junit.Assert;
import org.junit.Test;

public class TestAnswerValidator {

    @Test
    public void testValidator() {
        AnswerValidator validator = new AnswerValidator();
        Answer answer = new Answer("The Naked Lady", true);
        Assert.assertEquals(true, validator.checkAnswer(answer));
    }
    @Test
    public void incorrectTestValidator() {
        AnswerValidator validator = new AnswerValidator();
        Answer answer = new Answer("The Naked Lady", false);
        Assert.assertEquals(false, validator.checkAnswer(answer));
    }
}
