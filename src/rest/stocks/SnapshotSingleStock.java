public class SnapshotSingleStock {
    private String endpoint;

    private SnapshotSingleStock(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;

        public Builder(String ticker) {
            this.endpoint = String.format("/v2/snapshot/locale/us/markets/stocks/tickers/%s", ticker);
        }

        public SnapshotSingleStock build() {
            return new SnapshotSingleStock(this);
        }
    }
}
