public class ReferenceMarketHolidays {

    public ReferenceMarketHolidays () {}

    public String endpoint() {
        return "/v1/marketstatus/upcoming";
    }

    public static class Builder {
        public Builder() {}

        public ReferenceMarketHolidays build() {
            return new ReferenceMarketHolidays();
        }
    }
}
