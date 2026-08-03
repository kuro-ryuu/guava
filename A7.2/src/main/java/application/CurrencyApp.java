package application;

import entity.*;
import dao.*;
import java.util.*;

public class CurrencyApp {
    public static void main(String[] args) {
        CurrencyDAo currDao = new CurrencyDao();

        List <Currency> currencies = currDao.getAllCurrencies();
        for (Currency curr : currencies) {
            System.out.println(curr.getName() + " " + curr.getAbbreviation() + " " + curr.getExchange_rate());
        }

        Currency curr = currDao.getCurrency(1);
        System.out.println(curr.getName() + " " + curr.getAbbreviation() + " " + curr.getExchange_rate());

        currDao.persist(new main.java.entity.Currency("KRW", "Korean Won", 1.403));
    }
}
