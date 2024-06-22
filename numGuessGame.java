import java.util.Scanner;

public class numGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean continuePlaying = true;
        int maximumTries = 10;
        int roundsPlayed = 0;
        int totalGuesses = 0;
        
        System.out.println("Guess The Number Game");

        while (continuePlaying) {
            int secretNumber = (int) (Math.random() * 100); // Generate random number between 0 and 99
            int currentGuesses = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("You have " + maximumTries + " attempts to guess the secret number.");

            while (currentGuesses < maximumTries && !hasGuessedCorrectly) {
                System.out.print("Enter your guess (between 0 and 100): ");
                int userGuess = scanner.nextInt();
                currentGuesses++;

                if (userGuess == secretNumber) {
                    System.out.println("Fantastic! You've guessed the secret number! It was " + userGuess + ".");
                    hasGuessedCorrectly = true;
                } 
                else if (userGuess < secretNumber) {
                    System.out.println("Your guess is too low, try a higher number.");
                } 
                else {
                    System.out.println("Your guess is too high, try a lower number.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Better luck next time! The secret number was " + secretNumber + ".");
            }

            roundsPlayed++;
            totalGuesses += currentGuesses;
            
            System.out.print("Would you like to play another round? (yes/no): ");
            continuePlaying = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Total rounds played: " + roundsPlayed);
        System.out.println("Total guesses made: " + totalGuesses);

        scanner.close();
    }
}
