public class LastStockTrade {
    private String endpoint;

    private LastStockTrade(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;

        public Builder(String symbol) {
            this.endpoint = String.format("/v1/last/stocks/%s", symbol);
        }

        public LastStockTrade build() {
            return new LastStockTrade(this);
        }
    }
}
