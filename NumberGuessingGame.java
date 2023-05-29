import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        int round = 1;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Round " + round + ": Guess the number between " + minRange + " and " + maxRange);

            int attempts = 0;
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("The number is higher than your guess.");
                } else {
                    System.out.println("The number is lower than your guess.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("You have reached the maximum number of attempts. The correct number was " + targetNumber + ".");
                }
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }

            round++;
        }

        System.out.println("Game over! Your total score is " + score);
        scanner.close();
    }
}