package quiz;
import java.util.ArrayList;
import java.util.Arrays;
import utils.Util;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;
import java.io.FileNotFoundException;

public class QuestionUtil {

    private static String QUESTIONS_DB = "questions";
    private static ArrayList<String> allQuestionsNames = new ArrayList();
    private static ArrayList<String> allQuizesNames = new ArrayList();
    private static ArrayList<Question> allQuestions = new ArrayList();
    private static ArrayList<Quiz> allQuizes = new ArrayList();

    public void getAllQuestions(){
        try {
            File questions = new File(Util.fileFormat(QUESTIONS_DB));
            Scanner myReader = new Scanner(questions);
            while (myReader.hasNextLine()) {
            this.allQuestionsNames = myReader.split(",");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not get all questions");
            e.printStackTrace();
        }
    }

    public void loadAllQuestions(ArrayList<String> questions){
        try {
            for (int i = 0; i < questions.size(); i++) {
                File question = new File(Util.fileFormat(questions.get(i)));
                Scanner myReader = new Scanner(question);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] info = data.split("/");
                    System.out.println(info.toString());
                    Question q = new Question(questions.get(i), info[Question.QUESTION_HEAD_POSITION], Integer.parseInt(info[Question.QUESTION_RIGHT_ANSWER_POSITION]), info[Question.QUESTION_ANSWER_POSITION].split(","));
                    allQuestions.add(q);
                }
                myReader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not load all questions");
            e.printStackTrace();
        }
    }
}