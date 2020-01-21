import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class Polygon {
    private String apiKey;
    private HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    private Polygon(String apiKey) {
        this.apiKey = apiKey;
    }

    private String get(String endpoint) {
        endpoint ="https://api.polygon.io" + endpoint + "?apiKey=" + this.apiKey;
        System.out.printf("%s\n", endpoint);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();
        HttpResponse<String> response = null;
        try {
            response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (java.io.IOException | java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.statusCode() + ": " + response.body());
        return response.body();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        Polygon poly = new Polygon("QmGyLmPmDT3Y37Q_piVmZa21erlcA2Q2wvz4_Y");

        // -- ReferenceTickers --
        Tickers tickers = new Tickers.Builder()
                .sort("type")
                .type("cs")
                .market("stocks")
                .locale("us")
                .search("microsoft")
                .perPage(10)
                .page(1)
                .active(true)
                .build();
        poly.get(tickers.endpoint());

        // -- ReferenceTickerTypes --
        TickerTypes tickerTypes = new TickerTypes.Builder()
                .build();
        poly.get(tickerTypes.endpoint());

        // -- ReferenceTickerDetails --
        TickerDetails tickerDetails = new TickerDetails.Builder("AAPL")
                .build();
        poly.get(tickerDetails.endpoint());

        // -- ReferenceTickerNews --
        TickerNews tickerNews = new TickerNews.Builder("AAPL")
                .perPage(10)
                .page(1)
                .build();
        poly.get(tickerNews.endpoint());

        // -- ReferenceMarkets --
        Markets markets = new Markets.Builder()
                .build();
        poly.get(markets.endpoint());

        // -- ReferenceLocales --
        Locales locales = new Locales.Builder()
                .build();
        poly.get(locales.endpoint());

        // -- ReferenceStockSplits --
        StockSplits stockSplits = new StockSplits.Builder("AAPL")
                .build();
        poly.get(stockSplits.endpoint());

        // --ReferenceStockDividends --
        StockDividends stockDividends = new StockDividends.Builder("APPL")
                .build();
        poly.get(stockDividends.endpoint());

        // -- ReferenceStockFinancials --
        StockFinancials stockFinancials = new StockFinancials.Builder("APPL")
                .limit(5)
                .type("Y")
                .sort("reportPeriod")
                .build();
        poly.get(stockFinancials.endpoint());

        // -- ReferenceMarketStatus --
        MarketStatus marketStatus = new MarketStatus.Builder()
                .build();
        poly.get(marketStatus.endpoint());

        // -- ReferenceMarketHolidays --
        MarketHolidays marketHolidays = new MarketHolidays.Builder()
                .build();
        poly.get(marketHolidays.endpoint());
    }
}
