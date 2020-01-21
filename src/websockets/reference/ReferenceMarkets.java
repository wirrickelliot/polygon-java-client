public class ReferenceMarkets {

    public ReferenceMarkets() {}

    public String endpoint() {
        return "/v2/reference/markets";
    }

    public static class Builder {
        public Builder() {}

        public ReferenceMarkets build() {
            return new ReferenceMarkets();
        }
    }
}