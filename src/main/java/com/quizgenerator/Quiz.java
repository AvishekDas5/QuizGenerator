package com.quizgenerator;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a complete quiz containing multiple questions
 * Optimized with immutable collections and better memory management
 */
public class Quiz implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String name;
    private final List<Question> questions;

    public Quiz(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    @Override
    public String toString() {
        return name + " (" + questions.size() + " questions)";
    }
}
