public class TickerDetails {
    private String endpoint;

    public TickerDetails(String symbol) {
        this.endpoint = String.format("/v1/meta/symbols/%s/company", symbol);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
