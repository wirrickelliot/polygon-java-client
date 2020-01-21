public class DailyOpenClose {
    private String endpoint;

    private DailyOpenClose(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;

        public Builder(String symbol, String date) {
            this.endpoint = String.format("/v1/open-close/%s/%s", symbol, date);
        }

        public DailyOpenClose build() {
            return new DailyOpenClose(this);
        }
    }
}
