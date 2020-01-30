import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SnapshotSingleCrypto {
    private String endpoint;

    public SnapshotSingleCrypto(String ticker) {
        this.endpoint = String.format("/v2/snapshot/locale/global/markets/crypto/tickers/%s",
                URLEncoder.encode(ticker, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
