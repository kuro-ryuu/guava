package dao;

import entity.Currency;
import java.sql.*;
import datasource.MariaDbConnection;
import java.util.*;

public class CurrencyDao {
    public List<Currency> getAllCurrencies() {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "SELECT abbreviation, name, exchange_rate FROM Currency";
        List<Currency> currencies = new ArrayList<Currency>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                String abbreviation = rs.getString("abbreviation");
                String name = rs.getString("name");
                double exchange_rate = rs.getDouble("exchange_rate");
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
        String sql = "SELECT abbreviation, name, exchange_rate FROM Currency WHERE id=?";

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
                abbreviation = rs.getString("abbreviation");
                name = rs.getString("name");
                exchange_rate = rs.getDouble("exchange_rate");
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