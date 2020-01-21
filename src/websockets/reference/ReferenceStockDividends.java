public class ReferenceStockDividends {
    private String endpoint;

    public ReferenceStockDividends(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;

        public Builder(String symbol) {
            this.endpoint = String.format("/v2/reference/dividends/%s", symbol);
        }

        public ReferenceStockDividends build() {
            return new ReferenceStockDividends(this);
        }
    }
}
