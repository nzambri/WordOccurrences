package CountEachWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * This class represents a client application for sending a string to a server and receiving a map of word-count pairs.
 * It displays the input string and the resulting word-count pairs in a GUI using the GUI class.
 *
 * @author Nick Zambri
 * @version 1.0
 * @since 2023-04-26
 */
public class Client {

    public static void main(String[] args) {
        GUI gui = new GUI();
    }

    public static String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        reader.close();
        return stringBuilder.toString();
    }

    public static Map<String, Integer> countWords(String input) {
        return WordOccurrences.countWords(input);
    }
}
