package utils;

import users.Administrator;
import users.RegularUser;
import users.User;

import java.util.Scanner;

public class Menu {

    public static void intro(){
        int check = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, what do you want to do?\n1 - Sign Up\n2 - Sign In\n3 - Sign In as Admin\nPlease provide a number:");
        while (check == 0) {
            String input_command = sc.nextLine().trim();

            if (input_command.equalsIgnoreCase("1")) {
                check = 1;
                RegularUser.createUser();
            } else if (input_command.equalsIgnoreCase("2")){
                check = 1;
                RegularUser.login();
            } else if (input_command.equalsIgnoreCase("3")){
                Administrator.login();
                check = 1;
            } else{
                System.out.println("This is not a valid command, please try again.\nSign Up\nSign In\nSign In as Admin");
            }
        }
    }

    public static void UserMenu(String username){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Hello, " + username + "!\nWhat do you want to do now\n1 - See all available quizzes\n2 - See assigned quizzes\n3 - See quiz resultn\n4 - See results from last five quizzes\n5 - Exit the program\nPlease provide a number:");
        String input_command = sc.nextLine().trim();

        switch(input_command) {
            case "1":
                //get all available quizzes;
                System.out.println("What do you want to do now");
                break;
            case "2":
                //get all available quizzes;
                System.out.println("See all available quizzes");
                break;
            case "3":
                System.out.println("See assigned quizzes");
                break;
            case "4":
                System.out.println("See results from last five quizzes");
                break;
            case "5":
                System.out.println("Exit the program");
                break;
        }
    }
}
