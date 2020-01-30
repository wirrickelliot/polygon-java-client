import java.util.HashMap;
import java.util.Map;

public class HistoricQuotes {
    private String endpoint;
    private Integer timestamp;
    private Integer timestampLimit;
    private Boolean reverse;
    private Integer limit;

    private HistoricQuotes (Builder builder) {
        this.endpoint = builder.endpoint;
        this.timestamp = builder.timestamp;
        this.timestampLimit = builder.timestampLimit;
        this.reverse = builder.reverse;
        this.limit = builder.limit;
        this.setParams();
    }

    private void setParams() {
        Map<String, String> params = new HashMap<String, String>();
        if (this.timestamp != null) params.put("timestamp", this.timestamp.toString());
        if (this.timestampLimit != null) params.put("timestampLimit", this.timestampLimit.toString());
        if (this.reverse != null) params.put("reverse", this.reverse.toString());
        if (this.limit != null) params.put("limit", this.limit.toString());

        this.endpoint = this.endpoint + params.entrySet().stream()
                .map(p -> p.getKey() + "=" + p.getValue())
                .reduce((p1, p2) -> p1 + "&" + p2)
                .map(s -> "?" + s)
                .orElse("");
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;
        private Integer timestamp;
        private Integer timestampLimit;
        private Boolean reverse;
        private Integer limit;

        public Builder(String ticker, String date) {
            this.endpoint = String.format("/v2/ticks/stocks/nbbo/%s/%s", ticker, date);
        }

        public Builder timestamp(Integer timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder timestampLimit(Integer timestampLimit) {
            this.timestampLimit = timestampLimit;
            return this;
        }

        public Builder reverse(Boolean reverse) {
            this.reverse = reverse;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public HistoricQuotes build() {
            return new HistoricQuotes (this);
        }
    }
}