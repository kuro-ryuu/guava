package dao;

import entity.Currency;
import java.sql.*;
import datasource.MariaDbConnection;
import java.util.*;

public class CurrencyDao {
    public List<Currency> getAllCurrencies() {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT * FROM Currency";
        List<Currency> currencies = new ArrayList<Currency>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString(1);
                String abbreviation = rs.getString(2);
                double exchange_rate = rs.getDouble(3);
                Currency curr = new Currency(name, abbreviation, exchange_rate);
                currencies.add(curr);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return currencies;
    }

    public Currency getCurrency(int id) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT * FROM Currency WHERE id=?";

        String name = null;
        String abbreviation = null;
        double exchange_rate = 0.0;
        int count = 0;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                count++;                
                name = rs.getString(1);
                abbreviation = rs.getString(2);
                exchange_rate = rs.getDouble(3);
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (count==1) {
            return new Currency(name, abbreviation, exchange_rate);
        }

        else {
            return null;
        }
    }

    public void persist(Currency curr) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "INSERT INTO Currency (name, abbreviation, exchange_rate) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, curr.getName());
            ps.setString(2, curr.getAbbreviation());
            ps.setDouble(3, curr.getExchange_rate());
            ps.executeUpdate();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}