import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class StockDividends {
    private String endpoint;

    public StockDividends(String symbol) {
        this.endpoint = String.format("/v2/reference/dividends/%s",
                URLEncoder.encode(symbol, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
