package application;

import dao.CurrencyDao;
import entity.Currency;
import java.util.List;

public class CurrencyApp {
    public static void main(String[] args) {
        CurrencyDao currDao = new CurrencyDao();

        List<Currency> currencies = currDao.getAllCurrencies();
        for (Currency curr : currencies) {
            System.out.println(curr.getName() + " " + curr.getAbbreviation() + " " + curr.getExchange_rate());
        }

        Currency curr = currDao.getCurrency(1);
        if (curr != null) {
            System.out.println(curr.getName() + " " + curr.getAbbreviation() + " " + curr.getExchange_rate());
        }

        currDao.persist(new Currency("Mexican Peso", "MXN", 17.26902651));
    }
}
