package com.keatnis.dao;

import com.google.gson.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;


public class ConvertirArchivo {


    public void guardarConversiones(List<Converter> converter) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())

                .setPrettyPrinting()
                .create();
        try {
            FileWriter fileWriter = new FileWriter("historial.json");
            gson.toJson(converter, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void leerArchivo(String url) {
        File archivo = new File(url);

        try {
            Scanner scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //metodo para leer un archivo json
    public void leerArchivoJSON() {

        JsonParser parser = new JsonParser();
        FileReader fr;

        try {
            fr = new FileReader("src/currency.json");
            JsonElement datos = parser.parse(fr);

            JsonObject jobject = datos.getAsJsonObject();
            JsonArray arrayMonedas = jobject.getAsJsonArray("supported_codes");
            for (JsonElement cadena : arrayMonedas) {
                System.out.println("codigo: " +
                        cadena.getAsJsonArray().get(0) + " nombre moneda \t" + cadena.getAsJsonArray().get(1));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
