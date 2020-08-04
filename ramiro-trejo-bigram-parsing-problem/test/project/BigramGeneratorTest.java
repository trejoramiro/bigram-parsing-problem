package project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("BigramsGenerator should")
class BigramGeneratorTest {

    private Map<String, Integer> bigrams;
    private BigramGenerator bigramGenerator;

    @BeforeEach
    void setUp() {
        bigramGenerator = BigramMain.getBigramGeneratorInstance();
        bigrams = new LinkedHashMap<>();
        bigrams.put("the quick", 2);
        bigrams.put("quick blue", 1);
        bigrams.put("blue hare", 1);
        bigrams.put("fox and", 1);
        bigrams.put("quick brown", 1);
        bigrams.put("and the", 1);
        bigrams.put("brown fox", 1);
    }


    @Test
    @DisplayName("throw an exception if given string is empty")
    void itShouldThrowExceptionIfEmptyString() {
        assertThrows(Exception.class, () -> bigramGenerator.generateBigrams(""));
    }

    @Test
    @DisplayName("generate a correct bigram if given string contains uppercase letters")
    void generateBigramsIfStringContainsUppercaase() throws Exception {
        Map<String, Integer> resultBigrams = bigramGenerator.generateBigrams("The quick brown fox and the quick blue hare");

        assertEquals(bigrams, resultBigrams);
    }

    @Test
    @DisplayName("generate a corrent bigrdam if given string contains punctuation")
    void generateBigramsIfStringContainsPunctuation() throws Exception {
        Map<String, Integer> resultBigrams = bigramGenerator.generateBigrams("32The quick{$%^&*()} brown !fox?, and the ,./<>?~`|Ⓒquick blue hare!!");

        assertEquals(bigrams, resultBigrams);
    }

    @Test
    @DisplayName("generate a correct bigram if given string contains only one word")
    void generateBigramsIfStringContainsOnlyOneString() throws Exception {
        bigrams = new HashMap<>();
        bigrams.put("the", 1);

        Map<String, Integer> resultBigrams =  bigramGenerator.generateBigrams("The");

        assertEquals(bigrams, resultBigrams);
    }

    @Test
    @DisplayName("generate a correct bigram if given string contains two words")
    void generateBigramsIfStringContainsTwoWords() throws Exception {
        bigrams = new HashMap<>();
        bigrams.put("the quick", 1);

        Map<String, Integer> resultBigrams =  bigramGenerator.generateBigrams("The quick");

        assertEquals(bigrams, resultBigrams);
    }
}
