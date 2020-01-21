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
        ReferenceTickers referenceTickers = new ReferenceTickers.Builder()
                .sort("type")
                .type("cs")
                .market("stocks")
                .locale("us")
                .search("microsoft")
                .perPage(10)
                .page(1)
                .active(true)
                .build();
        poly.get(referenceTickers.endpoint());

        // -- ReferenceTickerTypes --
        ReferenceTickerTypes referenceTickerTypes = new ReferenceTickerTypes.Builder()
                .build();
        poly.get(referenceTickerTypes.endpoint());

        // -- ReferenceTickerDetails --
        ReferenceTickerDetails referenceTickerDetails = new ReferenceTickerDetails.Builder("AAPL")
                .build();
        poly.get(referenceTickerDetails.endpoint());

        // -- ReferenceTickerNews --
        ReferenceTickerNews referenceTickerNews = new ReferenceTickerNews.Builder("AAPL")
                .perPage(10)
                .page(1)
                .build();
        poly.get(referenceTickerNews.endpoint());

        // -- ReferenceMarkets --
        ReferenceMarkets referenceMarkets = new ReferenceMarkets.Builder()
                .build();
        poly.get(referenceMarkets.endpoint());

        // -- ReferenceLocales --
        ReferenceLocales referenceLocales = new ReferenceLocales.Builder()
                .build();
        poly.get(referenceLocales.endpoint());

        // -- ReferenceStockSplits --
        ReferenceStockSplits referenceStockSplits = new ReferenceStockSplits.Builder("AAPL")
                .build();
        poly.get(referenceStockSplits.endpoint());

        // --ReferenceStockDividends --
        ReferenceStockDividends referenceStockDividends = new ReferenceStockDividends.Builder("APPL")
                .build();
        poly.get(referenceStockDividends.endpoint());

        // -- ReferenceStockFinancials --
        ReferenceStockFinancials referenceStockFinancials = new ReferenceStockFinancials.Builder("APPL")
                .limit(5)
                .type("Y")
                .sort("reportPeriod")
                .build();
        poly.get(referenceStockFinancials.endpoint());

        // -- ReferenceMarketStatus --
        ReferenceMarketStatus referenceMarketStatus = new ReferenceMarketStatus.Builder()
                .build();
        poly.get(referenceMarketStatus.endpoint());

        // -- ReferenceMarketHolidays --
        ReferenceMarketHolidays referenceMarketHolidays = new ReferenceMarketHolidays.Builder()
                .build();
        poly.get(referenceMarketHolidays.endpoint());
    }
}
