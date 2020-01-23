public class LastStockTrade {
    private String endpoint;

    public LastStockTrade(String symbol) {
        this.endpoint = String.format("/v1/last/stocks/%s", symbol);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
