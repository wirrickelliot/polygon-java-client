public class StockDividends {
    private String endpoint;

    public StockDividends(String symbol) {
        this.endpoint = String.format("/v2/reference/dividends/%s", symbol);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
