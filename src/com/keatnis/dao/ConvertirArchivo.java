package com.keatnis.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.keatnis.mod.MonedaAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConvertirArchivo {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void saveDataConverter(MonedaAPI monedaAPI) throws IOException {

        FileWriter fileWriter = new FileWriter("historial.json");
        fileWriter.write(gson.toJson(monedaAPI));
        fileWriter.close();
    }

    public void leerArchivo() {
        File myObj = new File("src/currency.json");
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
