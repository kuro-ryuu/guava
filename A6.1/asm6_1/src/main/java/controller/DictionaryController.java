package controller;

import model.Dictionary;
import view.DictionaryView;

public class DictionaryController {
    private final Dictionary dictionary;

    public DictionaryController(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String searchWord(String word) {
        return dictionary.searchWord(word);
    }

    public static void main(String[] args) {
        DictionaryView.launch(DictionaryView.class);
    }
}