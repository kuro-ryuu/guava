package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String, String> words = new LinkedHashMap<>();

    public void addWord(String word, String meaning) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("No words given");
        }

        if (meaning == null || meaning.isBlank()) {
            throw new IllegalArgumentException("No meanings given");
        }

        words.put(word.trim().toLowerCase(), meaning.trim());
    }

    public String searchWord(String word) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("No words provided");
        }

        return words.get(word.trim().toLowerCase());
    }
}
