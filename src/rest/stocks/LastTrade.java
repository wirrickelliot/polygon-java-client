public class LastTrade {
    private String endpoint;

    private LastTrade(Builder builder) {
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

        public LastTrade build() {
            return new LastTrade(this);
        }
    }
}
