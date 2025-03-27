import java.util.Scanner;
import java.text.DecimalFormat;

public class CompoundInterestCalculator {

    public static void main(String[] args) {
        getRequirements(); // Call at start

        Scanner sc = new Scanner(System.in);

        double principal = 0.0;
        double annualRate = 0.0;
        int years = 0;

        // Prompt for principal
        principal = getDoubleInput(sc, "Enter principal: $");

        // Prompt for annual interest rate
        annualRate = getDoubleInput(sc, "Enter interest rate (per year): ");

        // Prompt for years (must be an integer)
        years = getIntInput(sc, "Enter total time (in years): ");

        // Calculate final amount with monthly compounding
        // Formula: A = P * (1 + r/12)^(12 * t)
        // where r = annualRate / 100 (decimal form)
        double monthlyRate = annualRate / 100.0 / 12.0;
        double amount = principal * Math.pow((1 + monthlyRate), (12 * years));

        // Format output
        DecimalFormat moneyFormat = new DecimalFormat("$#,##0.00");
        DecimalFormat rateFormat = new DecimalFormat("#0.0#");

        System.out.println("\nInitial principal: " + moneyFormat.format(principal));
        System.out.println("Annual interest rate: " + rateFormat.format(annualRate) + "%");
        System.out.println("Number of years: " + years);
        System.out.println("Amount after " + years + " year(s): " + moneyFormat.format(amount));

        System.out.println("\nThank you for using our program!");
        sc.close();
    }

    // -----------------------------------------------------------------------
    // getRequirements() method prints out requirements (as per your screenshots).
    // -----------------------------------------------------------------------
    public static void getRequirements() {
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program: ss11_Compound_Interest_Calculator");
        System.out.println("Program Requirements:");
        System.out.println("1) Calculates amount of money saved for a period of years, at a *monthly*");
        System.out.println("   compounded interest rate.");
        System.out.println("2) Returned amount is formatted in U.S. currency, and rounded to two decimal places.");
        System.out.println("3) Must perform data validation for non-numeric values, as well as only integer values for years.");
        System.out.println();
    }

    /**
     * Gets a double value from user input, keeps retrying until valid.
     */
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

    /**
     * Gets an integer value from user input, keeps retrying until valid.
     */
    private static int getIntInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Not valid integer!");
            }
        }
    }
}
