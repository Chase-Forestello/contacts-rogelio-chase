// Incomplete - Java II - File I/O (grocery list applications)
// Complete - Java II - Exceptions and Error Handling (CLI could be improved)
// Complete - Java II - OOP Input Exercise
package util;

import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Input input = new Input();
//        System.out.println(input.getString("Enter a word:"));
//        System.out.println(input.yesNo("Enter 'yes' or 'y':"));
//        System.out.println(input.getInt(1, 10, "Enter an integer 1-10:"));
//        System.out.println(input.getInt("Enter an integer:"));
//        System.out.println(input.getDouble(1, 10, "Enter a double 1-10:"));
//        System.out.println(input.getDouble("Enter a double:"));
//        System.out.println(input.getBinary("Enter a binary number:"));
//        System.out.println(input.getHex("Enter a hexadecimal:"));
    }


    // Returns next string
    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public String getString() {
        String s = scanner.nextLine();
        return s;
    }


    // Returns true if the user input = "yes" or "y" else returns false.
    public boolean yesNo(String prompt) {
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes");
    }


    // Returns int or continue prompting the user until they are within range (1-10).
    public int getInt(int min, int max, String prompt) {
        System.out.print(prompt);
        boolean intRange;
        int userInt;
        do {
            userInt = 0;
            try {
                userInt = Integer.valueOf(getString());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                System.out.println(e.getMessage());
            }
            if (userInt > max || userInt < min) {
                System.out.print("Enter int within 1-10 range: ");
            }
            intRange = (userInt > max || userInt < min);
        } while (intRange);
        return userInt;
    }

    // Returns next int
    public int getInt(String prompt) {
//        while (true) {
            System.out.print(prompt);
            try {
                int userInput = Integer.valueOf(getString());
                return userInput;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                System.out.println(e.getMessage());
            }
//        }
                return getInt(prompt);
    }

    // Returns double or continue prompting the user until they are within range (1-10).
    // How to set up if statement to check for 1-10 while checking for exceptions?
    public double getDouble(double min, double max, String prompt) {
        System.out.print(prompt);
        boolean DoubleRange;
        double userDouble;
        do {
            userDouble = 0;
            try {
                userDouble = Double.valueOf(getString());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                System.out.println(e.getMessage());
            }
            if (userDouble > max || userDouble < min) {
                System.out.print("Enter double within 1-10 range: ");
            }
            DoubleRange = (userDouble > max || userDouble < min);
        } while (DoubleRange);
        return userDouble;
    }

    // Returns next double
    public double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.valueOf(getString());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBinary(String prompt) {
        int userInput;
        while (true) {
            System.out.print(prompt);
            try {
                userInput = Integer.valueOf(getString(), 2);
                return userInput;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                System.out.println(e.getMessage());
            }
        }
    }

    public long getHex(String prompt) {
        int userInput;
        while (true) {
            System.out.print(prompt);
            try {
                userInput = Integer.valueOf(getString(), 16);
                return userInput;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: ");
                System.out.println(e.getMessage());
            }
        }
    }


}


