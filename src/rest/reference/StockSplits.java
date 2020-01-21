public class StockSplits {
    private String endpoint;

    public StockSplits(String symbol) {
        this.endpoint = String.format("/v2/reference/splits/%s", symbol);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
