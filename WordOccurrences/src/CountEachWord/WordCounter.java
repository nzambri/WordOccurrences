package CountEachWord;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides functionality for counting the occurrences of each word in a given text.
 * It takes a string of input text, splits it into individual words, and counts the occurrences of each word.
 * The resulting word counts are returned as a string in the format "word: count\n".
 *
 * @author Nick Zambri
 * @version 1.0
 * @since 2023-04-17
 */
public class WordCounter {
    private String inputText;

    /**
     * Constructs a new WordCounter object with the given input text.
     *
     * @param inputText The input text to count the occurrences of each word in.
     */
    public WordCounter(String inputText) {
        this.inputText = inputText;
    }

    /**
     * Counts the occurrences of each word in the input text and returns the word counts as a string.
     *
     * @return A string of word counts in the format "word: count\n".
     */
    public String getWordCounts() {
        Map<String, Integer> wordCounts = new HashMap<>();

        // Split input text into words
        String[] words = inputText.split("\\s+");

        // Count occurrences of each word
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        // Create a string representation of the word counts
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        return result.toString();
    }
}
