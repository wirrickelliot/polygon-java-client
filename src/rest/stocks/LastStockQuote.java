public class LastStockQuote {
    private String endpoint;

    private LastStockQuote(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;

        public Builder(String symbol) {
            this.endpoint = String.format("/v1/last_quote/stocks/%s", symbol);
        }

        public LastStockQuote build() {
            return new LastStockQuote (this);
        }
    }
}
