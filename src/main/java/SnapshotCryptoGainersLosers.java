import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SnapshotCryptoGainersLosers {
    private String endpoint;

    public SnapshotCryptoGainersLosers(String direction) {
       this.endpoint = String.format("/v2/snapshot/locale/global/markets/crypto/%s",
               URLEncoder.encode(direction, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
