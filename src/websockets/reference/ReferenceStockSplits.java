public class ReferenceStockSplits {
    private String endpoint;

    public ReferenceStockSplits(Builder builder) {
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

        public ReferenceStockSplits build() {
            return new ReferenceStockSplits(this);
        }
    }
}
