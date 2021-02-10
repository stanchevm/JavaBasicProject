package quiz;

import java.util.Arrays;

public class Question {

    public static final int NUMBER_OF_ANSWERS = 3;
    public static final int MIN_NUMBER_OF_ANSWERS = 1;
    private String question;
    private int rightAnswer;
    private String[] answers = new String[NUMBER_OF_ANSWERS];

    public Question(String question, int rightAnswer, String[] answers) {
        if (question.equals(null)) {
            System.out.println("Question cannot be null");
        } if(rightAnswer > NUMBER_OF_ANSWERS && rightAnswer < MIN_NUMBER_OF_ANSWERS){
            System.out.println("The right answer cannot be higher than 3 and lower than 1");
        } if(answers.length < NUMBER_OF_ANSWERS){
            System.out.println("You cannot have less than 3 possible answers");
        }
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question ='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", rightAnswer=" + rightAnswer +
                '}';
    }
}
