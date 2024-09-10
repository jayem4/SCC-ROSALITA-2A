package rosalita;

import java.util.Arrays;

public class Accounts {
    
    int id;
    String fname, lname, email, username, pass;

   
    public void addAccount(int id, String fname, String lname, String email, String username, String password) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.username = username;
        this.pass = password;
    }

   
    public void viewAccount() {
        System.out.printf("%-10d %-10s %-10s %-20s %-13s %-10s\n",
            this.id, this.fname, this.lname, this.email, this.username, this.pass);
    }

   
    public boolean passwordVerify(String password) {
        char element;
        int digit = 0, upperCase = 0;
        String[] commonPasswords = {"admin", "1234", "password"};

       
        if (password.length() < 8) {
            System.out.println("Password must have at least 8 characters.");
            return false;
        }

       
        if (Arrays.asList(commonPasswords).contains(password)) {
            System.out.println("Password is too common.");
            return false;
        }

       
        for (int x = 0; x < password.length(); x++) {
            element = password.charAt(x);
            if (Character.isDigit(element)) {
                digit++;
            } else if (Character.isUpperCase(element)) {
                upperCase++;
            }
        }

        if (upperCase == 0) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }

        if (digit == 0) {
            System.out.println("Password must contain at least one number.");
            return false;
        }

        // Check for special characters
        if (password.matches("[a-zA-Z0-9]+")) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }

        return true;
    }

   
    
}
