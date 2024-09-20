
package rosalita;



public class Accounts {
    
       Account[] accountList;
        int currentIndex;
        

    public Accounts(int size) {
        accountList = new Account[size];
        currentIndex = 0;
    }

    public boolean addAccount(Account account) {
        for (int i = 0; i < currentIndex; i++) {
            if (accountList[i].getEmail().equalsIgnoreCase(account.getEmail()) ||
                accountList[i].getUsername().equalsIgnoreCase(account.getUsername()) ||
                accountList[i].getPassword().equalsIgnoreCase(account.getPassword())) {
                System.out.println("Error: Duplicate email, username, or password not allowed.");
                return false;
            }
        }
        if (currentIndex < accountList.length) {
            accountList[currentIndex++] = account;
            return true;
        } else {
            System.out.println("Error: Account list is full.");
            return false;
        }
    }

    public void viewAccounts() {
        if (currentIndex == 0) {
            System.out.println("No accounts registered.");
        } else {
            for (int i = 0; i < currentIndex; i++) {
                System.out.println(accountList[i]);
            }
        }
    }

    public boolean isPasswordValid(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        String specialCharacters = "!@#$%^&*(),.?\":{}|<>";
        for (char ch : password.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') hasUpperCase = true;
            if (ch >= 'a' && ch <= 'z') hasLowerCase = true;
            if (ch >= '0' && ch <= '9') hasNumber = true;
            if (specialCharacters.indexOf(ch) >= 0) hasSpecialChar = true;
        }

        if (!hasUpperCase) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }
        if (!hasLowerCase) {
            System.out.println("Password must contain at least one lowercase letter.");
            return false;
        }
        if (!hasSpecialChar) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }
        if (!hasNumber) {
            System.out.println("Password must contain at least one number.");
            return false;
        }
        if (password.toLowerCase().contains("admin") || 
            password.toLowerCase().contains("password") || 
            password.contains("1234")) {
            System.out.println("Password must not contain common words like 'admin', 'password', or '1234'.");
            return false;
        }
        return true;
   

    }
}