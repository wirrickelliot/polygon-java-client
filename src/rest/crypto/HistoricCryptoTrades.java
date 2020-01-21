import java.lang.reflect.Field;

public class HistoricCryptoTrades {
    private String endpoint;
    private Integer offset;
    private Integer limit;

    private HistoricCryptoTrades(Builder builder) {
       this.endpoint = builder.endpoint;
       this.offset = builder.offset;
       this.limit = builder.limit;
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
        private Integer offset;
        private Integer limit;

        public Builder(String from, String to, String date) {
            this.endpoint = String.format("/v1/open-close/crypto/%s/%s/%s", from, to, date);
        }

        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public HistoricCryptoTrades build() {
            return new HistoricCryptoTrades(this);
        }
    }
}
