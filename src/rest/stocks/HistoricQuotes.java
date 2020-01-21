import java.lang.reflect.Field;

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