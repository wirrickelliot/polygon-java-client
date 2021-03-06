[![Build Status](https://travis-ci.org/wirrickelliot/polygon-java-client.svg?branch=master)](https://travis-ci.org/wirrickelliot/polygon-java-client)
# PolygonIO Java
Java client for the Polygon.io API using only the Java Class Libraries. Requires JDK 11+.

Add to your build via JitPack: https://jitpack.io/#wirrickelliot/polygon-java-client.



## RESTful Demo

```java
import java.net.http.HttpResponse;

public static void main(String[] args) {
    PolygonIO.Rest restClient = new PolygonIO.Rest(YOUR_API_KEY);
    Tickers tickers = new Tickers.Builder()
                .sort("type")
                .type("cs")
                .market("stocks")
                .locale("us")
                .search("microsoft")
                .perPage(50)
                .page(1)
                .active(true)
                .build();
    TickerTypes tickerTypes = new TickerTypes();
    TickerDetails tickerDetails = new TickerDetails("AAPL");
    
    HttpResponse<String> resp;

    resp = restClient.get(tickers.endpoint());
    System.out.printf("%s: %s\n", resp.statusCode(), resp.body());

    resp = restClient.get(tickerTypes.endpoint());
    System.out.printf("%s: %s\n", resp.statusCode(), resp.body());

    resp = restClient.get(tickerDetails.endpoint());
    System.out.printf("%s: %s\n", resp.statusCode(), resp.body());
}
```

## WebSockets Demo

```java
import java.util.function.Function;

public static void main(String[] args) {
    Function<String, String> messageHandler = e -> {
        System.out.println(e);
        return null;
    };
    PolygonIO.WebSockets wsClient = new PolygonIO.WebSockets(YOUR_API_KEY, messageHandler);

    wsClient.connect("stocks");
    wsClient.subscribe("T.AAPL", "T.AMD");
    Thread.sleep(1000);
}
```
