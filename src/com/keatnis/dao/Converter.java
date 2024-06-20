package com.keatnis.dao;

import com.keatnis.connection.APIConnection;
import com.keatnis.mod.MonedaAPI;

import java.time.LocalDateTime;

public class Converter {

    double amount;
    String currencyCodeFrom;
    String currencyCodeTo;
    double conversionResult;
    LocalDateTime dateTime;
    private APIConnection apiConnection;


    public Converter(MonedaAPI monedaAPI) {
        this.currencyCodeFrom = monedaAPI.base_code();
        this.currencyCodeTo = monedaAPI.target_code();
        this.conversionResult = monedaAPI.conversion_result();
        this.amount = getAmount();
        this.dateTime = getDateTime();

    }

    public Converter() {
        this.apiConnection = new APIConnection();
    }


    public Converter realizarConversion(String from, String to, double amount) {

        // se ejecuta el api con los datos proporcionados
        Converter miConvertidor = null;
        if (from.length() < 4 && to.length() < 4) {
            MonedaAPI monedaAPI = apiConnection.ApiResponse(from, to, amount);
            miConvertidor = new Converter(monedaAPI);
            miConvertidor.setAmount(amount);
            System.out.println(mostrarRespuesta(miConvertidor));

        } else {
            System.out.println("Error: codigo de moneda incorrecto");

        }
        return miConvertidor;

    }

    private String mostrarRespuesta(Converter converter) {
        String result = " El valor de " + converter.amount + " [" + converter.currencyCodeFrom + "] " + " corresponde al valor final ===> " +
                converter.conversionResult + " [" + converter.currencyCodeTo + "]";
        return result;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public LocalDateTime getDateTime() {

        return LocalDateTime.now();
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;

    }

    @Override
    public String toString() {

        return "Conversion {" +
                "valor=" + amount +
                ", de ='" + currencyCodeFrom + '\'' +
                ", a ='" + currencyCodeTo + '\'' +
                ", total ='" + conversionResult + '\'' +
                ", fecha ='" + dateTime + '\'' +
                '}';

    }
}
