HangmanGame
This is a simple implementation of the classic Hangman game in Java. The game offers different difficulty levels, and players can guess words until they either successfully guess the word or run out of attempts.

Project Structure
Main class (Main.java): Contains the main method to run the Hangman game. It handles user input for selecting the difficulty level and initiates the game.

HangmanGame class (HangmanGame.java): Represents the core game logic. It manages the state of the game, including the chosen word, guessed letters, and incorrect attempts.

WordProvider interface (WordProvider.java): Defines the contract for classes providing words for the game.

WordList and its subclasses (WordList.java, EasyWordList.java, MediumWordList.java, HardWordList.java): Implement the WordProvider interface and provide word lists for different difficulty levels.

How to Play
Run the Main class.
Select the desired difficulty level (Easy, Medium, or Hard) by entering the corresponding number.
Guess the letters to complete the hidden word.
Keep guessing until you either successfully guess the word or run out of attempts.
