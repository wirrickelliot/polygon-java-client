import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class LastStockQuote {
    private String endpoint;

    public LastStockQuote(String symbol) {
        this.endpoint = String.format("/v1/last_quote/stocks/%s",
                URLEncoder.encode(symbol, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
