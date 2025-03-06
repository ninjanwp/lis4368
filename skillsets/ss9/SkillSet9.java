import java.util.Scanner;

public class SkillSet9 {
    public static void main(String[] args) {
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program Requirements:");
        System.out.println("1. Returns letter grade, based upon user-entered numeric score.");
        System.out.println("2. Program checks for non-numeric and out of range values.");
        System.out.println("Note: Program is accurate to 6th fraction digit (i.e., 6 digits right of decimal point).\n");

        Scanner sc = new Scanner(System.in);
        double score = 0.0;
        boolean validScore = false;

        while (!validScore) {
            System.out.print("Please enter grade between 0 to 100, inclusive: ");
            String userInput = sc.nextLine();

            // Check if numeric
            try {
                score = Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Not valid number!");
                System.out.println("Please try again.");
                continue;
            }

            // Check range
            if (score < 0 || score > 100) {
                System.out.println("Out of range!");
            } else {
                validScore = true;
            }
        }

        // Display final results
        System.out.println("Score entered: " + score);

        // Compute letter grade (example scale—adjust if needed for exact matching)
        // The screenshot shows 92.999999 => Final grade: A-
        // so we can assume a typical grading scale:
        //   A  = 93-100
        //   A- = 90-92.999...
        //   B+ = 87-89.999...
        //   B  = 83-86.999...
        //   B- = 80-82.999...
        //   C+ = 77-79.999...
        //   C  = 73-76.999...
        //   C- = 70-72.999...
        //   D+ = 67-69.999...
        //   D  = 63-66.999...
        //   D- = 60-62.999...
        //   F  = below 60
        String letterGrade;
        if (score >= 93) {
            letterGrade = "A";
        } else if (score >= 90) {
            letterGrade = "A-";
        } else if (score >= 87) {
            letterGrade = "B+";
        } else if (score >= 83) {
            letterGrade = "B";
        } else if (score >= 80) {
            letterGrade = "B-";
        } else if (score >= 77) {
            letterGrade = "C+";
        } else if (score >= 73) {
            letterGrade = "C";
        } else if (score >= 70) {
            letterGrade = "C-";
        } else if (score >= 67) {
            letterGrade = "D+";
        } else if (score >= 63) {
            letterGrade = "D";
        } else if (score >= 60) {
            letterGrade = "D-";
        } else {
            letterGrade = "F";
        }

        System.out.println("Final grade: " + letterGrade);

        sc.close();
    }
}
