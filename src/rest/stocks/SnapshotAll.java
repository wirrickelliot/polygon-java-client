public class SnapshotAll {

    private SnapshotAll() {}

    public String endpoint() {
        return "/v2/snapshot/locale/us/markets/stocks/tickers";
    }

    public static class Builder {
        public Builder() {}

        public SnapshotAll build() {
            return new SnapshotAll();
        }
    }
}
