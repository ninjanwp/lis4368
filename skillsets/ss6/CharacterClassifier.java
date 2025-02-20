import java.util.Scanner;

public class CharacterClassifier {
    public static void main(String[] args) {
        // Print program description
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program determines whether user-entered value is vowel, consonant,");
        System.out.println("special character, or integer.");
        System.out.println("Program displays character's ASCII value.\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter character: ");
        char inputChar = scanner.next().charAt(0);
        scanner.close();

        classifyCharacter(inputChar);
    }

    public static void classifyCharacter(char inputChar) {
        int asciiValue = (int) inputChar;
        if (Character.isDigit(inputChar)) {
            System.out.println(inputChar + " is integer. ASCII value: " + asciiValue);
        } else if ("aeiouAEIOU".indexOf(inputChar) != -1) {
            System.out.println(inputChar + " is vowel. ASCII value: " + asciiValue);
        } else if (Character.isLetter(inputChar)) {
            System.out.println(inputChar + " is consonant. ASCII value: " + asciiValue);
        } else {
            System.out.println(inputChar + " is special character. ASCII value: " + asciiValue);
        }
    }
}
