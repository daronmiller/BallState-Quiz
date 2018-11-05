package getToKnowBSU;

import java.util.List;


class Question {
    private String question;
    private List<Answer> answers;

    Question(String question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    String getQuestion() {
        return question;
    }

    List<Answer> getAnswers() {
        return answers;
    }
}
