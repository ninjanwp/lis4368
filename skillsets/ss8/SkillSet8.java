import java.util.Scanner;

public class SkillSet8 {
    public static void main(String[] args) {
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program Requirements:");
        System.out.println("1. Write an application that displays integer equivalents of uppercase letters.");
        System.out.println("2. Display character equivalents of ASCII values 48 - 122.");
        System.out.println("3. Display the character equivalent of ASCII value user input.");
        System.out.println("Note: Compare answers to http://www.asciitable.com\n");

        // 1) Display integer equivalents of uppercase letters A-Z
        System.out.println("Printing characters A-Z as ASCII values:");
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println("Character " + ch + " has ascii value " + (int)ch);
        }

        // 2) Display character equivalents of ASCII values 48 - 122
        System.out.println("\nPrinting ASCII values 48-122 as characters:");
        for (int i = 48; i <= 122; i++) {
            System.out.println("ASCII value " + i + " has character value " + (char)i);
        }

        // 3) Allow user ASCII-value input
        Scanner sc = new Scanner(System.in);
        System.out.println("\nAllowing user ASCII value input:");
        int asciiValue = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter ASCII value (32 - 127): ");
            String userInput = sc.nextLine();

            // Attempt to parse integer
            try {
                asciiValue = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                // Not a valid integer
                System.out.println("ASCII value must be >= 32 and <= 127.");
                continue; 
            }

            if (asciiValue < 32 || asciiValue > 127) {
                System.out.println("ASCII value must be >= 32 and <= 127.");
            } else {
                validInput = true;
            }
        }

        System.out.println("ASCII value " + asciiValue + " has character value " + (char)asciiValue);
        sc.close();
    }
}
