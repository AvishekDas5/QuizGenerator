package com.quizgenerator;

import java.util.Scanner;

/**
 * Optimized quiz generator with better performance and resource management
 */
public class QuizGenerator {
    private final Scanner scanner = new Scanner(System.in);

    public void startQuiz(Quiz quiz) {
        System.out.println("\n" + Constants.SEPARATOR_50);
        System.out.println("STARTING QUIZ: " + quiz.getName().toUpperCase());
        System.out.println("Total Questions: " + quiz.getTotalQuestions());
        System.out.println(Constants.SEPARATOR_50);

        int score = 0;
        var questions = quiz.getQuestions();

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            question.displayQuestion(i + 1);

            System.out.print("\nYour answer (A/B/C/D): ");
            char userAnswer = getUserAnswer();

            if (question.isCorrect(userAnswer)) {
                System.out.println("✓ Correct!");
                score++;
            } else {
                System.out.println("✗ Incorrect! Correct answer: " +
                        question.getCorrectAnswer());
            }
        }

        displayResults(score, quiz.getTotalQuestions());
    }

    private char getUserAnswer() {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'D') {
                return input.charAt(0);
            }
            System.out.print("Invalid input! Enter A, B, C, or D: ");
        }
    }

    private void displayResults(int score, int totalQuestions) {
        double percentage = (double) score / totalQuestions * 100;

        System.out.println("\n" + Constants.SEPARATOR_40);
        System.out.println("QUIZ RESULTS");
        System.out.println(Constants.SEPARATOR_40);
        System.out.println("Score: " + score + "/" + totalQuestions);
        System.out.printf("Percentage: %.1f%%\n", percentage);

        String grade = getGrade(percentage);
        System.out.println("Grade: " + grade);

        System.out.println("\nPerformance Feedback:");
        System.out.println(getFeedback(percentage));

        System.out.println(Constants.SEPARATOR_40);
    }

    private String getGrade(double percentage) {
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        return "F";
    }

    private String getFeedback(double percentage) {
        if (percentage >= 90) return "🌟 Excellent! Outstanding performance!";
        if (percentage >= 80) return "👍 Very Good! Well done!";
        if (percentage >= 70) return "👌 Good! Keep it up!";
        if (percentage >= 60) return "📚 Fair. Consider reviewing the material.";
        return "📖 Needs improvement. Study more and try again!";
    }
}
