public class Markets {

    private Markets() {}

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