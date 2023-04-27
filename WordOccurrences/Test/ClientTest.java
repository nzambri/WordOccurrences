

import CountEachWord.Client;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the functionality of the Client class.
 */
public class ClientTest {



    @Test
    void testCountWords() {
        String input = "The quick brown fox jumps over the lazy dog";
        Map<String, Integer> expectedOutput = new HashMap<>();
        expectedOutput.put("The", 1);
        expectedOutput.put("quick", 1);
        expectedOutput.put("brown", 1);
        expectedOutput.put("fox", 1);
        expectedOutput.put("jumps", 1);
        expectedOutput.put("over", 1);
        expectedOutput.put("the", 1);
        expectedOutput.put("lazy", 1);
        expectedOutput.put("dog", 1);
        Map<String, Integer> result = Client.countWords(input);
        assertEquals(expectedOutput, result);
    }
}
