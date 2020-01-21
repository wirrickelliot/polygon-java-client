# polygon-java-client
Polygon.io API libraries for Java

## RESTful Demo

```java
public static void main(String[] args) {
    Polygon polygon = new Polygon(YOUR_API_KEY);
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
    
    polygon.get(tickers.endpoint());
    polygon.get(tickerTypes.endpoint());
    polygon.get(tickerDetails.endpoint());
}
```
