public class SnapshotCryptoGainersLosers {
    private String endpoint;

    public SnapshotCryptoGainersLosers(String direction) {
       this.endpoint = String.format("/v2/snapshot/locale/global/markets/crypto/%s", direction);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
