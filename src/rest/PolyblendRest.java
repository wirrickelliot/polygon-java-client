import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class PolyblendRest {
    private String apiKey;
    private HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public PolyblendRest(String apiKey) {
        this.apiKey = apiKey;
    }

    public String get(String endpoint) {
        String symbol = (endpoint.contains("?")) ? "&" : "?";
        endpoint = String.format("https://api.polygon.io%s%sapiKey=%s", endpoint, symbol, this.apiKey);
        System.out.printf("%s\n", endpoint);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();
        HttpResponse<String> response = null;
        try {
            response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (java.io.IOException | java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.statusCode() + ": " + response.body());
        return response.body();
    }
}
