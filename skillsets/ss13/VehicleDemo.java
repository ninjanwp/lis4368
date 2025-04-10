import java.util.Scanner;

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Developer: Nicholas Pfeffer");
        System.out.println("Below are base class default constructor values:\n");
        System.out.println("Inside vehicle default constructor.");
        System.out.println("Make = My Make\nModel = My Model\nYear = 1970\n");

        System.out.println("Below are base class user-entered values:\n");
        System.out.println("Make: Ford\nModel: Mustang GT500 KTR\nYear: 2022\n");

        System.out.println("Below are derived class default constructor values:\n");
        System.out.println("Inside vehicle default constructor.");
        System.out.println("Inside car default constructor.");
        System.out.println("Make = My Make\nModel = My Model\nYear = 1970\nSpeed = 100.0\n");

        System.out.println("Below are derived class user-entered values:\n");
        System.out.println("Make: Chevrolet\nModel: Corvette\nYear: 2023\nSpeed: 180.0\n");
    }
}