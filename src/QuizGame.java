import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGame {

   
    private static final int TIME_LIMIT = 10;  
    private static Timer timer;
    private static boolean timeUp = false;
    

    static String[] questions = {
        "1. What is the capital of France?",
        "2. Who wrote 'Romeo and Juliet'?",
        "3. What is the largest planet in our solar system?",
        "4. What is the chemical symbol for water?",
        "5. How many continents are there on Earth?"
    };

    static String[][] options = {
        {"A. London", "B. Paris", "C. Rome", "D. Madrid"},
        {"A. Charles Dickens", "B. William Shakespeare", "C. Mark Twain", "D. Leo Tolstoy"},
        {"A. Earth", "B. Mars", "C. Jupiter", "D. Venus"},
        {"A. H2O", "B. O2", "C. CO2", "D. N2"},
        {"A. 5", "B. 6", "C. 7", "D. 8"}
    };

    static char[] correctAnswers = {'B', 'B', 'C', 'A', 'C'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        char[] userAnswers = new char[questions.length];

        System.out.println("Welcome to the Quiz Game!");

    
        for (int i = 0; i < questions.length; i++) {
            timeUp = false;

            
            System.out.println("\n" + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }

          
            startTimer(TIME_LIMIT);

            System.out.print("Enter your answer (A, B, C, or D) within " + TIME_LIMIT + " seconds: ");
            String answer = scanner.nextLine().toUpperCase();

            
            if (timeUp) {
                System.out.println("Time's up! No answer submitted.");
                userAnswers[i] = 'X';  
            } else if (answer.length() == 1 && answer.charAt(0) >= 'A' && answer.charAt(0) <= 'D') {
                userAnswers[i] = answer.charAt(0);
             
                timer.cancel();

                
                if (userAnswers[i] == correctAnswers[i]) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect!");
                }
            } else {
                System.out.println("Invalid answer! Moving to the next question.");
                userAnswers[i] = 'X';  
            }
        }

        
        System.out.println("\n--- Quiz Over! ---");
        System.out.println("Your final score is: " + score + "/" + questions.length);
        System.out.println("Here's a summary of your answers:");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Your answer: " + (userAnswers[i] == 'X' ? "No answer" : userAnswers[i]));
            System.out.println("Correct answer: " + correctAnswers[i]);
            System.out.println();
        }

        scanner.close();
    }

    
    public static void startTimer(int seconds) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int count = seconds;

            @Override
            public void run() {
                count--;
                if (count == 0) {
                    timeUp = true;
                    System.out.println("\nTime's up!");
                    timer.cancel();
                }
            }
        }, 0, 1000); 
    }
}
