import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SnapshotSingleCryptoBook {
    private String endpoint;

    public SnapshotSingleCryptoBook(String ticker) {
       this.endpoint = String.format("/v2/snapshot/locale/global/markets/crypto/tickers/%s/book",
               URLEncoder.encode(ticker, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
