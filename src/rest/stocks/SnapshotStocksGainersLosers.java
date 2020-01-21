public class SnapshotStocksGainersLosers{
    private String endpoint;

    private SnapshotStocksGainersLosers(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;

        public Builder(String direction) {
            this.endpoint = String.format("/v2/snapshot/locale/us/markets/stocks/%s", direction);
        }

        public SnapshotStocksGainersLosers build() {
            return new SnapshotStocksGainersLosers(this);
        }
    }
}
