package controller;


import dao.CurrencyConverterDao;
import dao.TransactionDao;
import entity.Currency;
import entity.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CurrencyCode;

import java.util.ArrayList;
import java.util.List;

public class CurrencyController {
    CurrencyConverterDao dao = new CurrencyConverterDao();
    TransactionDao tDao = new TransactionDao();

    @FXML private TextField convertableValue;
    @FXML private Label convRate;
    @FXML private Label convValue;
    @FXML private ComboBox<CurrencyCode> cBoxFrom, cBoxTo;
    @FXML private final ObservableList<CurrencyCode> currencyList = FXCollections.observableArrayList();


    @FXML
    private void initialize() {
        createUpdateControlBoxes();
    }


    private void createUpdateControlBoxes() {
        List<Currency> list = dao.findAll();
        List<CurrencyCode> currencyCodes = new ArrayList<>();
        for (Currency c : list) {
            currencyCodes.add(c.getCurrencyCode());
        }
        currencyList.setAll(currencyCodes);
        cBoxFrom.setItems(currencyList);
        cBoxTo.setItems(currencyList);
    }

    @FXML
    private void convert() {
        String amountStr = convertableValue.getText();
        double amount = parseAmount(amountStr);

        Currency currFrom = dao.getConvercionRate(cBoxFrom.getValue());
        Currency currTo = dao.getConvercionRate(cBoxTo.getValue());
        CurrencyCode to = cBoxTo.getValue();
        CurrencyCode from = cBoxFrom.getValue();

        tDao.persist(new Transaction(amount, currFrom, currTo));

        double rate = currFrom.rateTo(to);
        double result = amount * rate;

        convRate.setText(String.format("%s to %s: %.6f", from, to, rate));
        convValue.setText(String.format("%.2f", result));
    }

    @FXML
    private void addCurrency(){
        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/new_currency.fxml"));

        try {
            Parent newRoot = fxmlLoader2.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(newRoot));
            newStage.setTitle("Add currency");
            newStage.showAndWait();
            createUpdateControlBoxes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private double parseAmount(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return 0.0;
        }
    }

}
