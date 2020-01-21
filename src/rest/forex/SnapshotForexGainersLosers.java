public class SnapshotForexGainersLosers{
    private String endpoint;

    private SnapshotForexGainersLosers(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;

        public Builder(String direction) {
            this.endpoint = String.format("/v2/snapshot/locale/global/markets/forex/%s", direction);
        }

        public SnapshotForexGainersLosers build() {
            return new SnapshotForexGainersLosers(this);
        }
    }
}
