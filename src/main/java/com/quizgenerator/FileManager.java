package com.quizgenerator;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles file I/O operations for quiz data persistence
 */
public class FileManager {
    private static final Logger LOGGER = Logger.getLogger(FileManager.class.getName());
    private static final String DATA_DIR = "data";
    private static final String QUIZ_FILE = "quizzes.dat";
    private final Path dataPath;
    private final Path quizFilePath;

    public FileManager() {
        this.dataPath = Paths.get(DATA_DIR);
        this.quizFilePath = dataPath.resolve(QUIZ_FILE);
        initializeDirectory();
    }

    private void initializeDirectory() {
        try {
            if (!Files.exists(dataPath)) {
                Files.createDirectories(dataPath);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error initializing data directory", e);
        }
    }

    public void saveQuizzes(List<Quiz> quizzes) {
        try (FileOutputStream fos = new FileOutputStream(quizFilePath.toFile());
             BufferedOutputStream bos = new BufferedOutputStream(fos, 8192);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(quizzes);

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error saving quizzes", e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Quiz> loadQuizzes() {
        if (!Files.exists(quizFilePath)) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream(quizFilePath.toFile());
             BufferedInputStream bis = new BufferedInputStream(fis, 8192);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Quiz>) obj;
            }

        } catch (InvalidClassException e) {
            LOGGER.warning("Incompatible quiz data format detected. Creating fresh data file.");
            try {
                Files.deleteIfExists(quizFilePath);
            } catch (IOException deleteException) {
                LOGGER.log(Level.SEVERE, "Failed to delete incompatible quiz file", deleteException);
            }
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error loading quizzes", e);
        }

        return new ArrayList<>();
    }

    public boolean dataFileExists() {
        return Files.exists(quizFilePath);
    }
}
