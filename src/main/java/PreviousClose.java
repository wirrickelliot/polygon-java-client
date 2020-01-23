public class PreviousClose {
    private String endpoint;
    private Boolean unadjusted;

    private PreviousClose(Builder builder) {
        this.endpoint = builder.endpoint;
        this.unadjusted = builder.unadjusted;
    }

    public String endpoint() {
        if (this.unadjusted != null)
            return this.endpoint + "?unadjusted=" + this.unadjusted;
        else return this.endpoint;
    }

    public static class Builder {
        private String endpoint;
        private Boolean unadjusted;

        public Builder(String ticker) {
            this.endpoint = String.format("/v2/aggs/ticker/%s/prev", ticker);
        }

        public Builder unadjusted(Boolean unadjusted) {
            this.unadjusted = unadjusted;
            return this;
        }

        public PreviousClose build() {
            return new PreviousClose(this);
        }
    }
}
