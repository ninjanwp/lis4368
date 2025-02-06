import java.util.Scanner;

public class SwapFloatsMethods
{
    public static void getRequirements()
    {
        System.out.println("Author: Nicholas Pfeffer");
        System.out.println("Program swaps two user-entered floating-point values.");
        System.out.println("Must have data validation and print numbers before/after swapping.\n");
    }

    public static void numberSwap()
    {
        Scanner sc = new Scanner(System.in);

        float num1 = getFloat(sc, "Enter num1: ");
        float num2 = getFloat(sc, "Enter num2: ");

        System.out.printf("\nBefore swap:%nnum1 = %.1f%nnum2 = %.1f%n", num1, num2);

        // Swap
        float temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.printf("%nAfter swap:%nnum1 = %.1f%nnum2 = %.1f%n", num1, num2);
    }

    // Helper method that validates float input
    private static float getFloat(Scanner sc, String prompt)
    {
        while(true)
        {
            System.out.print(prompt);
            try
            {
                return Float.parseFloat(sc.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input!\n");
                System.out.println("Please try again.");
            }
        }
    }
}
