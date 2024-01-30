package HangmanGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Creating Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Variable to store the user's chosen difficulty level
        int choice;

        // While loop to prompt the user until a valid input is received
        while (true) {
            try {
                System.out.println("Welcome to Hangman. Choose your difficulty level: ");
                System.out.println("1. Easy");
                System.out.println("2. Medium");
                System.out.println("3. Hard");

                choice = scanner.nextInt();

                // Checking if the user's input is within the valid range (1 to 3)
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 3.");
                }
                // Handling in case the user enters a non-integer input
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        WordProvider wordProvider;

        // Assigning the appropriate WordProvider based on the user's chosen difficulty level
        switch (choice) {
            case 1:
                wordProvider = new EasyWordList();
                break;
            case 2:
                wordProvider = new MediumWordList();
                break;
            case 3:
                wordProvider = new HardWordList();
                break;
            default:
                System.out.println("Please select a level... ");
                return;
        }

        // Creating the HangmanGame instance with the selected WordProvider & difficulty level and starting the game
        HangmanGame hangmanGame = new HangmanGame(wordProvider);
        hangmanGame.playGame();

        scanner.close();
    }
}