import java.util.Scanner;

public class ArrayCopy {

    public static void main(String[] args) {
        getRequirements(); // Call at start

        Scanner sc = new Scanner(System.in);
        int numLangs = 0;

        // Prompt for valid number of languages between 1 and 5
        while (true) {
            System.out.print("How many favorite programming languages do you have (min 1, max 5)? ");
            String input = sc.nextLine().trim();
            try {
                numLangs = Integer.parseInt(input);
                if (numLangs < 1 || numLangs > 5) {
                    System.out.println("Number must be between 1 and 5, inclusive. Please try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Not valid input! Please enter an integer between 1 and 5.");
            }
        }

        // Create the str1 array
        String[] str1 = new String[numLangs];

        // Prompt user to fill str1
        System.out.println("Please enter your " + numLangs + " favorite programming language(s):");
        for (int i = 0; i < numLangs; i++) {
            System.out.print("Language " + (i + 1) + ": ");
            str1[i] = sc.nextLine();
        }

        // Create str2 and copy elements
        String[] str2 = new String[numLangs];
        for (int i = 0; i < numLangs; i++) {
            str2[i] = str1[i];
        }

        // Print str1
        System.out.println("\nPrinting str1 array:");
        for (String lang : str1) {
            System.out.println(lang);
        }

        // Print str2
        System.out.println("\nPrinting str2 array:");
        for (String lang : str2) {
            System.out.println(lang);
        }

        System.out.println("\nThank you for using our program!");
        sc.close();
    }

    // -----------------------------------------------------------------------
    // getRequirements() method prints out requirements (as per your screenshots).
    // -----------------------------------------------------------------------
    public static void getRequirements() {
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program: ss12_Array_Copy");
        System.out.println("Program Requirements:");
        System.out.println("1) Create a string array (str1), based upon the user's number of preferred programming");
        System.out.println("   languages (limit 5).");
        System.out.println("2) Create a string array (str2) based upon str1 array's size.");
        System.out.println("3) Copy str1 array elements to str2 array.");
        System.out.println("4) Print elements of both arrays using Java's enhanced for loop.");
        System.out.println();
    }
}
