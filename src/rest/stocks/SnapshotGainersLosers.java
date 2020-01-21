public class SnapshotGainersLosers{
    private String endpoint;

    private SnapshotGainersLosers(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint = "/v2/snapshot/locale/us/markets/stocks/gainers";

        public Builder(String direction) {
            this.endpoint = String.format("/v2/snapshot/locale/us/markets/stocks/%s", direction);
        }

        public SnapshotGainersLosers build() {
            return new SnapshotGainersLosers(this);
        }
    }
}
