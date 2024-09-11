
import java.util.*;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int round = 1;
        
        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;  
            int attempts = 5;  
            int score = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + ": Guess a number between 1 and 100. You have " + attempts + " attempts.");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    guessedCorrectly = true;
                    score = attempts * 10;  
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts--;
                System.out.println("Attempts remaining: " + attempts);
            }

            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts! The correct number was: " + randomNumber);
            }

            totalScore += score;
            System.out.println("Score for this round: " + score);
            System.out.println("Total score: " + totalScore);

            
            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();  
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }

            round++;
        }

        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
}
