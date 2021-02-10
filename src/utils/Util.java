package utils;

public class Util {
    public static boolean verifyInput(String inputString, String message) {
        if (inputString.equals(null)){
            System.out.println(message);
            return false;
        }else if (inputString.isEmpty()){
            System.out.println(message);
            return false;
        }else {
            return true;
        }
    }

    public static boolean validateUsername(String username) {
        //if it contains one special character, add 2 to total score
        if (username.matches("(?=.*[~,;!@#$%^=&*()_-]).*")) {
            System.out.println("Username cannot contain special character");
            return false;
        } else {
            return true;
        }
    }

    private static int calculatePasswordStrength(String password) {

        //total score of password
        int iPasswordScore = 0;

        if (password.length() < 8)
            return 0;
        else if (password.length() >= 10)
            iPasswordScore += 2;
        else
            iPasswordScore += 1;

        //if it contains one digit, add 2 to total score
        if (password.matches("(?=.*[0-9]).*"))
            iPasswordScore += 2;

        //if it contains one lower case letter, add 2 to total score
        if (password.matches("(?=.*[a-z]).*"))
            iPasswordScore += 2;

        //if it contains one upper case letter, add 2 to total score
        if (password.matches("(?=.*[A-Z]).*"))
            iPasswordScore += 2;

        //if it contains one special character, add 2 to total score
        if (password.matches("(?=.*[~!@#$%^&*()_-]).*"))
            iPasswordScore += 2;

        return iPasswordScore;

    }
}
