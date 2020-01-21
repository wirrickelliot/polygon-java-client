public class MarketStatus {

    public MarketStatus() {}

    public String endpoint() {
        return "/v1/marketstatus/now";
    }

    public static class Builder {
        public Builder() {}

    public MarketStatus build() {
            return new MarketStatus();
        }
    }
}
