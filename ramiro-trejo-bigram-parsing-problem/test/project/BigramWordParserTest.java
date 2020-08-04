package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("BigramWordParser should")
public class BigramWordParserTest {

    private String[] wordArray;
    private BigramWordParser bigramWordParser;

    @BeforeEach
    void setUp() {
        bigramWordParser = BigramMain.getBigramWordParserInstance();
        wordArray = new String[] {"the", "quick", "brown", "fox", "and", "the", "quick", "blue", "hare"};
    }

    @Test
    @DisplayName("generate string array for input string")
    void generateStringArrayForInputString() {
        String[] result = bigramWordParser.parseString("The quick brown fox and the quick blue hare");

        assertArrayEquals(wordArray, result);
    }

    @Test
    @DisplayName("generate string array if string contains punctuation")
    void generateStringArrayIfInputStringContainsPunctuation() {
        String[] result = bigramWordParser.parseString("32The quick{$%^&*()} brown fox, and the ,./<>?~`|Ⓒquick blue hare!!");

        assertArrayEquals(wordArray, result);
    }

    @Test
    @DisplayName("generate string array if string is empty")
    void generateStringArrayIfInputStringContainsEmptyString() {
        String[] result = bigramWordParser.parseString("");

        assertEquals(1, result.length);
    }
}
