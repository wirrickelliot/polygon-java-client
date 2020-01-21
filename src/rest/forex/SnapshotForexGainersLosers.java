public class SnapshotForexGainersLosers{
    private String endpoint;

    public SnapshotForexGainersLosers(String direction) {
        this.endpoint = String.format("/v2/snapshot/locale/global/markets/forex/%s", direction);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
