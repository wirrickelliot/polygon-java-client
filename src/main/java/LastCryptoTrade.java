import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class LastCryptoTrade {
    private String endpoint;

    public LastCryptoTrade(String from, String to) {
        this.endpoint = String.format("/v1/last/crypto/%s/%s",
                URLEncoder.encode(from, StandardCharsets.UTF_8),
                URLEncoder.encode(to, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
