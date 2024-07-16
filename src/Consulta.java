import com.google.gson.Gson;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class Consulta {
    public Monedas convertir(String monedaOrigen, String monedaConvertida, double cantidad){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/a57ad555e4b88ca8c66e3f71/pair/" +
                monedaOrigen + "/" + monedaConvertida + "/" + cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();


        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("Ups! No se realizo la conversión con exito...");
        }
    }
}