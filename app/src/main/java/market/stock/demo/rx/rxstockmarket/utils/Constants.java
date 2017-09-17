package market.stock.demo.rx.rxstockmarket.utils;


public class Constants {

    public static final String BASE_URL = "https://query.yahooapis.com/v1/public/";
    public static String QUERY = "select * from yahoo.finance.quote where symbol in ('YHOO','AAPL','GOOG','MSFT')";
    public static String ENV = "store://datatables.org/alltableswithkeys";
}
