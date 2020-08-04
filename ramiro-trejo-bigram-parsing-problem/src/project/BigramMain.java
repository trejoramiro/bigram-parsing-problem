package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class BigramWordParser {
    public static String[] parseString(String string) {
        String[] result = string.replaceAll("\\p{Punct}","") // remove punctuation
                .replaceAll("\\d","") // remove digits
                .replaceAll("[^\\w\\s]", "") // remove special characters
                .toLowerCase().split(" ");

        return result;
    }
}

class BigramGenerator {
    public static Map<String, Integer> generateBigrams(String sequence) throws Exception {
        if (sequence.length() == 0) {
            throw new Exception("Unable to generate bigrams for empty string.");
        }
        BigramWordParser bigramWordParser = new BigramWordParser();
        String[] words = bigramWordParser.parseString(sequence);

        return generateBigramCount(words);
    }

    private static Map<String, Integer> generateBigramCount(String[] words) {
        Map<String, Integer> bigrams = new LinkedHashMap<>();
        if (words.length == 1) {
            bigrams.put(words[0], 1);
            return bigrams;
        }
        int firstPosition = 0, secondPosition = 1;

        for (int i = secondPosition; i < words.length; i++) {
            String pairing = Stream.of(words[firstPosition], words[secondPosition])
                    .collect(Collectors.joining(" "));
            if (bigrams.containsKey(pairing)) {
                bigrams.replace(pairing, bigrams.get(pairing) + 1);
            } else {
                bigrams.put(pairing, 1);
            }
            firstPosition++;
            secondPosition++;
        }

        return bigrams;
    }
}

public class BigramMain {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(args[0]));

            String sourceContent = "";
            while (scanner.hasNextLine()) {
                sourceContent += scanner.nextLine();
            }

            try {
                BigramGenerator bigramGenerator = new BigramGenerator();
                Map<String, Integer> bigrams = bigramGenerator.generateBigrams(sourceContent);
                printHistogram(bigrams);
            } catch (Throwable t) {
                System.out.println(t.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file was not found.");
        }
    }

    private static void printHistogram(Map<String, Integer> bigrams) {
        System.out.println("\nHistogram:");
        bigrams.entrySet().forEach(element -> System.out.println(String.format("* " + '"' + "%s" + '"' + " %s", element.getKey(), element.getValue())));
    }

    public static BigramGenerator getBigramGeneratorInstance() {
        return new BigramGenerator();
    }

    public static BigramWordParser getBigramWordParserInstance() {
        return new BigramWordParser();
    }
}
