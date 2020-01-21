public class LastCryptoTrade {
    private String endpoint;

    public LastCryptoTrade(String from, String to) {
        this.endpoint = String.format("/v1/last/crypto/%s/%s", from, to);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
