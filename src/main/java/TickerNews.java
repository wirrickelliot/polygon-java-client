import java.util.HashMap;
import java.util.Map;

public class TickerNews {
    private String endpoint;
    private Integer perPage;
    private Integer page;

    private TickerNews(Builder builder) {
        this.endpoint = builder.endpoint;
        this.perPage = builder.perPage;
        this.page = builder.page;
        this.setParams();
    }

    private void setParams() {
        Map<String, String> params = new HashMap<String, String>();
        if (this.perPage != null) params.put("perPage", this.perPage.toString());
        if (this.page != null) params.put("page", this.page.toString());

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
        private Integer perPage;
        private Integer page;

        public Builder(String symbol) {
            this.endpoint = String.format("/v1/meta/symbols/%s/news", symbol);
        }

        public Builder perPage(Integer perPage) {
            this.perPage = perPage;
            return this;
        }

        public Builder page(Integer page) {
            this.page = page;
            return this;
        }

        public TickerNews build() {
            return new TickerNews(this);
        }
    }
}
