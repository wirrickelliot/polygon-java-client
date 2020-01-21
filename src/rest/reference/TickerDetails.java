public class TickerDetails {
    private String endpoint;

    public TickerDetails(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;

        public Builder(String symbol) {
            this.endpoint = String.format("/v1/meta/symbols/%s/company", symbol);
        }

        public TickerDetails build() {
            return new TickerDetails(this);
        }
    }
}
