public class MarketHolidays {

    public MarketHolidays () {}

    public String endpoint() {
        return "/v1/marketstatus/upcoming";
    }

    public static class Builder {
        public Builder() {}

        public MarketHolidays build() {
            return new MarketHolidays();
        }
    }
}
