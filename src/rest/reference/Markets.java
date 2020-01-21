public class Markets {

    public Markets() {}

    public String endpoint() {
        return "/v2/reference/markets";
    }

    public static class Builder {
        public Builder() {}

        public Markets build() {
            return new Markets();
        }
    }
}