
# Quiz Generator Application

A professional command-line quiz generator application built in Java with Maven, featuring persistent storage, optimized performance, and an intuitive user interface.

## 🎯 Features

- **Interactive CLI Interface** - User-friendly command-line experience with emojis and clear navigation
- **Persistent Storage** - All quizzes automatically saved and loaded between sessions
- **Sample Quizzes** - 6 pre-loaded quizzes covering various topics
- **Custom Quiz Creation** - Create your own quizzes with multiple-choice questions
- **Automatic Scoring** - Real-time feedback with grades and performance analysis
- **Thread-Safe Operations** - Optimized for concurrent access and high performance
- **Cross-Platform** - Works on Windows, macOS, and Linux

## 📚 Pre-loaded Sample Quizzes

1. **Java Programming Basics** (5 questions) - Fundamental Java concepts
2. **World Geography** (6 questions) - Countries, capitals, and landmarks
3. **General Science** (5 questions) - Physics, chemistry, and biology
4. **World History** (5 questions) - Major historical events and figures
5. **Mathematics Fundamentals** (5 questions) - Basic math and algebra
6. **Sports Knowledge** (6 questions) - Popular sports and Olympic facts

## 🛠️ Technology Stack

- **Language**: Java 21
- **Build Tool**: Maven 3.x
- **Architecture**: Modular design with separation of concerns
- **Storage**: Java serialization with buffered I/O
- **Performance**: Thread-safe collections and optimized memory management

## 📋 Prerequisites

- Java 21 or higher
- Maven 3.6 or higher (optional, for building)
- Command-line terminal
- Minimum 512MB RAM
- 10MB disk space

## 🚀 Quick Start

### Option 1: Using the Batch Script (Recommended)

1. **Clone or download** the project
2. **Navigate** to the project directory
3. **Double-click** `run.bat` (Windows) or run `./run.sh` (Linux/Mac)

```


# Windows

run.bat

# Linux/Mac

./run.sh

```

### Option 2: Using Maven Commands

```


# Navigate to project directory

cd QuizGenerator

# Build and run

mvn clean package
java -jar target/quiz-generator-1.0.0.jar

```

### Option 3: Direct Java Compilation

```


# Navigate to source directory

cd src/main/java

# Compile

javac com/quizgenerator/*.java

# Run

java com.quizgenerator.Main

```

## 📖 Usage Guide

### Main Menu Options

1. **📝 Create New Quiz** - Build custom quizzes with your own questions
2. **🎮 Take Quiz** - Attempt any available quiz with scoring
3. **📋 View All Quizzes** - List all quizzes with question counts
4. **🗑️ Delete Quiz** - Remove quizzes (including samples)
5. **❓ Help** - Display detailed help documentation
6. **🚪 Exit** - Save data and close application

### Creating a Quiz

1. Select option 1 from the main menu
2. Enter a unique quiz name
3. Specify the number of questions (1-50)
4. For each question:
   - Enter the question text
   - Provide 4 multiple-choice options (A, B, C, D)
   - Specify the correct answer

### Taking a Quiz

1. Select option 2 from the main menu
2. Choose from the list of available quizzes
3. Answer each question by entering A, B, C, or D
4. View your results with:
   - Score and percentage
   - Letter grade (A+ to F)
   - Performance feedback
   - Correct answers for missed questions

## 🏗️ Project Structure

```

QuizGenerator/
├── pom.xml                    \# Maven configuration
├── run.bat                    \# Windows startup script
├── run.sh                     \# Linux/Mac startup script
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── quizgenerator/
│                   ├── Constants.java          \# UI constants
│                   ├── DefaultQuizLoader.java  \# Sample quiz data
│                   ├── FileManager.java        \# File I/O operations
│                   ├── InputValidator.java     \# Input validation
│                   ├── Main.java              \# Application entry point
│                   ├── MenuHandler.java       \# Menu operations
│                   ├── Question.java          \# Question model
│                   ├── Quiz.java              \# Quiz model
│                   ├── QuizCreator.java       \# Quiz creation logic
│                   ├── QuizGenerator.java     \# Quiz execution engine
│                   └── QuizManager.java       \# Quiz management
├── target/                    \# Maven build output
├── data/
│   └── quizzes.dat           \# Persistent quiz storage
└── README.md                 \# This file

```

## ⚡ Performance Features

- **Optimized Memory Usage** - Unmodifiable collections and efficient string handling
- **Thread-Safe Operations** - ConcurrentHashMap for multi-user scenarios
- **Batch I/O Operations** - Dirty flag pattern for efficient file operations
- **Buffered Streams** - 8KB buffers for faster file operations
- **Lazy Loading** - Resources loaded only when needed

## 🔧 Configuration

### Logging

The application uses Java's built-in logging with these levels:
- **INFO** - General application flow
- **WARNING** - Non-critical issues
- **SEVERE** - Critical errors

### Data Storage

- Quiz data is stored in `data/quizzes.dat`
- Uses Java serialization for reliable persistence
- Automatic backup on incompatible format detection

## 🐛 Troubleshooting

### Common Issues

**"No quizzes available"**
- Sample quizzes load automatically on first run
- Check if `data/` directory has proper permissions

**Build failures**
- Ensure Java 21+ is installed: `java --version`
- Verify Maven installation: `mvn --version`
- Clear Maven cache: Delete `~/.m2/repository`

**JAR file not found**
- Run `mvn clean package` to rebuild
- Check `target/` directory for the JAR file

**Permission denied (Linux/Mac)**
- Make script executable: `chmod +x run.sh`
- Ensure Java is in PATH: `which java`

### Getting Help

1. Use the built-in help: Select option 5 from main menu
2. Check the console output for error messages
3. Verify all files are in correct locations per project structure

## 🚀 Future Enhancements

- **Web Interface** - Browser-based version
- **Database Integration** - SQLite/H2 support
- **Import/Export** - JSON/CSV format support
- **Timer Functionality** - Timed quiz sessions
- **User Profiles** - Individual progress tracking
- **Question Types** - True/false, fill-in-the-blank
- **Multimedia Support** - Images and audio in questions

## 📄 License

This project is open source and available under the [MIT License](https://github.com/AvishekDas5/QuizGenerator/blob/main/LICENSE).

## 👨‍💻 Author

Created as a demonstration of modern Java development practices with Maven, featuring:
- Clean architecture and SOLID principles
- Comprehensive error handling
- Professional logging and documentation
- Cross-platform compatibility
- Production-ready code quality

---

**Happy Learning! 📚✨**

For questions or issues, please refer to the troubleshooting section or check the application's built-in help system.
