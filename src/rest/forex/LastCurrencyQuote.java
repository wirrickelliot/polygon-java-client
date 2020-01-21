public class LastCurrencyQuote {
    private String endpoint;

    public LastCurrencyQuote(String from, String to) {
        this.endpoint = String.format("/v1/last_quote/currencies/%s/%s", from, to);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
