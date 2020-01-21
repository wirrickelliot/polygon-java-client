import com.sun.source.tree.ClassTree;

public class LastCurrencyQuote {
    private String endpoint;

    private LastCurrencyQuote(Builder builder) {
       this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
       private String endpoint;

       public Builder(String from, String to) {
            this.endpoint = String.format("/v1/last_quote/currencies/%s/%s", from, to);
       }

       public LastCurrencyQuote build() {
           return new LastCurrencyQuote(this);
       }
    }
}
