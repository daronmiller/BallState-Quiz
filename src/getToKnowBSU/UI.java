package getToKnowBSU;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

final class UI {
    private JFrame frame;
    private XMLParser XMLParser = new XMLParser();
    private List<Question> questionList = XMLParser.getQuestions();
    private JTextArea questionField = new JTextArea();
    private List<JButton> buttons = new ArrayList<>();
    private JTextArea appName = new JTextArea();
    private JButton start = new JButton();
    private int current = 0;
    private AnswerValidator validator = new AnswerValidator();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            UI window = new UI();
            window.frame.setVisible(true);
        });
    }

    private UI() {
        homeScreen();
    }

    private void homeScreen() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.red);
        frame.setTitle("BSU Quiz");
        frame.setBounds(100, 80, 600, 550);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        appName.setBounds(150, 100, 300, 100);
        appName.setColumns(100);
        appName.setRows(6);
        appName.setText("GET TO KNOW BSU");
        appName.setFont(new Font("Arial", Font.BOLD, 30));
        appName.setBackground(Color.red);
        appName.setForeground(Color.white);
        appName.setLineWrap(true);
        appName.setWrapStyleWord(true);
        appName.setEditable(false);
        start.setText("Start");
        start.setBounds(200, 200, 200, 50);
        start.setFont(new Font("Arial Black", Font.BOLD, 20));
        start.setBackground(Color.lightGray);
        frame.getContentPane().add(appName);
        frame.getContentPane().add(start);
        start.addActionListener(e -> frame.remove(appName));
        start.addActionListener(e -> frame.remove(start));
        start.addActionListener(e -> initialize());


    }

    private void initialize() {
        frame.revalidate();
        frame.repaint();

        questionField.setBounds(150, 34, 300, 100);
        questionField.setColumns(100);
        questionField.setRows(6);
        questionField.setFont(new Font("Arial", Font.BOLD, 19));
        questionField.setText(questionList.get(current).getQuestion());
        questionField.setBackground(Color.red);
        questionField.setForeground(Color.white);
        questionField.setLineWrap(true);
        questionField.setWrapStyleWord(true);
        questionField.setEditable(false);
        frame.getContentPane().add(questionField);

        frame.setAlwaysOnTop(true);

        populateQuestion(questionList.get(current));


    }

    private void changeQuestion(Answer ans) {
        validator.checkAnswer(ans);
        if (current < 5) {
            current++;
            removeButtons();
            populateQuestion(questionList.get(current));
        } else {
            endQuiz();
        }

    }

    private void endQuiz() {
        removeButtons();
        questionField.setFont(new Font("Arial", Font.BOLD, 25));
        questionField.setText("You scored a " + validator.getTotalCorrect() + " out of 6!");
        current = 0;
        validator.resetTotalCorrect();

        JButton restart = new JButton("Restart Quiz");
        restart.setBounds(200, 300, 200, 50);
        restart.setFont(new Font("Arial Black", Font.BOLD, 14));
        restart.setBackground(Color.lightGray);
        restart.addActionListener(e -> frame.remove(appName));
        restart.addActionListener(e -> frame.remove(start));
        restart.addActionListener(e -> frame.remove(restart));
        restart.addActionListener(e -> initialize());
        frame.getContentPane().add(restart);
    }

    private void addButtons() {
        for (int i = 0; i < 4; i++) {
            frame.getContentPane().add(buttons.get(i));
        }
    }

    private void removeButtons() {
        for (int i = 0; i < 4; i++) {
            frame.getContentPane().remove(buttons.get(i));
        }
        frame.revalidate();
        frame.repaint();
        buttons.clear();
    }

    private void populateQuestion(Question question) {
        List<Answer> answers = question.getAnswers();
        int bound = 200;
        questionField.setText(question.getQuestion());
        buttons.clear();
        for (int i = 0; i < 4; i++) {
            Answer answer = answers.get(i);
            JButton answerButton = new JButton(answer.getAnswer());
            answerButton.setBounds(200, bound, 200, 50);
            answerButton.setFont(new Font("Arial Black", Font.BOLD, 14));
            answerButton.setBackground(Color.lightGray);
            answerButton.addActionListener(e -> changeQuestion(answer));
            buttons.add(answerButton);
            bound += 75;
        }
        addButtons();
    }
}

