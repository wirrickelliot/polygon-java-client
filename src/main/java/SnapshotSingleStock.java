import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SnapshotSingleStock {
    private String endpoint;

    public SnapshotSingleStock(String ticker) {
        this.endpoint = String.format("/v2/snapshot/locale/us/markets/stocks/tickers/%s",
                URLEncoder.encode(ticker, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
