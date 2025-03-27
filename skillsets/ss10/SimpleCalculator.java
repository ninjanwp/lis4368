import java.util.Scanner;
import java.text.DecimalFormat;

public class SimpleCalculator {

    public static void main(String[] args) {
        getRequirements(); // Call at start

        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#0.00");

        char operation = ' ';
        double num1 = 0.0;
        double num2 = 0.0;
        boolean validInput = false;

        // Prompt for operation until valid
        while (!validInput) {
            System.out.print("Enter mathematical operation "
                    + "(a=addition, s=subtraction, m=multiplication, d=division, e=exponentiation): ");
            String opInput = sc.nextLine().trim().toLowerCase();

            if (opInput.length() == 1) {
                char c = opInput.charAt(0);
                if (c == 'a' || c == 's' || c == 'm' || c == 'd' || c == 'e') {
                    operation = c;
                    validInput = true;
                } else {
                    System.out.println("Incorrect operation. Please enter correct operation.");
                }
            } else {
                System.out.println("Not valid input!");
            }
        }

        // Prompt for first number until valid
        num1 = getDoubleInput(sc, "Please enter first number: ");

        // Prompt for second number until valid
        // but if dividing, check for zero
        boolean secondNumValid = false;
        while (!secondNumValid) {
            num2 = getDoubleInput(sc, "Please enter second number: ");
            if (operation == 'd' && num2 == 0) {
                System.out.println("Cannot divide by zero!");
            } else {
                secondNumValid = true;
            }
        }

        // Perform calculation
        double result = 0.0;
        switch (operation) {
            case 'a':
                result = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + df.format(result));
                break;
            case 's':
                result = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + df.format(result));
                break;
            case 'm':
                result = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + df.format(result));
                break;
            case 'd':
                result = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = " + df.format(result));
                break;
            case 'e':
                result = Math.pow(num1, num2);
                System.out.println(num1 + " ^ " + num2 + " = " + df.format(result));
                break;
        }

        System.out.println("Thank you for using our program!");
        sc.close();
    }

    // -----------------------------------------------------------------------
    // getRequirements() method prints out requirements (as per your screenshots).
    // -----------------------------------------------------------------------
    public static void getRequirements() {
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program: ss10_Simple_Calculator");
        System.out.println("Program Requirements:");
        System.out.println("1) Program uses methods to add, subtract, multiply, and power floating-point numbers,");
        System.out.println("   rounded to two decimal places.");
        System.out.println("2) Program checks for non-numeric values, and division by zero.");
        System.out.println();
    }

    // Helper method to safely get a double from user input.
    private static double getDoubleInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Not valid number!");
            }
        }
    }
}
