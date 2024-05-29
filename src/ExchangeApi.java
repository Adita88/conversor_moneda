import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;

class ExchangeApi {

    String key = "cc2ebf4f86cdddf6272627fd";

    public ExchangeRate conversorMoneda(String base_code, String target_code){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" +
                key + "/pair/"+ base_code+ "/" + target_code);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRate.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo hacer la conversión");
        }


    }

    public double buscandoTotal(String base_code, String target_code, double amount) {
        ExchangeRate cambio = conversorMoneda(base_code, target_code);
        return cambio.conversion_rate() * amount;
    }
}
