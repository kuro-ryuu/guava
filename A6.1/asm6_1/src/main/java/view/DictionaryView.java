package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Dictionary;

public class DictionaryView extends Application {
    private DictionaryController controller;

    @Override
    public void init() {
        Dictionary dictionary = new Dictionary();
        dictionary.addWord("Uno", "One");
        dictionary.addWord("Dos", "Two");
        dictionary.addWord("Tres", "Three");
        dictionary.addWord("Dres", "Four");
        controller = new DictionaryController(dictionary);
    }

    @Override
    public void start(Stage window) {
        Label title = new Label("Dictionary Search");
        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter a word");

        TextArea meaningArea = new TextArea();
        meaningArea.setEditable(false);
        meaningArea.setWrapText(true);

        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> showMeaning(wordInput, meaningArea));
        wordInput.setOnAction(event -> showMeaning(wordInput, meaningArea));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(title, wordInput, searchButton, meaningArea);

        Scene view = new Scene(layout, 420, 240);
        window.setTitle("Dictionary");
        window.setScene(view);
        window.show();
    }

    private void showMeaning(TextField wordInput, TextArea meaningArea) {
        try {
            String word = wordInput.getText();
            String meaning = controller.searchWord(word);
            meaningArea.setText(meaning == null ? "Not found" : meaning);
        } catch (IllegalArgumentException ex) {
            meaningArea.setText(ex.getMessage());
        }
    }
}
