public class ConditionMappings {
    private String endpoint;

    public ConditionMappings(String tickType) {
        this.endpoint = String.format("/v1/meta/conditions/%s", tickType);
    }

    public String endpoint() {
        return this.endpoint;
    }
}
