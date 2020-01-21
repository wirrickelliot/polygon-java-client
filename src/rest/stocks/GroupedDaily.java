public class GroupedDaily {
    private String endpoint;
    private Boolean unadjusted;

    private GroupedDaily(Builder builder) {
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

        public Builder(String locale, String market, String date) {
            this.endpoint = String.format("/v2/aggs/grouped/locale/%s/market/%s/%s", locale,
                    market,
                    date);
        }

        public Builder unadjusted(Boolean unadjusted) {
            this.unadjusted = unadjusted;
            return this;
        }

        public GroupedDaily build() {
            return new GroupedDaily(this);
        }
    }
}
