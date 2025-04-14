import java.util.*;

public class SentenceSorter {
    // Example usage

    public static void main(String[] args) {
        String[] input = {
            "d1 2 3",
            "love8 coding world",
            "a1 coding ninjas"
        };

        List<String> sorted = reOrderSentences(input);
        for (String s : sorted) {
            System.out.println(s);
        }
    }

    public static List<String> reOrderSentences(String[] sentences) {
        List<String> letterSentences = new ArrayList<>();
        List<String> numberSentences = new ArrayList<>();

        for (String sentence : sentences) {
            String[] parts = sentence.split(" ");
            if (Character.isLetter(parts[1].charAt(0))) {
                letterSentences.add(sentence);
            } else {
                numberSentences.add(sentence);
            }
        }

        // Sort letter sentences lexicographically by content, then identifier
        letterSentences.sort((a, b) -> {
            String[] aParts = a.split(" ", 2);
            String[] bParts = b.split(" ", 2);
            int cmp = aParts[1].compareTo(bParts[1]);
            if (cmp == 0) {
                return aParts[0].compareTo(bParts[0]);
            }
            return cmp;
        });

        // Combine both lists
        List<String> result = new ArrayList<>(letterSentences);
        result.addAll(numberSentences);
        return result;
    }

}
