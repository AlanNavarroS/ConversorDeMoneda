import com.google.gson.Gson;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda cantidadMoneda (double cantidadUsuario) throws URISyntaxException {

        URI direccionCambio = new URI("https://v6.exchangerate-api.com/v6/1088773b30a5c668164bb6c7/pair/USD/MXN/"+cantidadUsuario);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccionCambio)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("La cantidad no es aceptada");
        }
    }
}
/*
HttpRequest request = HttpRequest.newBuilder() se agrego en la Linea 14
        .uri(URI.create("https://foo.com/")// se creo en la linea 11)Se agrego en la Linea 15
        .build(); Se agrega en la linea 16

        HttpResponse<String> response = client Se crea en la linea 18
        .send(request, BodyHandlers.ofString()); se crea en la linea 19

        HttpClient client = HttpClient.newBuilder() se crea en la linea 13 se cambia newBulder por newHttpClient().
*/