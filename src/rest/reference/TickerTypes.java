public class TickerTypes {

    public TickerTypes() {}

    private String endpoint() {
        return "/v2/reference/types";
    }

    public static class Builder {
        public Builder() {}

        public TickerTypes build() {
            return new TickerTypes();
        }
    }

}