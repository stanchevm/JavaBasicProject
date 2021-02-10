package users;

import quiz.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegularUser extends User {
    private HashMap<Quiz,Double> quizResult;
    private List<HashMap> completedQuizzes;

    public RegularUser(String username, String password) {
        super(username, password);
    }

    public void doAQuiz(Quiz quiz) {

        Double result = 0.0;
        this.quizResult = new HashMap<Quiz,Double>();
        this.quizResult.put(quiz, result);
        try {
            this.completedQuizzes.add(this.quizResult);
        }catch (NullPointerException e){
            this.completedQuizzes = new ArrayList<>();
            this.completedQuizzes.add(this.quizResult);
        }
    }

    public void getLastFive(){
        int lastFive = 0;
        if (this.completedQuizzes.size()<=5){
            lastFive = 0;
        }else{
            lastFive = this.completedQuizzes.size()-5;
        }
        System.out.println(this.completedQuizzes.size());
        for (int i = this.completedQuizzes.size(); i > lastFive ; i--) {
            HashMap<Quiz,Double> map = new HashMap<Quiz,Double>();
            map.putAll(this.completedQuizzes.get(i-1));
            for (Map.Entry<Quiz, Double> entry:map.entrySet()){
                System.out.println("Quiz-" + entry.getKey().getName() + ",result-" + entry.getValue());
            }
        }
    }
}
