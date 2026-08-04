package application;

import entity.Currency;
import dao.CurrencyDao;
import java.util.List;

public class CurrencyApp {
    public static void main(String[] args) {
        CurrencyDao currDao = new CurrencyDao();

        List <Currency> currencies = currDao.getAllCurrencies();
        for (Currency curr : currencies) {
            System.out.println(curr.getName() + " " + curr.getAbbreviation() + " " + curr.getExchange_rate());
        }

        Currency curr = currDao.getCurrency(1);
        System.out.println(curr.getName() + " " + curr.getAbbreviation() + " " + curr.getExchange_rate());

        currDao.persist(new Currency("KRW", "Korean Won", 1.403));
    }
}
