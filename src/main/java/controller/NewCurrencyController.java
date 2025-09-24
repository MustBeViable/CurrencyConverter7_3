package controller;

import dao.CurrencyConverterDao;
import entity.Currency;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.CurrencyCode;

import java.util.ArrayList;
import java.util.List;

public class NewCurrencyController {
    CurrencyConverterDao dao = new CurrencyConverterDao();

    @FXML private TextField currencyCode, currencyName, rateToUsd, rateToEur, rateToGbp, rateToJpy, rateToChf,
            rateToCad, rateToAud, rateToSgd;
    @FXML private Label addInfo;

    TextField[] textFields = new TextField[]{currencyCode, currencyName, rateToUsd, rateToEur, rateToGbp, rateToJpy, rateToChf,
            rateToCad, rateToAud, rateToSgd};


    @FXML
    private void addCurrency() {
        addInfo.setText("");
        double toUsd, toEur, toGbp, toJpy, toChf, toCad, toAud, toSgd;
        try {
            toUsd = Double.parseDouble(rateToUsd.getText().trim().replace(',', '.'));
            toEur = Double.parseDouble(rateToEur.getText().trim().replace(',', '.'));
            toGbp = Double.parseDouble(rateToGbp.getText().trim().replace(',', '.'));
            toJpy = Double.parseDouble(rateToJpy.getText().trim().replace(',', '.'));
            toChf = Double.parseDouble(rateToChf.getText().trim().replace(',', '.'));
            toCad = Double.parseDouble(rateToCad.getText().trim().replace(',', '.'));
            toAud = Double.parseDouble(rateToAud.getText().trim().replace(',', '.'));
            toSgd = Double.parseDouble(rateToSgd.getText().trim().replace(',', '.'));
            try {
                    dao.persist(new Currency(currencyCode.getText().toUpperCase(), currencyName.getText(), toUsd,
                            toEur, toGbp, toJpy, toChf, toCad, toAud, toSgd));
                    addInfo.setText("Currency added");
                    clearTextFields();
                } catch (Exception e) {
                System.out.println("Error in making dao");
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            addInfo.setText("Check input values.");
        }
    }

    private void clearTextFields() {
        for (TextField t : textFields) {
            t.clear();
        }
    }
}
