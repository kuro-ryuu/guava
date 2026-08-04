package entity;

import jakarta.persistence.*;

@Entity
@Table(name="Currency")

public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="abbreviation")
    private String abbreviation;
    @Column(name="exchange_rate")
    private double exchange_rate;

    public Currency(String name, String abbreviation, double exchange_rate) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.exchange_rate = exchange_rate;
    }

    public Currency() {}

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
