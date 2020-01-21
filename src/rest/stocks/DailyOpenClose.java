public class DailyOpenClose {
    private String endpoint;

    public DailyOpenClose(String symbol, String date) {
        this.endpoint = String.format("/v1/open-close/%s/%s", symbol, date);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
