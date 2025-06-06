package com.quizgenerator;

import java.util.Scanner;

/**
 * Main entry point for the Quiz Generator Application
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuizManager quizManager = new QuizManager();
    private static final MenuHandler menuHandler = new MenuHandler(scanner, quizManager);
    private static volatile boolean running = true;

    public static void main(String[] args) {
        setupShutdownHook();
        displayWelcomeMessage();
        runMainLoop();
    }

    private static void setupShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            quizManager.saveChanges();
            scanner.close();
        }));
    }

    private static void displayWelcomeMessage() {
        System.out.println(Constants.SEPARATOR_50);
        System.out.println("    🎯 WELCOME TO QUIZ GENERATOR APPLICATION");
        System.out.println(Constants.SEPARATOR_50);

        int quizCount = quizManager.getQuizCount();
        if (quizCount > 0) {
            System.out.println("📚 Found " + quizCount + " quiz(es) ready to use!");
        }
    }

    private static void runMainLoop() {
        while (running) {
            menuHandler.displayMainMenu();
            int choice = InputValidator.getValidChoice(scanner, 6);

            switch (choice) {
                case 1 -> menuHandler.createNewQuiz();
                case 2 -> menuHandler.takeQuiz();
                case 3 -> menuHandler.viewAllQuizzes();
                case 4 -> menuHandler.deleteQuiz();
                case 5 -> menuHandler.displayHelp();
                case 6 -> exitApplication();
            }
        }
    }

    private static void exitApplication() {
        System.out.println("\n💾 Saving all data...");
        quizManager.saveChanges();
        System.out.println("👋 Thank you for using Quiz Generator!");
        System.out.println("📚 All your quizzes have been saved and will be available next time.");
        System.out.println("✨ Happy learning!");
        running = false;
        scanner.close();
    }
}
