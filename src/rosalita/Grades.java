package rosalita;

import java.util.Scanner;

public class Grades {
    
    public void getGrades (){
    
    Scanner input = new Scanner(System.in);
    
    String name;
    int m, s, e, c, tm;
    float totalAvg;
    
    
    System.out.print("Enter your full name: ");
    name = input.next();
    
    System.out.println("Enter Marks in: ");
    System.out.println("Math: ");
    m = input.nextInt();
    System.out.println("Science: ");
    s = input.nextInt();
    System.out.println("English: ");
    e = input.nextInt();
    System.out.println("Computer: ");
    c = input.nextInt();
    
    System.out.println("===========================================");
    System.out.println("Grade Details");
    System.out.println("===========================================");
    
    tm = m + s + e + c;
    
    totalAvg = tm/4;
    
    
    System.out.println("Name : "+name);
    System.out.println("Total Marks: "+tm);
    System.out.println("Total Average: "+totalAvg);
    
    if(totalAvg >= 3.0){
        System.out.println("You Passed!");
    }else{
        System.out.println("You Failed");
    }
    
}
