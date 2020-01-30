import java.util.HashMap;
import java.util.Map;

public class StockFinancials {
    private String endpoint;
    private Integer limit;
    private String type;
    private String sort;

    private StockFinancials(Builder builder) {
        this.endpoint = builder.endpoint;
        this.limit = builder.limit;
        this.type = builder.type;
        this.sort = builder.sort;
        this.setParams();
    }

    private void setParams() {
        Map<String, String> params = new HashMap<String, String>();
        if (this.limit != null) params.put("limit", this.limit.toString());
        if (this.type != null) params.put("type", this.type);
        if (this.sort != null) params.put("sort", this.sort);

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
        private Integer limit;
        private String type;
        private String sort;

        public Builder(String symbol) {
            this.endpoint = String.format("/v2/reference/financials/%s", symbol);
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder sort(String sort) {
            this.sort = sort;
            return this;
        }

        public StockFinancials build() {
            return new StockFinancials(this);
        }
    }
}
