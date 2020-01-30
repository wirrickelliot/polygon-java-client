import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Tickers {
    private String endpoint = "/v2/reference/tickers";
    private String sort;
    private String type;
    private String market;
    private String locale;
    private String search;
    private Integer perPage;
    private Integer page;
    private Boolean active;

    public Tickers(Builder builder) {
        this.sort = builder.sort;
        this.type = builder.type;
        this.market = builder.market;
        this.locale = builder.locale;
        this.search = builder.search;
        this.perPage = builder.perPage;
        this.page = builder.page;
        this.active = builder.active;
        this.setParams();
    }

    private void setParams() {
        Map<String, String> params = new HashMap<String, String>();
        if (this.sort != null) params.put("sort", this.sort);
        if (this.type != null) params.put("type", this.type);
        if (this.market != null) params.put("market", this.market);
        if (this.locale != null) params.put("locale", this.locale);
        if (this.search != null) params.put("search", this.search);
        if (this.perPage != null) params.put("perPage", this.perPage.toString());
        if (this.page != null) params.put("page", this.page.toString());
        if (this.active != null) params.put("active", this.active.toString());

        this.endpoint = this.endpoint + params.entrySet().stream()
                .map(p -> p.getKey() + "=" + URLEncoder.encode(p.getValue(), StandardCharsets.UTF_8))
                .reduce((p1, p2) -> p1 + "&" + p2)
                .map(s -> "?" + s)
                .orElse("");
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String sort;
        private String type;
        private String market;
        private String locale;
        private String search;
        private Integer perPage;
        private Integer page;
        private Boolean active;

        public Builder() {}

        public Builder sort(String sort) {
            this.sort = sort;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder market(String market) {
            this.market = market;
            return this;
        }

        public Builder locale(String locale) {
            this.locale = locale;
            return this;
        }

        public Builder search(String search) {
            this.search = search;
            return this;
        }

        public Builder perPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }

        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Tickers build() {
            return new Tickers(this);
        }
    }
}
