import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class StockSplits {
    private String endpoint;

    public StockSplits(String symbol) {
        this.endpoint = String.format("/v2/reference/splits/%s",
                URLEncoder.encode(symbol, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
