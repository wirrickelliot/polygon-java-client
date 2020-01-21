public class Exchanges {

    private Exchanges() {}

    public String endpoint() {
        return "/v1/meta/exchanges";
    }

    public static class Builder {
        public Builder() {}

        public Exchanges build() {
            return new Exchanges();
        }
    }
}
