import java.util.HashMap;
import java.util.Map;

public class HistoricForexTicks {
    private String endpoint;
    private Integer offset;
    private Integer limit;

    private HistoricForexTicks(Builder builder) {
        this.endpoint = builder.endpoint;
        this.offset = builder.offset;
        this.limit = builder.limit;
        this.setParams();
    }

    private void setParams() {
        Map<String, String> params = new HashMap<String, String>();
        if (this.offset != null) params.put("offset", this.offset.toString());
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
        private Integer offset;
        private Integer limit;

        public Builder(String from, String to, String date) {
            this.endpoint = String.format("/v1/historic/forex/%s/%s/%s", from, to, date);
        }

        public Builder offset(Integer offset) {
           this.offset = offset;
           return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public HistoricForexTicks build() {
            return new HistoricForexTicks(this);
        }
    }
}
