import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> result = new HashMap<>();
        String[] words = args[0].split("\\s+");
        int numberOfWords = words.length;
        System.out.println("There are " + numberOfWords
        + " words in total.");
        for (String word : words) {
            int count = result.getOrDefault(word, 1);
            result.put(word.toLowerCase(), count + 1);
        }
        int uniqueWords = result.size();
        System.out.println("Of these " + numberOfWords + " words "
         + uniqueWords + " are unique.");
        System.out.println("The unique words are: ");
        for (String word : result.keySet()) {
            System.out.println(word + ": " + result.get(word));
        }
    }
}
