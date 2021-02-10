package users;

import quiz.Quiz;
import utils.Menu;
import utils.Util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.List;

public class User {
    private static String filePath = "user_and_passwords.txt";
    private String username;
    private String password;
    private List<Quiz> quiz;

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }


    public static void createUser() {
        Scanner sc = new Scanner(System.in);
        String input_username = "";
        String input_password = "";
        Map<String, String> userList = new HashMap<String, String>();
        userList.putAll(getUsers());
        int userCheck = 0;
        do {
            int verify = 0;
            System.out.println("Username:");
            input_username = sc.nextLine();
            if (!Util.verifyInput(input_username, "Username cannot be blank")) {
                verify = 1;
            }
            ;
            if (!Util.validateUsername(input_username)) {
                verify = 1;
            }
            ;
            for (Map.Entry<String, String> entry : userList.entrySet()) {
                if (entry.getKey().equals(input_username)) {
                    System.out.println("User name already exists!");
                    verify = 1;
                    break;
                }
            }
            if (verify == 0) {
                userCheck = 1;
            }
        } while (userCheck == 0);

        userCheck = 0;

        do {
            int verify = 0;
            System.out.println("Password:");
            input_password = sc.nextLine().trim();
            if (!Util.verifyInput(input_password, "Password cannot be blank")) {
                verify = 1;
            }
            ;
            if (verify == 0) {
                userCheck = 1;
            }
        } while (userCheck == 0);
        User user = new User(input_username, input_password);
        Map<String, String> userPass = new HashMap<String, String>();
        userPass.put(input_username, input_password);
        System.out.println("User " + input_username + " has been created! You are now logged in");
//        saveUser(userPass);
        saveUser(input_username, input_password);
    }

    public static void login() {
        Map<String, String> userList = new HashMap<String, String>();
        userList.putAll(getUsers());
        int userCheck = 0;

        do {
            int verify = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Please, provide a user name:");
            String username = sc.nextLine();
            System.out.println("Please, provide a password:");
            String password = sc.nextLine();

            if (!Util.verifyInput(password, "Password cannot be blank")) {
                verify = 1;
            }
            ;
            if (!Util.verifyInput(username, "Username cannot be blank")) {
                verify = 1;
            }
            ;
            if (verify == 0) {
                for (Map.Entry<String, String> entry : userList.entrySet()) {
                    if (entry.getKey().equals(username) && entry.getValue().equals(password)) {
                        userCheck = 1;
                        break;
                    }
                }
                if (userCheck == 1) {
                    System.out.println("You are now logged in");
                    Menu.UserMenu(username);
                } else {
                    System.out.println("Incorrect username or password, please try again!");
                }
            }
        } while (userCheck == 0);
    }

    public static void saveUser(String key, String value) {
        try {
            Files.write(Paths.get(filePath), (key + "," + value + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("File does not exist!");
        }
    }

    public static Map<String, String> getUsers() {
        Map<String, String> userAndPassList = new HashMap<String, String>();

        try {
            File myObj = new File("user_and_passwords.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String keyValue = myReader.nextLine();
                int splitter = keyValue.indexOf(",");
                userAndPassList.put(keyValue.substring(0, splitter), keyValue.substring(splitter + 1));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return userAndPassList;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    protected String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }

    public  List<Quiz> getQuiz() {
        return quiz;
    }

    protected  void setQuiz(List<Quiz> quiz) {
        this.quiz = quiz;
    }
}

