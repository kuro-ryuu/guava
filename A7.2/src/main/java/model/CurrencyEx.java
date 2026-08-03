package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class CurrencyEx {
    private double amount;
    private String fromCurrency;
    private String toCurrency;
    private double exchangeRate;
    private double convertedAmount;
    private final Map<String, Double> ratesToUsd = new LinkedHashMap<>();

    public CurrencyEx() {
        this(0.0, "USD", "USD");
    }

    public CurrencyEx(double amount, String fromCurrency, String toCurrency) {
        this.amount = amount;
        this.fromCurrency = fromCurrency.toUpperCase();
        this.toCurrency = toCurrency.toUpperCase();
        this.exchangeRate = 1.0;
        this.convertedAmount = amount;
        initializeRates();
    }

    private void initializeRates() {
        ratesToUsd.put("USD", 1.0);
        ratesToUsd.put("VND", 0.000038);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency.toUpperCase();
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency.toUpperCase();
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public Map<String, Double> getAvailableCurrencies() {
        return ratesToUsd;
    }

    public double convert() {
        if (amount <= 0) {
            convertedAmount = 0.0;
            exchangeRate = 1.0;
            return convertedAmount;
        }

        if (fromCurrency.equals(toCurrency)) {
            exchangeRate = 1.0;
            convertedAmount = amount;
            return convertedAmount;
        }

        exchangeRate = getRate(fromCurrency, toCurrency);
        convertedAmount = amount * exchangeRate;
        return convertedAmount;
    }

    private double getRate(String fromCurrency, String toCurrency) {
        double fromRate = ratesToUsd.getOrDefault(fromCurrency, 1.0);
        double toRate = ratesToUsd.getOrDefault(toCurrency, 1.0);
        return fromRate / toRate;
    }
}
