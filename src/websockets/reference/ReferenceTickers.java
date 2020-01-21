import java.lang.reflect.Field;

public class ReferenceTickers {
    private String endpoint = "/v2/reference/tickers";
    private String sort;
    private String type;
    private String market;
    private String locale;
    private String search;
    private Integer perPage;
    private Integer page;
    private Boolean active;

    public ReferenceTickers(Builder builder) {
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
        Field[] fields = getClass().getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            try {
                if (fields[i].get(this) != null) {
                    this.endpoint = String.format("%s?%s=%s", this.endpoint,
                            fields[i].getName(), fields[i].get(this));
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

        public ReferenceTickers build() {
            return new ReferenceTickers(this);
        }
    }
}
