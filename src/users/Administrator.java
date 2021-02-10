package users;

import quiz.Quiz;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import quiz.Question;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Administrator extends User{

    public Administrator(String username, String password) {
        super(username, password);
    }

    private String fileFormat(String file){
        return String.format("%s.txt", file);
    }

    public void createQuiz(Quiz quiz){

    }

    public void assignQuiz(User user, Quiz quiz){
        List<Quiz> arrayList = new ArrayList<Quiz>();
        try{
            arrayList.addAll(user.getQuiz());
        }catch (NullPointerException e){
        }
        arrayList.add(quiz);
        user.setQuiz(arrayList);
    }

}
