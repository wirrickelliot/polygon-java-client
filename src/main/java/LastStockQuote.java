public class LastStockQuote {
    private String endpoint;

    public LastStockQuote(String symbol) {
        this.endpoint = String.format("/v1/last_quote/stocks/%s", symbol);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
