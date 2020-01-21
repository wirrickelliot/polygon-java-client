import java.lang.reflect.Field;

public class ReferenceStockFinancials {
    private String endpoint;
    private Integer limit;
    private String type;
    private String sort;

    public ReferenceStockFinancials(Builder builder) {
        this.endpoint = builder.endpoint;
        this.limit = builder.limit;
        this.type = builder.type;
        this.sort = builder.sort;
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

        public ReferenceStockFinancials build() {
            return new ReferenceStockFinancials(this);
        }
    }
}
