import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class LastCurrencyQuote {
    private String endpoint;

    public LastCurrencyQuote(String from, String to) {
        this.endpoint = String.format("/v1/last_quote/currencies/%s/%s",
                URLEncoder.encode(from, StandardCharsets.UTF_8),
                URLEncoder.encode(to, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
