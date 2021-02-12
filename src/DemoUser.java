import utils.Menu;

import java.util.ArrayList;
import java.util.List;

import quiz.Question;
import quiz.*;

public class DemoUser {
    public static void main(final String[] args) {
/*        HashMap<String, HashMap> question1= new HashMap<String, HashMap>();
        HashMap<String, Boolean> answers1= new HashMap<String, Boolean>();
        question1.put("How high is mount Everest",answers1);
        answers1.put("8849",true);
        answers1.put("8611",false);
        answers1.put("8156",false);

        HashMap<String, HashMap> question2= new HashMap<String, HashMap>();
        HashMap<String, Boolean> answers2= new HashMap<String, Boolean>();
        question1.put("How high is mount K2",answers1);
        answers1.put("8849",false);
        answers1.put("8611",true);
        answers1.put("8156",false);

        HashMap<String, HashMap> question3= new HashMap<String, HashMap>();
        HashMap<String, Boolean> answers3= new HashMap<String, Boolean>();
        question1.put("How high is mount Manaslu",answers1);
        answers1.put("8849",false);
        answers1.put("8611",false);
        answers1.put("8156",true);*/

/*        Administrator admin = new Administrator("admin","admin");
        RegularUser johnnie = new RegularUser("joe","joe");
        RegularUser jack = new RegularUser("jack","jack");
        RegularUser jim = new RegularUser("jim","jim");
        Quiz quiz1 = new Quiz("Quiz 1",11);
        Quiz quiz2 = new Quiz("Quiz 2",12);
        Quiz quiz3 = new Quiz("Quiz 3",13);
        Quiz quiz4 = new Quiz("Quiz 4",13);
        Quiz quiz5 = new Quiz("Quiz 5",13);
        Quiz quiz6 = new Quiz("Quiz 6",13);
        Quiz quiz7 = new Quiz("Quiz 7",13);
        Quiz quiz8 = new Quiz("Quiz 8",13);
        Quiz quiz9 = new Quiz("Quiz 9",13);

        jim.doAQuiz(quiz1);
        jim.getLastFive();
        System.out.println("----------------------------");
        jim.doAQuiz(quiz2);
        jim.getLastFive();
        System.out.println("----------------------------");
        jim.doAQuiz(quiz3);
        jim.getLastFive();
        System.out.println("----------------------------");
        jim.doAQuiz(quiz4);
        jim.getLastFive();
        System.out.println("----------------------------");
        jim.doAQuiz(quiz5);
        jim.getLastFive();
        System.out.println("----------------------------");
        jim.doAQuiz(quiz6);
        jim.getLastFive();
        System.out.println("----------------------------");
        jim.doAQuiz(quiz7);
        jim.getLastFive();
        System.out.println("----------------------------");
        jim.doAQuiz(quiz8);
        jim.getLastFive();*/
        //Menu.intro();
        String[] array = {"90", "100", "OVER 9000"};
        // Question question = new Question("Math", "How much is 1 + 1", 1, array);
        // question.createQuestion(question);
        // question.saveQuestion(question);

        // question.readQuestion(question.getName());
        // ArrayList<String> demoquestion = new ArrayList<>();
        // demoquestion.add("Math");
        QuestionUtil qutil = new QuestionUtil();
        // qutil.loadAllQuestions(demoquestion);
        // String[] questions = {"q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9" ,"q10"};
        // Quiz quiz1 = new Quiz("Quiz1", questions);
        // quiz1.createQuiz(quiz1);
        // quiz1.saveQuiz(quiz1);
        qutil.startTheSystem();
        qutil.readQuestion("q1");
        qutil.editQuestion("q4", "How much Miro Weights?", 3, array);
        qutil.saveDataOnExit();

    }
}

//todo quizes from files, add edit question functon and fuction to clear and save files when exit

