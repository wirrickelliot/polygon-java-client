import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DailyCryptoOpenClose {
    private String endpoint;

    public DailyCryptoOpenClose(String from, String to, String date) {
        this.endpoint = String.format("/v1/open-close/crypto/%s/%s/%s",
                URLEncoder.encode(from, StandardCharsets.UTF_8),
                URLEncoder.encode(to, StandardCharsets.UTF_8),
                URLEncoder.encode(date, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
