import java.lang.reflect.Field;

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
        String symbol;
        Field[] fields = getClass().getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            symbol = (i == 1) ? "?" : "&";
            try {
                if (fields[i].get(this) != null) {
                    this.endpoint = String.format("%s%s%s=%s", this.endpoint,
                            symbol, fields[i].getName(), fields[i].get(this));
                }
            } catch(IllegalAccessException e){
                e.printStackTrace();
            }
        }
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
