import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> params = new HashMap<String, String>();
        if (this.amount != null) params.put("amount", this.amount.toString());
        if (this.precision != null) params.put("precision", this.precision.toString());

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
