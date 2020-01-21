import java.lang.reflect.Field;

public class RealtimeCurrencyConversion {
    private String endpoint;
    private Integer amount;
    private Integer precision;

    private RealtimeCurrencyConversion(Builder builder) {
        this.endpoint = builder.endpoint;
        this.amount = builder.amount;
        this.precision = builder.precision;
        this.setParams();
    }

    private void setParams() {
        String symbol;
        Field[] fields = getClass().getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            symbol = (!this.endpoint.contains("?")) ? "?" : "&";
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
        private Integer amount;
        private Integer precision;

        public Builder(String from, String to) {
            this.endpoint = String.format("/v1/conversion/%s/%s", from, to);
        }

        public Builder amount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Builder precision(Integer precision) {
            this.precision = precision;
            return this;
        }

        public RealtimeCurrencyConversion build() {
            return new RealtimeCurrencyConversion(this);
        }
    }
}
