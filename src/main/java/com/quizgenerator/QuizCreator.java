package com.quizgenerator;

import java.util.Scanner;

/**
 * Handles quiz creation logic with optimized input handling
 */
public class QuizCreator {
    private final Scanner scanner;
    private final QuizManager quizManager;

    public QuizCreator(Scanner scanner, QuizManager quizManager) {
        this.scanner = scanner;
        this.quizManager = quizManager;
    }

    public void createNewQuiz() {
        String quizName = getQuizName();
        if (quizName == null) return;

        Quiz quiz = new Quiz(quizName);
        int numQuestions = getNumberOfQuestions();

        for (int i = 1; i <= numQuestions; i++) {
            Question question = createQuestion(i);
            quiz.addQuestion(question);
        }

        quizManager.saveQuiz(quiz);
        System.out.println("\n✅ Quiz '" + quizName + "' created and saved successfully!");
    }

    private String getQuizName() {
        System.out.print("\n📝 Enter quiz name: ");
        String quizName = scanner.nextLine().trim();

        if (quizName.isEmpty()) {
            System.out.println("❌ Quiz name cannot be empty!");
            return null;
        }

        if (quizManager.quizExists(quizName)) {
            System.out.println("❌ A quiz with this name already exists!");
            return null;
        }

        return quizName;
    }

    private int getNumberOfQuestions() {
        System.out.print("Enter number of questions (1-50): ");
        return InputValidator.getValidChoice(scanner, 50);
    }

    private Question createQuestion(int questionNumber) {
        System.out.println("\n--- Question " + questionNumber + " ---");
        System.out.print("Enter question: ");
        String questionText = scanner.nextLine().trim();

        String[] options = new String[4];
        for (int j = 0; j < 4; j++) {
            System.out.print("Option " + (char)('A' + j) + ": ");
            options[j] = scanner.nextLine().trim();
        }

        System.out.print("Enter correct answer (A/B/C/D): ");
        char correctAnswer = InputValidator.getValidAnswer(scanner);

        return new Question(questionText, options, correctAnswer);
    }
}
