package Task7;

import java.util.*;

public class FrequencyDictionary {
    private final Map<String, Integer> dictionary;

    public FrequencyDictionary() {
        this.dictionary = new HashMap<String, Integer>();

    }

    public void analyze(String sequence) {
        String[] words = sequence.split(" ");
        for (String w : words) {
            this.dictionary.merge(w, 1, Integer::sum);
        }
    }

    public Map<String, Integer> getDictionary() {
        return dictionary;
    }
}
