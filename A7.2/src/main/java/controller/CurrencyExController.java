package controller;

import dao.CurrencyDao;
import entity.Currency;
import model.CurrencyEx;
import view.CurrencyExView;

import java.util.List;

public class CurrencyExController {
    private final CurrencyEx currencyEx;
    private final CurrencyDao currencyDao = new CurrencyDao();

    public CurrencyExController(CurrencyEx currencyEx) {
        this.currencyEx = currencyEx;
        loadRatesFromDatabase();
    }

    private void loadRatesFromDatabase() {
        List<Currency> currencies = currencyDao.getAllCurrencies();
        for (Currency currency : currencies) {
            currencyEx.getAvailableCurrencies().put(currency.getAbbreviation().toUpperCase(), currency.getExchange_rate());
        }
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
