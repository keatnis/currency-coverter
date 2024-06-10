package com.keatnis.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.keatnis.connection.APIConnection;
import com.keatnis.mod.MonedaAPI;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private double amount;
    private String currencyCodeFrom;
    private String currencyCodeTo;
    private double conversionResult;
    private List<Converter> converterList = new ArrayList<>();

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    APIConnection apiConnection = new APIConnection();
    ConvertirArchivo convertirArchivo = new ConvertirArchivo();

    public Converter() {
    }

    public Converter(MonedaAPI monedaAPI) {

        this.currencyCodeFrom = monedaAPI.base_code();
        this.currencyCodeTo = monedaAPI.target_code();
        this.conversionResult = monedaAPI.conversion_result();

    }

    public Converter convertirMoneda(String from, String to, double amount) {

        // se valida si moneda es convertida correctamente para agregarlo a la lista
        Converter miConvertidor = null;
        if (from.length() < 4 && to.length() < 4) {
            String json = apiConnection.ApiResponse(from, to, amount);
            MonedaAPI monedaAPI = gson.fromJson(json, MonedaAPI.class);
            miConvertidor = new Converter(monedaAPI);
            mostrarRespuesta(miConvertidor, amount);
//            try {
//                generarArchivo.saveDataConverter(monedaAPI);
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//                throw new RuntimeException(e);
//            }
            this.converterList.add(miConvertidor);

        } else {
            System.out.println("Codigo de moneda incompleto, se aceptan 3 letras");
        }

        return miConvertidor;
    }

    public void gethistorial() {
        System.out.println("Conversiones realizadas");
        //Collections.sort;
        for (Converter moneda : getConverterList()) {
            System.out.println(" Valor convertido: " + moneda.conversionResult+" Desde: " + moneda.currencyCodeFrom + "a: " + moneda.currencyCodeTo );
        }
    }

    public String mostrarRespuesta(Converter converter, double amount) {
        String result = " El valor de " + amount + " [" + converter.currencyCodeFrom + "] " + " corresponde al valor final ===> " +
                converter.conversionResult + " [" + converter.currencyCodeTo + "]";
        System.out.println(result);
        return result;
    }



    public List<Converter> getConverterList() {
        return converterList;
    }

    public void setConverterList(List<Converter> converterList) {
        this.converterList = converterList;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyCodeFrom() {
        return currencyCodeFrom;
    }

    public void setCurrencyCodeFrom(String currencyCodeFrom) {
        this.currencyCodeFrom = currencyCodeFrom;
    }

    public String getCurrencyCodeTo() {
        return currencyCodeTo;
    }

    public void setCurrencyCodeTo(String currencyCodeTo) {
        this.currencyCodeTo = currencyCodeTo;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(double conversionResul) {
        this.conversionResult = conversionResul;
    }

    @Override
    public String toString() {
        return "Converter{" +
                "amount=" + amount +
                ", currencyCodeFrom='" + currencyCodeFrom + '\'' +
                ", currencyCodeTo='" + currencyCodeTo + '\'' +
                '}';
    }
}
