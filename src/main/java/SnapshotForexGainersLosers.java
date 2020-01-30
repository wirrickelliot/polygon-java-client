import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SnapshotForexGainersLosers{
    private String endpoint;

    public SnapshotForexGainersLosers(String direction) {
        this.endpoint = String.format("/v2/snapshot/locale/global/markets/forex/%s",
                URLEncoder.encode(direction, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
