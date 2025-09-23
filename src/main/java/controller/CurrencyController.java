package controller;


import dao.CurrencyConverterDao;
import entity.Currency;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.CurrencyCode;

public class CurrencyController {
    CurrencyConverterDao dao = new CurrencyConverterDao();

    @FXML private TextField convertableValue;
    @FXML private Label convRate;
    @FXML private Label convValue;

    private CurrencyCode from = CurrencyCode.EUR;     // <-- enum, ei String

    // FROM-napit:
    @FXML private void convFromUsd() { from = CurrencyCode.USD; }
    @FXML private void convFromEur() { from = CurrencyCode.EUR; }
    @FXML private void convFromGbp() { from = CurrencyCode.GBP; }
    @FXML private void convFromJpy() { from = CurrencyCode.JPY; }
    @FXML private void convFromChf() { from = CurrencyCode.CHF; }
    @FXML private void convFromCad() { from = CurrencyCode.CAD; }
    @FXML private void convFromAud() { from = CurrencyCode.AUD; }
    @FXML private void convFromSgd() { from = CurrencyCode.SGD; }

    // TO-napit:
    @FXML private void convertToUsd() { convertTo(CurrencyCode.USD); }
    @FXML private void convertToEur() { convertTo(CurrencyCode.EUR); }
    @FXML private void convertToGbp() { convertTo(CurrencyCode.GBP); }
    @FXML private void convertToJpy() { convertTo(CurrencyCode.JPY); }
    @FXML private void convertToChf() { convertTo(CurrencyCode.CHF); }
    @FXML private void convertToCad() { convertTo(CurrencyCode.CAD); }
    @FXML private void convertToAud() { convertTo(CurrencyCode.AUD); }
    @FXML private void convertToSgd() { convertTo(CurrencyCode.SGD); }

    private void convertTo(CurrencyCode to) {
        String amountStr = convertableValue.getText();
        double amount = parseAmount(amountStr);

        Currency rates = dao.getConvercionRate(from);
        double rate = rates.rateTo(to);
        double result = amount * rate;

        convRate.setText(String.format("%s to %s: %.6f", from, to, rate));
        convValue.setText(String.format("%.2f", result));
    }

    private double parseAmount(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return 0.0;
        }
    }

}
