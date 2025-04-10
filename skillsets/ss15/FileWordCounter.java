import java.io.*;
import java.util.Scanner;

public class FileWordCounter {
    public static void main(String[] args) {
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program Requirements:");
        System.out.println("Program captures user input, writes to and reads from same file, and counts number of words in file.");
        System.out.println("Hint: use hasNext() method to read number of words (tokens).\n");

        try (Scanner scanner = new Scanner(System.in); PrintWriter writer = new PrintWriter("filecountwords.txt")) {
            System.out.println("Write text to file (type 'exit' to quit):");
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("exit")) {
                writer.println(input);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        try (Scanner fileScanner = new Scanner(new File("filecountwords.txt"))) {
            System.out.println("Reading from file: filecountwords.txt\n");
            int wordCount = 0;
            while (fileScanner.hasNext()) {
                System.out.println(fileScanner.nextLine());
                wordCount++;
            }
            System.out.println("Number of tokens: " + wordCount);
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}