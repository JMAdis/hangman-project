package HangmanGame;

import java.util.Scanner;

public class HangmanGame {
    private String chosenWord;
    private char[] guessedLetters;
    private int incorrectAttempts;

    // Constructor that initializes the game with a randomly chosen word
    public HangmanGame(WordProvider wordProvider){
        chosenWord = wordProvider.getRandomWord();
        guessedLetters = new char[chosenWord.length()];
        incorrectAttempts = 0;
    }

    // Method to start and manage the Hangman game
    public void playGame(){
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver()) {
            displayWord();

            System.out.println("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            handleGuess(guess);
        }

        scanner.close();

        // Display the result of the game
        if (isWordGuessed()) {
            System.out.println("Yay! You guessed the word: " + chosenWord + " :D");
        } else {
            System.out.println("Sorry, you ran out of attempts :( the word was " + chosenWord);
        }
    }

    // Method to display the current state of the word, showing guessed letters and underscores
    private void displayWord() {
        for (char letter : guessedLetters) {
            System.out.print(letter == 0 ? "_" : letter + " ");
        }
        System.out.println();
    }

    // Method to handle the user's letter guess
    private void handleGuess(char guess) {
        if (chosenWord.contains(String.valueOf(guess))) {
            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guess){
                    guessedLetters[i] = guess;
                }
            }
            System.out.println("Good guess! :)");
        } else {
            incorrectAttempts++;
            System.out.println("Uh oh :( you have " + (6 - incorrectAttempts) + " guesses left. ");
        }
    }

    // Method to check if the game is over (either word guessed or too many incorrect attempts)
    private boolean isGameOver() {
        return incorrectAttempts >= 6 || isWordGuessed();
    }

    // Method to check if the word has been guessed
    private boolean isWordGuessed() {
        return new String(guessedLetters).equals(chosenWord);
    }
}
