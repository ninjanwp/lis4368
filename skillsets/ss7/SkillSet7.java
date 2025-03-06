import java.util.Scanner;

public class SkillSet7 {
    public static void main(String[] args) {
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program Requirements:");
        System.out.println("1. Counts number and types of characters from user-entered string.");
        System.out.println("2. Count: total, letters (upper-/lower-case), numbers, spaces, and other characters.");
        System.out.println("Hint: Helpful methods: isLetter(), isDigit(), isSpaceChar(), and others. ;)\n");

        // Prompt user for a string
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter string: ");
        String input = sc.nextLine();

        // Initialize counters
        int totalChars = 0;
        int letterCount = 0;
        int upperCount = 0;
        int lowerCount = 0;
        int digitCount = 0;
        int spaceCount = 0;
        int otherCount = 0;

        // Count characters
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            totalChars++;
            if (Character.isLetter(c)) {
                letterCount++;
                if (Character.isUpperCase(c)) {
                    upperCount++;
                } else {
                    lowerCount++;
                }
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else if (Character.isSpaceChar(c)) {
                spaceCount++;
            } else {
                otherCount++;
            }
        }

        // Display results
        System.out.println("\nYour string: \"" + input + "\" has the following number and types of characters:");
        System.out.println("Total number of characters: " + totalChars);
        System.out.println("Letter(s): " + letterCount);
        System.out.println("Upper-case letter(s): " + upperCount);
        System.out.println("Lower-case letter(s): " + lowerCount);
        System.out.println("Number(s): " + digitCount);
        System.out.println("Space(s): " + spaceCount);
        System.out.println("Other character(s): " + otherCount);

        sc.close();
    }
}
