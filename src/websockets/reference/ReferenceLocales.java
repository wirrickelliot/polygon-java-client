public class ReferenceLocales {

    public ReferenceLocales() {}

    public String endpoint() {
        return "/v2/reference/locales";
    }

    public static class Builder {
        public Builder() {}

        public ReferenceLocales build() {
            return new ReferenceLocales();
        }
    }
}