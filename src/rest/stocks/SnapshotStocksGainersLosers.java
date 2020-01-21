public class SnapshotStocksGainersLosers{
    private String endpoint;

    public SnapshotStocksGainersLosers(String direction) {
        this.endpoint = String.format("/v2/snapshot/locale/us/markets/stocks/%s", direction);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
