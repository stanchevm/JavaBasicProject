package quiz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import util.Util;

public class Quiz {

    public static final int MIN_NUNMBER_OF_QUESTIONS = 10;
    public static final int MAX_NUNMBER_OF_QUESTIONS = 20;
    private String name;
    private Question[] questions;
    private int questionCount = 0;

    public Quiz(String name, int numberOfQuestions) {
        if(name.equals(null)){
            System.out.println("Name cannot be null");
        } if(numberOfQuestions < MIN_NUNMBER_OF_QUESTIONS){
            numberOfQuestions = MIN_NUNMBER_OF_QUESTIONS;
        } if (numberOfQuestions > MAX_NUNMBER_OF_QUESTIONS){
            numberOfQuestions = MAX_NUNMBER_OF_QUESTIONS;
        }
        this.name = name;
        this.questions = new Question[numberOfQuestions];
    }

    public void addQuestion (Question question){
        if(this.questions.length <= this.questionCount){
            System.out.println("You have reached the maximum number of questions. Do you want to edit or remove question ?");
            return;
        }
        this.questions[this.questionCount] = question;
        this.questionCount ++;
    }

    public void createQuiz(Quiz quiz){
        try {
            File file = new File(Util.fileFormat(quiz.getName()));
            if(file.createNewFile()){
                System.out.println("Quiz " + quiz.getName() + " Has been saved");
            } else{
                System.out.println("Could not save " + quiz.getName() + " ! Quiz already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void saveQuiz(Quiz quiz){
        try {
            FileWriter writer = new FileWriter(Util.fileFormat(quiz.getName()));
            for (int i = 0; i < questions.length; i ++){
                writer.write(questions[i].getName());
            }
            writer.close();
            System.out.println("Quiz " + quiz.getName() + " Has been saved");
        } catch (IOException e){
            System.out.println("Could not save question " + quiz.getName());
            e.printStackTrace();
        }
    }

    public String getName() {
        return this.name;
    }
}
