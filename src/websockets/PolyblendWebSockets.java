import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;

public class PolyblendWebSockets{
    private String apiKey;
    private String endpoint = "wss://socket.polygon.io/";
    private WebSocket webSocket;
    private CountDownLatch latch = new CountDownLatch(1);
    private CompletableFuture<Void> future;

    public PolyblendWebSockets(String apiKey, String cluster) {
        this.apiKey = apiKey;
        this.endpoint = this.endpoint + cluster;
    }

    public void open() {
        this.webSocket = HttpClient
                .newHttpClient()
                .newWebSocketBuilder()
                .buildAsync(URI.create(this.endpoint), new WebSocketClient(this.apiKey, latch))
                .join();
        future = CompletableFuture.runAsync(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void close() {
        this.webSocket.abort();
    }

    // TODO: Parse parameters
    public void subscribe(String params) {
        this.sendText("subscribe", params);
    }

    // TODO: Parse parameters
    public void unsubscribe(String params) {
        this.sendText("unsubscribe", params);
    }

    // TODO: Parse parameters
    private void sendText(String action, String params) {
        String text = String.format("{\"action\":\"%s\",\"params\":\"%s\"}", action, params);
        this.webSocket.sendText(text, true);
    }

    private static class WebSocketClient implements WebSocket.Listener {
        private String apiKey;
        private final CountDownLatch latch;

        public WebSocketClient(String apiKey, CountDownLatch latch) {
            this.apiKey = apiKey;
            this.latch = latch;
        }

        @Override
        public void onOpen(WebSocket webSocket) {
            WebSocket.Listener.super.onOpen(webSocket);
            webSocket.sendText("{\"action\":\"auth\",\"params\":\"" + this.apiKey + "\"}", true);
        }

        @Override
        public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
            System.out.println(data);
            return WebSocket.Listener.super.onText(webSocket, data, last);
        }

        @Override
        public void onError(WebSocket webSocket, Throwable error) {
            System.out.println("Error: " + webSocket.toString());
            WebSocket.Listener.super.onError(webSocket, error);
        }
    }
}
