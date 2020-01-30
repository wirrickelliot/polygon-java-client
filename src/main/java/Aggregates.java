import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Aggregates {
    private String endpoint;
    private Boolean unadjusted;

    private Aggregates(Builder builder) {
        this.endpoint = builder.endpoint;
        this.unadjusted = builder.unadjusted;
    }

    public String endpoint() {
        if (this.unadjusted != null)
            return this.endpoint + "?unadjusted=" + URLEncoder.encode(this.unadjusted.toString(), StandardCharsets.UTF_8);
        else return this.endpoint;
    }

    public static class Builder {
        private String endpoint;
        private Boolean unadjusted;

        public Builder(String ticker, Integer multiplier, String timeSpan, String from, String to) {
            this.endpoint = String.format("/v2/aggs/ticker/%s/range/%s/%s/%s/%s", ticker,
                    multiplier,
                    timeSpan,
                    from,
                    to);
        }

        public Builder unadjusted(Boolean unadjusted) {
            this.unadjusted = unadjusted;
            return this;
        }

        public Aggregates build() {
            return new Aggregates(this);
        }
    }
}
