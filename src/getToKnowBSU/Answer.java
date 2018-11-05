package getToKnowBSU;

class Answer {
    private String answer;
    private boolean isCorrect;

    Answer(String answer, boolean isCorrect) {
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    String getAnswer() {
        return answer;
    }

    boolean checkAnswer() {
        return isCorrect;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
