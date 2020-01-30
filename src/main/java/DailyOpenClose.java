import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DailyOpenClose {
    private String endpoint;

    public DailyOpenClose(String symbol, String date) {
        this.endpoint = String.format("/v1/open-close/%s/%s",
                URLEncoder.encode(symbol, StandardCharsets.UTF_8),
                URLEncoder.encode(date, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
