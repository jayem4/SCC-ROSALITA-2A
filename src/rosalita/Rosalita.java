
package rosalita;

import java.util.Scanner;

public class Rosalita {

   
    public static void main(String[] args) {
          //PRODUCT//
         
      /* products[] pr = new products[100];
            
     Scanner sc = new Scanner(System.in);

       int nump, i;

       System.out.print("Enter the number of products: ");
       nump = sc.nextInt();

       for (i = 0; i < nump; i++) {
           System.out.println("Enter details of product " + (i + 1) + ": ");
            
           System.out.print("ID: ");
            int id = sc.nextInt();

          System.out.print("Name: ");
           String name = sc.next();

          System.out.print("Price: ");
            double pri = sc.nextDouble();

            System.out.print("Stock: ");
          /int st = sc.nextInt();
            
            System.out.print("Sold: ");
           int sold = sc.nextInt();
            
           products prod = new products();
           prod.addProduct(id, name, st, pri, sold);

            
          pr[i] = prod;
        }

       System.out.println("----------------------");
        System.out.println("\nProduct Details:/n");
       System.out.println("----------------------");
        
      System.out.printf("%-10s %-20s %-10s %-20s %-20s %-20s %-20s %-20s\n", 
                      //    "ID", "Name", "Stocks", "Price", "Items Sold", "Total Expected Profit", "Total Profit", "Status");
        
       for (i = 0; i < nump; i++) {
           pr[i].viewProduct();
        }

        sc.close(); 
    }
}
*/
      // GRADES//
     /* 
        public static void main(String[] args) {
             Grades grd = new Grades();
                 grd.getGrade();*/
     
     
      Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of accounts to register: ");
        int numberOfAccounts = scanner.nextInt();
        scanner.nextLine();

        Accounts accounts = new Accounts(numberOfAccounts);

        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.println("Enter details for account " + (i + 1) + ":");
       
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Username: ");
            String username = scanner.nextLine();

            String password;
            do {
                System.out.print("Password: ");
                password = scanner.nextLine();
                if (!accounts.isPasswordValid(password)) {
                    System.out.println("Invalid password. Please try again.");
                }
            } while (!accounts.isPasswordValid(password));

            Account newAccount = new Account(firstName, lastName, email, username, password);
            if (accounts.addAccount(newAccount)) {
                System.out.println("Account added successfully.");
            } else {
                System.out.println("Failed to add account due to duplicate information.");
            }
        }

        System.out.println("\nAll registered accounts:");
        accounts.viewAccounts(); 

        scanner.close();
    }
}

    
    