package entity;

public class Currency {
    private String name, abbreviation;
    private double exchange_rate;

    public Currency(String name, String abbreviation, double exchange_rate) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.exchange_rate = exchange_rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public double getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(double exchange_rate) {
        this.exchange_rate = exchange_rate;
    }
}
