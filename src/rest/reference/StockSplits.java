public class StockSplits {
    private String endpoint;

    private StockSplits(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;

        public Builder(String symbol) {
            this.endpoint = String.format("/v2/reference/splits/%s", symbol);
        }

        public StockSplits build() {
            return new StockSplits(this);
        }
    }
}
