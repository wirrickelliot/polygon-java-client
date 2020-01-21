public class ReferenceMarketStatus {

    public ReferenceMarketStatus() {}

    public String endpoint() {
        return "/v1/marketstatus/now";
    }

    public static class Builder {
        public Builder() {}

    public ReferenceMarketStatus build() {
            return new ReferenceMarketStatus();
        }
    }
}
