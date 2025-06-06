package com.quizgenerator;

/**
 * Constants class to cache repeated string operations and avoid object creation
 */
public class Constants {
    public static final String SEPARATOR_50 = "=".repeat(50);
    public static final String SEPARATOR_40 = "=".repeat(40);
    public static final String SEPARATOR_35 = "-".repeat(35);
    public static final String SEPARATOR_60 = "=".repeat(60);
    public static final String SEPARATOR_65 = "=".repeat(65);

    // Prevent instantiation
    private Constants() {}
}
