package CountEachWord;

import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a method for counting the occurrences of each word in a string.
 *
 * @author Nick Zambri
 * @version 1.0
 * @since 2023-04-26
 */
public class WordOccurrences {

    /**
     * Counts the occurrences of each word in the specified string and returns a map of word-count pairs.
     *
     * @param text The text to count the occurrences of each word in.
     * @return A map of word-count pairs.
     */
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCounts = new HashMap<>();

        // Split the text into words
        String[] words = text.split("\\W+");

        // Count the occurrences of each word
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        return wordCounts;
    }
}
