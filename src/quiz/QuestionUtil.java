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

    private static final String QUESTIONS_DB = "questions";
    private static final String QUIZ_DB = "quizes";
    private static ArrayList<String> allQuestionsNames = new ArrayList();
    private static ArrayList<String> allQuizesNames = new ArrayList();
    private static ArrayList<Question> allQuestions = new ArrayList();
    private static ArrayList<Quiz> allQuizes = new ArrayList();
    
    //System
    public void startTheSystem(){
        this.allQuestionsNames = fillTheSystem(QUESTIONS_DB);
        this.allQuizesNames = fillTheSystem(QUIZ_DB);
        loadAllQuestions();
        loadAllQuizes();
    }

    public ArrayList<String> fillTheSystem(String db){
        ArrayList<String> result = new ArrayList();
        try {
            File questions = new File(Util.fileFormat(db));
            Scanner myReader = new Scanner(questions);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              result = new ArrayList<String>(Arrays.asList(data.split(",")));
            }
            myReader.close();
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("Could not get all questions");
            e.printStackTrace();
            return new ArrayList<String>();
        }
    }

    public void saveDataOnExit(){
        allQuestionsNames.clear();
        for (int i = 0; i < this.allQuestions.size(); i++) { 
            Question q = this.allQuestions.get(i);
            delete(q.getName());
            create(q.getName());
            save(q.getName(), q.toString());
            this.allQuestionsNames.add(q.getName());
        }

        delete(QUESTIONS_DB);
        create(QUESTIONS_DB);
        save(QUESTIONS_DB, String.join(",", allQuestionsNames));

        allQuizesNames.clear();
        for (int i = 0; i < this.allQuizes.size(); i++) {
            Quiz q = this.allQuizes.get(i);
            delete(q.getName());
            create(q.getName());
            save(q.getName(), String.join(",", q.getQuestions()));
            this.allQuizesNames.add(q.getName());
        }

        delete(QUIZ_DB);
        create(QUIZ_DB);
        save(QUIZ_DB, String.join(",", allQuizesNames));
    }

    //Quiz
    public void loadAllQuizes(){
        try {
            for (int i = 0; i < this.allQuizesNames.size(); i++) {
                File quiz = new File(Util.fileFormat(allQuizesNames.get(i)));
                Scanner myReader = new Scanner(quiz);
                while (myReader.hasNextLine()) {
                  String data = myReader.nextLine();
                  allQuizes.add(new Quiz(allQuizesNames.get(i), data.split(",")));
                  System.out.println(allQuizes.get(i).getName());
                  System.out.println(allQuizes.get(i).getName() + " " + Arrays.toString(allQuizes.get(i).getQuestions()));
                }
                myReader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not load all questions");
            e.printStackTrace();
        }
    }

    //Question
    public void loadAllQuestions(){
        try {
            for (int i = 0; i < this.allQuestionsNames.size(); i++) {
                File question = new File(Util.fileFormat(this.allQuestionsNames.get(i)));
                Scanner myReader = new Scanner(question);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] info = data.split("/");
                    this.allQuestions.add(new Question(allQuestionsNames.get(i), info[Question.QUESTION_HEAD_POSITION], Integer.parseInt(info[Question.QUESTION_RIGHT_ANSWER_POSITION]), info[Question.QUESTION_ANSWER_POSITION].split(",")));
                }
                myReader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not load all questions");
            e.printStackTrace();
        }
    }

    public void readQuestion(String questionName) {
        Util.validate(questionName);
        try {
            File question = new File(Util.fileFormat(questionName));
            Scanner myReader = new Scanner(question);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] questionInfo = data.split("/");
                String questionHead = questionInfo[Question.QUESTION_HEAD_POSITION];
                String questionAnswers = questionInfo[Question.QUESTION_ANSWER_POSITION];

                System.out.println(questionHead);
                System.out.println(questionAnswers);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Question with name " + questionName);
            e.printStackTrace();
        }
    }

    public void editQuestion(String questionName, String questionBody, int rightAnswer, String[] answers){

        Util.validate(questionName);
        Util.validate(questionBody);

        if(rightAnswer > Question.NUMBER_OF_ANSWERS && rightAnswer < Question.MIN_NUMBER_OF_ANSWERS){
           System.out.println("The right answer cannot be higher than 3 and lower than 1");
       } if(answers.length < Question.NUMBER_OF_ANSWERS){
           System.out.println("You cannot have less than 3 possible answers");
       }
        for (int i = 0; i < allQuestions.size(); i++) {
            if(allQuestions.get(i).getName().equals(questionName)){
               allQuestions.add(i, new Question(questionName, questionBody, rightAnswer, answers));
               delete(allQuestions.get(i).getName());
               create(allQuestions.get(i).getName());
               save(allQuestions.get(i).getName(), allQuestions.get(i).toString());
               break;
            }
        }
    }

    private void save(String name, String info){
        try {
            FileWriter writer = new FileWriter(Util.fileFormat(name));
            writer.write(info);
            writer.close();
            System.out.println( name + "Has been saved");
        } catch (IOException e){
            System.out.println("Could not save " + name);
            e.printStackTrace();
        }
    }

    private void create(String item){
        try {
            File file = new File(Util.fileFormat(item));
            if (file.createNewFile()) {
                System.out.println(item + "Has been created");
            } else {
                System.out.println("Could not save " + item + " ! It already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    private void delete(String item){
        try {
            File file = new File(Util.fileFormat(item));
            if (!file.delete()) {
                System.out.println("Failed to modify: " + item);
            }
        } catch(Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}