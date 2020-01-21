public class SnapshotAllStocks {

    private SnapshotAllStocks() {}

    public String endpoint() {
        return "/v2/snapshot/locale/us/markets/stocks/tickers";
    }

    public static class Builder {
        public Builder() {}

        public SnapshotAllStocks build() {
            return new SnapshotAllStocks();
        }
    }
}
