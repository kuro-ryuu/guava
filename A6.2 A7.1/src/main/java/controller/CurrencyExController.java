package controller;

import model.CurrencyEx;
import view.CurrencyExView;

public class CurrencyExController {
    private final CurrencyEx currencyEx;

    public CurrencyExController(CurrencyEx currencyEx) {
        this.currencyEx = currencyEx;
    }

    public CurrencyEx convertCurrency(double amount, String fromCurrency, String toCurrency) {
        currencyEx.setAmount(amount);
        currencyEx.setFromCurrency(fromCurrency);
        currencyEx.setToCurrency(toCurrency);
        currencyEx.convert();
        return currencyEx;
    }

    public CurrencyEx getCurrencyEx() {
        return currencyEx;
    }

    public static void main(String[] args) {
        CurrencyExView.launch(CurrencyExView.class);
    }
}
