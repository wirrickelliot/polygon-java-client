import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class LastStockTrade {
    private String endpoint;

    public LastStockTrade(String symbol) {
        this.endpoint = String.format("/v1/last/stocks/%s",
                URLEncoder.encode(symbol, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
