package com.keatnis.connection;

import com.keatnis.dao.Converter;
import com.keatnis.exception.RuntimeExceptionAPIConnection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConnection {

    String APIKEY = "050ca4fb6f2e015b6711d338";
    String URL = "https://v6.exchangerate-api.com/v6/";

    public String ApiResponse(String from, String to, double amount) {
       URI uri = URI.create(URL + APIKEY + "/pair/" +from + "/" + to + "/"+amount);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> response = null;

        try {
            response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
            String httpResponse  = response.body();
            return httpResponse;

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch ( RuntimeExceptionAPIConnection e) {
            System.out.println(e.getMessage());
            throw new RuntimeExceptionAPIConnection("Error al hacer consultar el API");

        }


    }
}
