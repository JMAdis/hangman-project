package HangmanGame;

import java.util.Random;

// An abstract class implementing the WordProvider interface
abstract class WordList implements WordProvider{
    private String[] words;

    // Constructor to initialize the WordList with an array of words
    public WordList(String[] words) {
        this.words = words;
    }

    // Implementation of the getRandomWord method from the WordProvider interface
    @Override
    public String getRandomWord(){
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
