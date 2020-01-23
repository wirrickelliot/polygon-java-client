public class DailyCryptoOpenClose {
    private String endpoint;

    public DailyCryptoOpenClose(String from, String to, String date) {
        this.endpoint = String.format("/v1/open-close/crypto/%s/%s/%s", from, to, date);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
