package com.keatnis.conversor;

import com.keatnis.model.Converter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistorialConversion {

    private List<Converter> converterList = new ArrayList<>();
    private DateTimeFormatter formatter;
    private ConvertirArchivo convertirArchivo;

    public HistorialConversion() {

        this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.convertirArchivo = new ConvertirArchivo();

    }

    public void agregarConversion(Converter converter) {

        converterList.add(converter);

    }

    public void mostrarHistorial() {

        System.out.println(" ---- ** Conversiones realizadas ** ---- \n");

        for (Converter moneda : converterList ) {
            System.out.println("Valor: " + moneda.getAmount() + " \tDesde: " + moneda.getCurrencyCodeFrom() +
                    "\ta: " + moneda.getCurrencyCodeTo() + " ===> \t" + moneda.getCurrencyCodeTo()
                    + "  \t Fecha y hora de conversion: " + moneda.getDateTime().format(formatter));

        }
    }

    public List<Converter> getConverterList() {
        return converterList;
    }

}
