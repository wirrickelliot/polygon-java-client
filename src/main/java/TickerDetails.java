import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TickerDetails {
    private String endpoint;

    public TickerDetails(String symbol) {
        this.endpoint = String.format("/v1/meta/symbols/%s/company",
                URLEncoder.encode(symbol, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
