public class SnapshotSingleCryptoBook {
    private String endpoint;

    public SnapshotSingleCryptoBook(String ticker) {
       this.endpoint = String.format("/v2/snapshot/locale/global/markets/crypto/tickers/%s/book", ticker);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
