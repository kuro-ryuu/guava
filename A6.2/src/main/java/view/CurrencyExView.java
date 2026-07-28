package view;

import controller.CurrencyExController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.CurrencyEx;

public class CurrencyExView extends Application {
    private CurrencyExController controller;
    private TextField amountField;
    private TextField resultField;
    private ComboBox<String> fromCurrencyBox;
    private ComboBox<String> toCurrencyBox;
    private Label messageLabel;

    @Override
    public void init() {
        CurrencyEx currencyEx = new CurrencyEx();
        controller = new CurrencyExController(currencyEx);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Currency Converter");

        Label instructionLabel = new Label("Enter an amount");
        instructionLabel.setStyle("-fx-font-family: Sans-serif; -fx-font-size: 13px;");

        Label amountLabel = new Label("Amount to convert:");
        amountLabel.setStyle("-fx-font-family: Sans-serif; -fx-font-size: 13px;");
        amountField = new TextField();
        amountField.setPromptText("e.g. 100");
        amountField.setStyle("-fx-font-family: Sans-serif; -fx-font-size: 13px;");

        Label fromLabel = new Label("From:");
        fromLabel.setStyle("-fx-font-family: Sans-serif; -fx-font-size: 13px;");
        fromCurrencyBox = new ComboBox<>();
        fromCurrencyBox.setStyle("-fx-font-family: Sans-serif; -fx-font-size: 13px;");

        Label toLabel = new Label("To:");
        toLabel.setStyle("-fx-font-family: Sans-serif; -fx-font-size: 13px;");
        toCurrencyBox = new ComboBox<>();
        toCurrencyBox.setStyle("-fx-font-family: Sans-serif; -fx-font-size: 13px;");

        Label resultLabel = new Label("Converted amount:");
        resultLabel.setStyle("-fx-font-family: Sans-serif; -fx-font-size: 13px;");
        resultField = new TextField();
        resultField.setEditable(false);
        resultField.setStyle("-fx-font-family: Sans-serif; -fx-font-size: 13px;");

        Button convertButton = new Button("Convert");
        convertButton.setStyle("-fx-font-family: Sans-serif; -fx-font-size: 13px;");
        convertButton.setOnAction(event -> handleConvert());

        messageLabel = new Label();


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15));
        grid.add(amountLabel, 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(fromLabel, 0, 1);
        grid.add(fromCurrencyBox, 1, 1);
        grid.add(toLabel, 0, 2);
        grid.add(toCurrencyBox, 1, 2);
        grid.add(resultLabel, 0, 3);
        grid.add(resultField, 1, 3);
        grid.add(convertButton, 1, 4);

        VBox root = new VBox(10, instructionLabel, grid, messageLabel);
        root.setAlignment(Pos.TOP_LEFT);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 420, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        loadCurrencies();
        fromCurrencyBox.setValue("USD");
        toCurrencyBox.setValue("VND");
    }

    private void loadCurrencies() {
        controller.getCurrencyEx().getAvailableCurrencies().keySet().forEach(currency -> {
            fromCurrencyBox.getItems().add(currency);
            toCurrencyBox.getItems().add(currency);
        });
    }

    private void handleConvert() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount < 0) {
                messageLabel.setText("Amount cannot be negative.");
                resultField.clear();
                return;
            }

            String fromCurrency = fromCurrencyBox.getValue();
            String toCurrency = toCurrencyBox.getValue();

            if (fromCurrency == null || toCurrency == null) {
                messageLabel.setText("Please choose both currencies.");
                resultField.clear();
                return;
            }

            controller.convertCurrency(amount, fromCurrency, toCurrency);
            resultField.setText(String.format("%.2f", controller.getCurrencyEx().getConvertedAmount()));
            messageLabel.setText("");
        }
        
        catch (NumberFormatException ex) {
            messageLabel.setText("Please enter a valid number.");
            resultField.clear();
        }
    }
}