import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;

public class PolyblendWebSockets{
    public PolyblendWebSockets(String endpoint) {
        CountDownLatch latch = new CountDownLatch(1);
        endpoint = "wss://socket.polygon.io/" + endpoint;
        WebSocket webSocket = HttpClient
               .newHttpClient()
               .newWebSocketBuilder()
               .buildAsync(URI.create(endpoint), new WebSocketClient(latch))
                .join();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class WebSocketClient implements WebSocket.Listener {
        private final CountDownLatch latch;

        public WebSocketClient(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void onOpen(WebSocket webSocket) {
            System.out.println("Connected");
            WebSocket.Listener.super.onOpen(webSocket);
        }

        @Override
        public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
            System.out.println(data);
            latch.countDown();
            return WebSocket.Listener.super.onText(webSocket, data, last);
        }

        @Override
        public void onError(WebSocket webSocket, Throwable error) {
            System.out.println("Error: " + webSocket.toString());
            WebSocket.Listener.super.onError(webSocket, error);
        }
    }
}
