public class SnapshotAllForex {

    private SnapshotAllForex() {}

    public String endpoint() {
        return "/v2/snapshot/locale/global/markets/forex/tickers";
    }

    public static class Builder {
        public Builder() {}

        public SnapshotAllForex build() {
            return new SnapshotAllForex();
        }
    }
}
