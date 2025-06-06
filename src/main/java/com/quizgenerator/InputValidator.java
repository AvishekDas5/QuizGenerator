package com.quizgenerator;

import java.util.Scanner;

/**
 * Centralized input validation with optimized error handling
 */
public class InputValidator {

    // Prevent instantiation
    private InputValidator() {}

    public static int getValidChoice(Scanner scanner, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= max) {
                    return choice;
                }
                System.out.print("❌ Invalid choice! Enter 1-" + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("❌ Invalid input! Enter a number 1-" + max + ": ");
            }
        }
    }

    public static int getValidChoiceFromOne(Scanner scanner, int max) {
        return getValidChoice(scanner, max);
    }

    public static char getValidAnswer(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'D') {
                return input.charAt(0);
            }
            System.out.print("❌ Invalid! Enter correct answer (A/B/C/D): ");
        }
    }
}
