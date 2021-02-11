package quiz;

import java.util.Arrays;
import utils.Util;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;
import java.io.FileNotFoundException;

public class Question {

    public static final int NUMBER_OF_ANSWERS = 3;
    public static final int MIN_NUMBER_OF_ANSWERS = 1;
    public static final int QUESTION_HEAD_POSITION = 0;
    public static final int QUESTION_ANSWER_POSITION = 1;
    public static final int QUESTION_RIGHT_ANSWER_POSITION = 2;
    private String name;
    private String questionBody;
    private int rightAnswer;
    private String[] answers = new String[NUMBER_OF_ANSWERS];

    public Question(String name, String questionBody, int rightAnswer, String[] answers) {
         validateName(name);
         if(rightAnswer > NUMBER_OF_ANSWERS && rightAnswer < MIN_NUMBER_OF_ANSWERS){
            System.out.println("The right answer cannot be higher than 3 and lower than 1");
        } if(answers.length < NUMBER_OF_ANSWERS){
            System.out.println("You cannot have less than 3 possible answers");
        }

         this.name = name;
         this.questionBody = questionBody;
         this.rightAnswer = rightAnswer;
         this.answers = answers;
    }

    public void createQuestion(Question question){
        try {
            File file = new File(Util.fileFormat(question.getName()));
            if(file.createNewFile()){
                System.out.println("Question " + question.getName() + " Has been saved");
            } else{
                System.out.println("Could not save " + question.getName() + " ! Question already exist");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    private void deleteQuestion(String questionName){
        try {
            File question = new File(Util.fileFormat(questionName));
            if (!question.delete()) {
                System.out.println("Failed to modify: " + questionName);
            }
        } catch(IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void saveQuestion(Question question){
        try {
            FileWriter writer = new FileWriter(Util.fileFormat(question.getName()));
            writer.write(question.toString());
            writer.close();
            System.out.println("Question " + question.getName() + " Has been saved");
        } catch (IOException e){
            System.out.println("Could not save question " + question.getName());
            e.printStackTrace();
        }
    }

    public void readQuestion(String questionName) {
        validateName(questionName);
        try {
            File question = new File(Util.fileFormat(questionName));
            Scanner myReader = new Scanner(question);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] questionInfo = data.split("/");
                String questionHead = questionInfo[QUESTION_HEAD_POSITION];
                String questionAnswers = questionInfo[QUESTION_ANSWER_POSITION];

                System.out.println(questionHead);
                System.out.println(questionAnswers);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Question with name " + questionName);
            e.printStackTrace();
        }
    }

    private void validateName(String name){
        if (name.equals(null) || name.isEmpty()) {
            System.out.println("Question name cannot be null");
        }
        return;
    }

    private boolean correctAnswer(int answer){
        if (answer == this.rightAnswer){
            System.out.println("Correcnt");
            return true;
        }
        System.out.println("False, right answer is number: " + this.rightAnswer);
        return false;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return questionBody + "/" + Arrays.toString(answers) + "/" + rightAnswer;
    }
    //edit question object question = new question with changes
}
