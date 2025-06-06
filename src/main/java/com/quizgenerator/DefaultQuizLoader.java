package com.quizgenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates default sample quizzes for immediate application use
 */
public class DefaultQuizLoader {

    public static List<Quiz> createDefaultQuizzes() {
        List<Quiz> defaultQuizzes = new ArrayList<>();

        defaultQuizzes.add(createJavaBasicsQuiz());
        defaultQuizzes.add(createWorldGeographyQuiz());
        defaultQuizzes.add(createGeneralScienceQuiz());
        defaultQuizzes.add(createHistoryQuiz());
        defaultQuizzes.add(createMathematicsQuiz());
        defaultQuizzes.add(createSportsQuiz());

        return defaultQuizzes;
    }

    private static Quiz createJavaBasicsQuiz() {
        Quiz quiz = new Quiz("Java Programming Basics");

        quiz.addQuestion(new Question(
                "Which of the following is the correct way to declare a variable in Java?",
                new String[]{"int x;", "variable int x;", "declare int x;", "x int;"},
                'A'
        ));

        quiz.addQuestion(new Question(
                "What is the default value of a boolean variable in Java?",
                new String[]{"true", "false", "null", "0"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "Which keyword is used to create a class in Java?",
                new String[]{"class", "Class", "new", "create"},
                'A'
        ));

        quiz.addQuestion(new Question(
                "What does JVM stand for?",
                new String[]{"Java Virtual Machine", "Java Variable Method", "Java Verified Module", "Java Version Manager"},
                'A'
        ));

        quiz.addQuestion(new Question(
                "Which of these is NOT a primitive data type in Java?",
                new String[]{"int", "float", "String", "boolean"},
                'C'
        ));

        return quiz;
    }

    private static Quiz createWorldGeographyQuiz() {
        Quiz quiz = new Quiz("World Geography");

        quiz.addQuestion(new Question(
                "What is the capital of Australia?",
                new String[]{"Sydney", "Melbourne", "Canberra", "Perth"},
                'C'
        ));

        quiz.addQuestion(new Question(
                "Which is the longest river in the world?",
                new String[]{"Amazon River", "Nile River", "Yangtze River", "Mississippi River"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "Mount Everest is located in which mountain range?",
                new String[]{"Andes", "Rocky Mountains", "Alps", "Himalayas"},
                'D'
        ));

        quiz.addQuestion(new Question(
                "Which country has the most time zones?",
                new String[]{"Russia", "United States", "China", "Canada"},
                'A'
        ));

        quiz.addQuestion(new Question(
                "What is the smallest country in the world?",
                new String[]{"Monaco", "Vatican City", "San Marino", "Liechtenstein"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "Which desert is the largest in the world?",
                new String[]{"Sahara", "Gobi", "Antarctic Desert", "Arabian Desert"},
                'C'
        ));

        return quiz;
    }

    private static Quiz createGeneralScienceQuiz() {
        Quiz quiz = new Quiz("General Science");

        quiz.addQuestion(new Question(
                "What is the chemical symbol for gold?",
                new String[]{"Go", "Gd", "Au", "Ag"},
                'C'
        ));

        quiz.addQuestion(new Question(
                "How many bones are there in an adult human body?",
                new String[]{"206", "208", "210", "212"},
                'A'
        ));

        quiz.addQuestion(new Question(
                "What is the speed of light in vacuum?",
                new String[]{"300,000 km/s", "299,792,458 m/s", "186,000 miles/s", "All of the above"},
                'D'
        ));

        quiz.addQuestion(new Question(
                "Which planet is known as the Red Planet?",
                new String[]{"Venus", "Mars", "Jupiter", "Saturn"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "What is the most abundant gas in Earth's atmosphere?",
                new String[]{"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"},
                'C'
        ));

        return quiz;
    }

    private static Quiz createHistoryQuiz() {
        Quiz quiz = new Quiz("World History");

        quiz.addQuestion(new Question(
                "In which year did World War II end?",
                new String[]{"1944", "1945", "1946", "1947"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "Who was the first person to walk on the moon?",
                new String[]{"Buzz Aldrin", "Neil Armstrong", "John Glenn", "Alan Shepard"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "The Great Wall of China was primarily built during which dynasty?",
                new String[]{"Tang Dynasty", "Song Dynasty", "Ming Dynasty", "Qing Dynasty"},
                'C'
        ));

        quiz.addQuestion(new Question(
                "Which ancient wonder of the world was located in Alexandria?",
                new String[]{"Hanging Gardens", "Lighthouse of Alexandria", "Colossus of Rhodes", "Temple of Artemis"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "The Renaissance period began in which country?",
                new String[]{"France", "Germany", "Italy", "Spain"},
                'C'
        ));

        return quiz;
    }

    private static Quiz createMathematicsQuiz() {
        Quiz quiz = new Quiz("Mathematics Fundamentals");

        quiz.addQuestion(new Question(
                "What is the value of pi approximately?",
                new String[]{"3.14", "3.141", "3.1416", "All are correct approximations"},
                'D'
        ));

        quiz.addQuestion(new Question(
                "What is 15% of 200?",
                new String[]{"25", "30", "35", "40"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "In a right triangle, what is the relationship between the sides called?",
                new String[]{"Pythagorean Theorem", "Law of Cosines", "Law of Sines", "Triangle Inequality"},
                'A'
        ));

        quiz.addQuestion(new Question(
                "What is the square root of 144?",
                new String[]{"11", "12", "13", "14"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "If x + 5 = 12, what is the value of x?",
                new String[]{"5", "6", "7", "8"},
                'C'
        ));

        return quiz;
    }

    private static Quiz createSportsQuiz() {
        Quiz quiz = new Quiz("Sports Knowledge");

        quiz.addQuestion(new Question(
                "How many players are on a basketball team on the court at one time?",
                new String[]{"4", "5", "6", "7"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "In which sport would you perform a slam dunk?",
                new String[]{"Volleyball", "Tennis", "Basketball", "Badminton"},
                'C'
        ));

        quiz.addQuestion(new Question(
                "How often are the Summer Olympic Games held?",
                new String[]{"Every 2 years", "Every 3 years", "Every 4 years", "Every 5 years"},
                'C'
        ));

        quiz.addQuestion(new Question(
                "What is the maximum score possible in ten-pin bowling?",
                new String[]{"200", "250", "300", "350"},
                'C'
        ));

        quiz.addQuestion(new Question(
                "In soccer, how many players are on the field for each team?",
                new String[]{"10", "11", "12", "13"},
                'B'
        ));

        quiz.addQuestion(new Question(
                "Which country hosted the 2016 Summer Olympics?",
                new String[]{"China", "United Kingdom", "Brazil", "Japan"},
                'C'
        ));

        return quiz;
    }
}
