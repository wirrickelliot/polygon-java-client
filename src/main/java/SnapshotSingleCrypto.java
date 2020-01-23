public class SnapshotSingleCrypto {
    private String endpoint;

    public SnapshotSingleCrypto(String ticker) {
        this.endpoint = String.format("/v2/snapshot/locale/global/markets/crypto/tickers/%s", ticker);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
