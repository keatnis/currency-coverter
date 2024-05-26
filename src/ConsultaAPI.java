import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.time.Duration;

public class ConsultaAPI {

//    public Moneda obtenerValorMoneda(String from, String to) {
//        String APIKEY = "050ca4fb6f2e015b6711d338";
//        URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + APIKEY + "/pair/" + from + "/" + to);
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(uri)
//                .timeout(Duration.ofMinutes(2))
//                .header("Content-Type", "application/json")
//                .build();
//        try {
//            HttpResponse<String> response = client
//                    .send(request, HttpResponse.BodyHandlers.ofString());
//
//            return new Gson().fromJson(response.body(), Moneda.class);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new RuntimeException("No se pudo consultar");
//        }
//
//    }

public void obtenerValorMoneda(String from, String to, Double value) {
    String APIKEY = "050ca4fb6f2e015b6711d338";
    URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + APIKEY + "/pair/" + from + "/" + to);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(uri)
            .build();
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    try {
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Moneda monedaAPI  = gson.fromJson(response.body(), Moneda.class);
        Double conversionRate = Double.valueOf(monedaAPI.conversion_rate());
        Double conversion = conversionRate * value;
        System.out.println("El valor de "+ value +" [" + monedaAPI.base_code() +"]"+ " corresponde al valor final de ===> "+ conversion +" ["+ monedaAPI.target_code()+"]");
    } catch (Exception e) {
        System.out.println(e.getMessage());
        throw new RuntimeException("No se pudo consultar");
    }

}

}
