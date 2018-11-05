package getToKnowBSU;

 class AnswerValidator {
    private int totalCorrect;

    AnswerValidator() {
        totalCorrect = 0;
    }

    int getTotalCorrect() {
        return totalCorrect;
    }

    void resetTotalCorrect() {
        totalCorrect = 0;
    }

    boolean checkAnswer(Answer answer) {
        if (answer.checkAnswer()) {
            totalCorrect++;
            return true;
        } else {
            return false;
        }
    }
}
