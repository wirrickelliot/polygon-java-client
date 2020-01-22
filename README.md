# Polyblend
Java client for the Polygon.io API

## RESTful Demo

```java
public static void main(String[] args) {
    PolyblendRest polyblendRest = new PolyblendRest(YOUR_API_KEY);
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
    
    polyblendRest.get(tickers.endpoint());
    polyblendRest.get(tickerTypes.endpoint());
    polyblendRest.get(tickerDetails.endpoint());
}
```

## WebSockets Demo

```java
public static void main(String[] args) {
    PolyblendWebSockets polyblendWebSockets = new PolyblendWebSockets(YOUR_API_KEY, "stocks")
    polyblendWebSockets.open();

    polyblendWebSockets.subscribe("T.AAPL");
    Thread.sleep(1000);

    polyblendWebSockets.close();
}
```

## Requirements

Java 11
