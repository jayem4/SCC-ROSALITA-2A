import java.util.Scanner;

public class Grades {

    private String id;
    private String name;
    private int math, sci, eng, com;

    public void getGrade() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        id = input.nextLine();
        System.out.print("Enter your full name: ");
        name = input.nextLine();
        System.out.print("Enter Marks in:\n");
        System.out.print("Math: ");
        math = input.nextInt();
        System.out.print("Science: ");
        sci = input.nextInt();
        System.out.print("English: ");
        eng = input.nextInt();
        System.out.print("Computer: ");
        com = input.nextInt();

        printGradeDetails();
    }

    public String getId() {
        return id;
    }

    public void printGradeDetails() {
        int totalMarks = math + sci + eng + com;
        double averageMarks = totalMarks / 4.0;

        System.out.println("-------------------");
        System.out.println("Grade Detail");
        System.out.println("-------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Total Average: " + averageMarks);
        System.out.println("-------------------");
    }

    public void editGrade() {
        Scanner input = new Scanner(System.in);

        System.out.println("Edit Marks for " + name);
        System.out.print("Enter new marks in Math: ");
        math = input.nextInt();
        System.out.print("Enter new marks in Science: ");
        sci = input.nextInt();
        System.out.print("Enter new marks in English: ");
        eng = input.nextInt();
        System.out.print("Enter new marks in Computer: ");
        com = input.nextInt();

        System.out.println("Grades updated successfully.");
        printGradeDetails();
    }

    public void deleteGrade() {
        name = "";
        math = sci = eng = com = 0;

        System.out.println("Grade records deleted successfully.");
    }

    public static void main(String[] args) {
        grades[] gradeRecords = new grades[100];
        int recordCount = 0;
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Select an option:");
            System.out.println("1. Add Grades");
            System.out.println("2. View Grades");
            System.out.println("3. Edit Grades");
            System.out.println("4. Delete Grades");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    boolean addMore = true;
                    while (addMore) {
                        grades newGrade = new grades();
                        newGrade.getGrade();
                        gradeRecords[recordCount++] = newGrade;
                        System.out.print("Do you want to add another record? (yes/no): ");
                        String continueAdding = input.nextLine();
                        addMore = continueAdding.equalsIgnoreCase("yes");
                    }
                    break;

                case 2:
                    System.out.print("Enter student ID to view: ");
                    String viewId = input.nextLine();
                    boolean found = false;
                    for (int i = 0; i < recordCount; i++) {
                        if (gradeRecords[i] != null && gradeRecords[i].getId().equals(viewId)) {
                            gradeRecords[i].printGradeDetails();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Record with ID " + viewId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to edit: ");
                    String editId = input.nextLine();
                    found = false;
                    for (int i = 0; i < recordCount; i++) {
                        if (gradeRecords[i] != null && gradeRecords[i].getId().equals(editId)) {
                            gradeRecords[i].editGrade();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Record with ID " + editId + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = input.nextLine();
                    found = false;
                    for (int i = 0; i < recordCount; i++) {
                        if (gradeRecords[i] != null && gradeRecords[i].getId().equals(deleteId)) {
                            gradeRecords[i].deleteGrade();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Record with ID " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
    }
}