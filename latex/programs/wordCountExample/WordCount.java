import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> result = new HashMap<>();
        String[] words = args[0].split("\\s+");
        for (String word : words) {
            int count = result.getOrDefault(word, 0);
            result.put(word.toLowerCase(), count + 1);
        }
        for (String word : result.keySet()) {
            System.out.println(word + ": " + result.get(word));
        }
    }
}
