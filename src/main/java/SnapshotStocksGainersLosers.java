import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SnapshotStocksGainersLosers{
    private String endpoint;

    public SnapshotStocksGainersLosers(String direction) {
        this.endpoint = String.format("/v2/snapshot/locale/us/markets/stocks/%s",
                URLEncoder.encode(direction, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
