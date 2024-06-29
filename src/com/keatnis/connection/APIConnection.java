package com.keatnis.connection;

import com.google.gson.Gson;
import com.keatnis.exception.RuntimeExceptionAPIConnection;
import com.keatnis.model.MonedaAPI;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConnection {

    private final String API_KEY = "050ca4fb6f2e015b6711d338";
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/";


    public MonedaAPI ApiResponse(String from, String to, double amount) {
        URI uri = URI.create(URL_BASE + API_KEY + "/pair/" + from + "/" + to + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();
        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String httpResponse = response.body();

            return new Gson().fromJson(httpResponse, MonedaAPI.class);

        } catch (RuntimeExceptionAPIConnection e) {
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException("Error al usar la api");
        }
        return null;
    }
}
