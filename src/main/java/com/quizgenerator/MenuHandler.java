package com.quizgenerator;

import java.util.Scanner;

/**
 * Handles all menu operations and user interactions
 */
public class MenuHandler {
    private final Scanner scanner;
    private final QuizManager quizManager;
    private final QuizCreator quizCreator;

    public MenuHandler(Scanner scanner, QuizManager quizManager) {
        this.scanner = scanner;
        this.quizManager = quizManager;
        this.quizCreator = new QuizCreator(scanner, quizManager);
    }

    public void displayMainMenu() {
        System.out.println("\n" + Constants.SEPARATOR_35);
        System.out.println("🎯 QUIZ GENERATOR - MAIN MENU");
        System.out.println(Constants.SEPARATOR_35);
        System.out.println("1. 📝 Create New Quiz");
        System.out.println("2. 🎮 Take Quiz");
        System.out.println("3. 📋 View All Quizzes");
        System.out.println("4. 🗑️  Delete Quiz");
        System.out.println("5. ❓ Help");
        System.out.println("6. 🚪 Exit");
        System.out.println(Constants.SEPARATOR_35);
        System.out.print("Enter your choice (1-6): ");
    }

    public void createNewQuiz() {
        quizCreator.createNewQuiz();
    }

    public void takeQuiz() {
        var quizzes = quizManager.getAllQuizzes();

        if (quizzes.isEmpty()) {
            System.out.println("\n❌ No quizzes available.");
            return;
        }

        displayQuizList(quizzes);

        System.out.print("Select quiz (1-" + quizzes.size() + "): ");
        int choice = InputValidator.getValidChoiceFromOne(scanner, quizzes.size()) - 1;

        Quiz selectedQuiz = quizzes.get(choice);
        QuizGenerator generator = new QuizGenerator();
        generator.startQuiz(selectedQuiz);
    }

    public void viewAllQuizzes() {
        var quizzes = quizManager.getAllQuizzes();

        if (quizzes.isEmpty()) {
            System.out.println("\n❌ No quizzes available.");
            return;
        }

        System.out.println("\n" + Constants.SEPARATOR_60);
        System.out.println("📋 ALL AVAILABLE QUIZZES");
        System.out.println(Constants.SEPARATOR_60);

        for (int i = 0; i < quizzes.size(); i++) {
            Quiz quiz = quizzes.get(i);
            System.out.printf("%d. %-35s (%d questions)\n",
                    (i + 1), quiz.getName(), quiz.getTotalQuestions());
        }
        System.out.println(Constants.SEPARATOR_60);
        System.out.println("💾 All quizzes are automatically saved and will persist between sessions.");
    }

    public void deleteQuiz() {
        var quizzes = quizManager.getAllQuizzes();
        if (quizzes.isEmpty()) {
            System.out.println("\n❌ No quizzes available to delete.");
            return;
        }

        System.out.println("\n🗑️ Select quiz to delete:");
        System.out.println(Constants.SEPARATOR_40);

        for (int i = 0; i < quizzes.size(); i++) {
            Quiz quiz = quizzes.get(i);
            System.out.printf("%d. %s\n", (i + 1), quiz.getName());
        }
        System.out.println(Constants.SEPARATOR_40);

        System.out.print("Enter choice (1-" + quizzes.size() + "): ");
        int choice = InputValidator.getValidChoiceFromOne(scanner, quizzes.size()) - 1;

        String quizName = quizzes.get(choice).getName();

        System.out.print("⚠️ Are you sure you want to delete '" + quizName + "'? (y/N): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("y") || confirmation.equals("yes")) {
            quizManager.deleteQuiz(quizName);
            System.out.println("✅ Quiz '" + quizName + "' deleted successfully!");
        } else {
            System.out.println("❌ Deletion cancelled.");
        }
    }

    public void displayHelp() {
        System.out.println("\n" + Constants.SEPARATOR_65);
        System.out.println("🎯 QUIZ GENERATOR - HELP DOCUMENTATION");
        System.out.println(Constants.SEPARATOR_65);
        System.out.println("📋 COMMANDS:");
        System.out.println("1. Create New Quiz - Build a custom quiz with questions");
        System.out.println("2. Take Quiz - Attempt any available quiz");
        System.out.println("3. View All Quizzes - List all available quizzes");
        System.out.println("4. Delete Quiz - Remove any quiz permanently");
        System.out.println("5. Help - Display this help menu");
        System.out.println("6. Exit - Close the application");

        System.out.println("\n💾 PERSISTENCE:");
        System.out.println("• All quizzes are automatically saved to disk");
        System.out.println("• Your quizzes persist between application sessions");
        System.out.println("• Data is stored securely using Java serialization");

        System.out.println("\n✨ FEATURES:");
        System.out.println("• Multiple-choice questions (A, B, C, D)");
        System.out.println("• Automatic scoring with detailed feedback");
        System.out.println("• Robust data validation and error handling");
        System.out.println("• Thread-safe operations for concurrent access");

        System.out.println(Constants.SEPARATOR_65);
    }

    private void displayQuizList(java.util.List<Quiz> quizzes) {
        int estimatedCapacity = 174 + (quizzes.size() * 50);
        StringBuilder sb = new StringBuilder(estimatedCapacity);

        sb.append("\n📚 Available Quizzes:\n")
                .append(Constants.SEPARATOR_50)
                .append("\n");

        for (int i = 0; i < quizzes.size(); i++) {
            Quiz quiz = quizzes.get(i);
            sb.append(i + 1)
                    .append(". ")
                    .append(String.format("%-30s", quiz.getName()))
                    .append(" (")
                    .append(quiz.getTotalQuestions())
                    .append(" questions)\n");
        }

        sb.append(Constants.SEPARATOR_50)
                .append("\n");

        System.out.print(sb);
    }
}
