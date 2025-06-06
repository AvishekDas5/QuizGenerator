package com.quizgenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Optimized quiz manager with thread safety and dirty flag pattern
 */
public class QuizManager {
    private final Map<String, Quiz> quizzes = new ConcurrentHashMap<>();
    private final Set<String> quizNames = Collections.newSetFromMap(new ConcurrentHashMap<>());
    private final FileManager fileManager;
    private volatile boolean isDirty = false;

    public QuizManager() {
        this.fileManager = new FileManager();
        loadQuizzes();
    }

    private void loadQuizzes() {
        List<Quiz> loadedQuizzes = fileManager.loadQuizzes();

        if (!loadedQuizzes.isEmpty()) {
            for (Quiz quiz : loadedQuizzes) {
                String name = quiz.getName();
                quizzes.put(name, quiz);
                quizNames.add(name);
            }
        } else if (!fileManager.dataFileExists()) {
            createDefaultQuizzes();
        }
    }

    private void createDefaultQuizzes() {
        List<Quiz> defaultQuizzes = DefaultQuizLoader.createDefaultQuizzes();

        for (Quiz quiz : defaultQuizzes) {
            String name = quiz.getName();
            quizzes.put(name, quiz);
            quizNames.add(name);
        }

        isDirty = true;
        saveChanges();
    }

    public void saveQuiz(Quiz quiz) {
        String name = quiz.getName();
        quizzes.put(name, quiz);
        quizNames.add(name);
        isDirty = true;
    }

    public List<Quiz> getAllQuizzes() {
        return new ArrayList<>(quizzes.values());
    }

    public void deleteQuiz(String name) {
        quizzes.remove(name);
        quizNames.remove(name);
        isDirty = true;
    }

    public boolean quizExists(String name) {
        return quizNames.contains(name);
    }

    public void saveChanges() {
        if (isDirty) {
            fileManager.saveQuizzes(new ArrayList<>(quizzes.values()));
            isDirty = false;
        }
    }

    public int getQuizCount() {
        return quizzes.size();
    }
}
