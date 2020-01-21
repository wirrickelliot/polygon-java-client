public class ConditionMappings {
    private String endpoint;

    private ConditionMappings(Builder builder) {
        this.endpoint = builder.endpoint;
    }

    public String endpoint() {
        return this.endpoint;
    }

    public static class Builder {
        private String endpoint;

        public Builder(String tickType) {
            this.endpoint = String.format("/v1/meta/conditions/%s", tickType);
        }

        public ConditionMappings build() {
            return new ConditionMappings(this);
        }
    }
}
