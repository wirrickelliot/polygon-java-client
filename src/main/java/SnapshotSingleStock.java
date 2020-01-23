public class SnapshotSingleStock {
    private String endpoint;

    public SnapshotSingleStock(String ticker) {
        this.endpoint = String.format("/v2/snapshot/locale/us/markets/stocks/tickers/%s", ticker);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
