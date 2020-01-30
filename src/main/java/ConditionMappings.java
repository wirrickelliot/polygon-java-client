import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ConditionMappings {
    private String endpoint;

    public ConditionMappings(String tickType) {
        this.endpoint = String.format("/v1/meta/conditions/%s", URLEncoder.encode(tickType, StandardCharsets.UTF_8));
    }

    public String endpoint() {
        return this.endpoint;
    }
}
