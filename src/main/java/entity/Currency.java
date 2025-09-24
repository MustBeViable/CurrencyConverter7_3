package entity;

import jakarta.persistence.*;
import model.CurrencyCode;

@Entity
@Table(name="currency")
public class Currency {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name="currency_code")
    private CurrencyCode currencyCode;
    @Column(name="currency_name")
    private String currencyName;
    @Column(name="rate_to_usd")
    private double rateToUsd;
    @Column(name="rate_to_eur")
    private double rateToEur;
    @Column(name="rate_to_gbp")
    private double rateToGbp;
    @Column(name="rate_to_jpy")
    private double rateToJpy;
    @Column(name="rate_to_chf")
    private double rateToChf;
    @Column(name="rate_to_cad")
    private double rateToCad;
    @Column(name="rate_to_aud")
    private double rateToAud;
    @Column(name="rate_to_sgd")
    private double rateToSgd;

    public Currency(String currencyCode, String currencyName, double rateToUsd, double rateToEur,
                    double rateToGbp, double rateToChf, double rateToJpy, double rateToCad, double rateToAud,
                    double rateToSgd) {
        this.currencyCode = CurrencyCode.valueOf(currencyCode.toUpperCase());
        this.currencyName = currencyName;
        this.rateToUsd = rateToUsd;
        this.rateToEur = rateToEur;
        this.rateToGbp = rateToGbp;
        this.rateToChf = rateToChf;
        this.rateToJpy = rateToJpy;
        this.rateToCad = rateToCad;
        this.rateToAud = rateToAud;
        this.rateToSgd = rateToSgd;
    }

    public Currency() {

    }


    public double rateTo(CurrencyCode to) {
        return switch (to) {
            case USD -> rateToUsd;
            case GBP -> rateToGbp;
            case EUR -> rateToEur;
            case JPY -> rateToJpy;
            case CHF -> rateToChf;
            case CAD -> rateToCad;
            case AUD -> rateToAud;
            case SGD -> rateToSgd;
            default -> 0.0;
        };
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setRateToUsd(double rateToUsd) {
        this.rateToUsd = rateToUsd;
    }

    public void setRateToEur(double rateToEur) {
        this.rateToEur = rateToEur;
    }

    public void setRateToGbp(double rateToGbp) {
        this.rateToGbp = rateToGbp;
    }

    public void setRateToJpy(double rateToJpy) {
        this.rateToJpy = rateToJpy;
    }

    public void setRateToChf(double rateToChf) {
        this.rateToChf = rateToChf;
    }

    public void setRateToCad(double rateToCad) {
        this.rateToCad = rateToCad;
    }

    public void setRateToAud(double rateToAud) {
        this.rateToAud = rateToAud;
    }

    public void setRateToSgd(double rateToSgd) {
        this.rateToSgd = rateToSgd;
    }
}
