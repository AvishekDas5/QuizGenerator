package com.quizgenerator;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Represents a single quiz question with multiple-choice options
 * Optimized with better memory management
 */
public class Question implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String questionText;
    private final String[] options;
    private final char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = Arrays.copyOf(options, options.length);
        this.correctAnswer = correctAnswer;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect(char answer) {
        return Character.toUpperCase(answer) == correctAnswer;
    }

    public void displayQuestion(int questionNumber) {
        System.out.println("\nQuestion " + questionNumber + ": " + questionText);
        System.out.println(Constants.SEPARATOR_40);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char)('A' + i) + ". " + options[i]);
        }
    }
}
