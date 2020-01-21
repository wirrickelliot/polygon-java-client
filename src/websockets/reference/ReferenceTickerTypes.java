public class ReferenceTickerTypes {

    public ReferenceTickerTypes() {}

    public String endpoint() {
        return "/v2/reference/types";
    }

    public static class Builder {
        public Builder() {}

        public ReferenceTickerTypes build() {
            return new ReferenceTickerTypes();
        }
    }

}
