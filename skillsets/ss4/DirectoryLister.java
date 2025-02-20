import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class DirectoryLister {
    public static void main(String[] args) {
        // Print program description
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Program lists files and subdirectories of user-specified directory.\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    displayFileInfo(file);
                }
            } else {
                System.out.println("Could not retrieve file list.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    public static void displayFileInfo(File file) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("\nName: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Size (Bytes): " + file.length());
        System.out.println("Size (KB): " + df.format(file.length() / 1024.0));
        System.out.println("Size (MB): " + df.format(file.length() / (1024.0 * 1024.0)));
    }
}
