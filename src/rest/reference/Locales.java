public class Locales {

    public Locales() {}

    public String endpoint() {
        return "/v2/reference/locales";
    }

    public static class Builder {
        public Builder() {}

        public Locales build() {
            return new Locales();
        }
    }
}