import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        // Print program description
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program determines total number of characters in a line of text,");
        System.out.println("as well as number of times a specific character is used.");
        System.out.println("Program displays character's ASCII value.\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter line of text: ");
        String inputText = scanner.nextLine();

        System.out.print("Please enter character to check: ");
        char characterToCheck = scanner.next().charAt(0);
        scanner.close();

        int count = 0;
        for (char c : inputText.toCharArray()) {
            if (c == characterToCheck) {
                count++;
            }
        }

        System.out.println("\nNumber of characters in line of text: " + inputText.length());
        System.out.println("The character " + characterToCheck + " appears " + count + " time(s) in line of text.");
        System.out.println("ASCII value: " + (int) characterToCheck);
    }
}
