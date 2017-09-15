package market.stock.demo.rx.rxstockmarket.model.json;


import java.util.List;

class YahooStockResults {

    private List<YahooStockQuote> quote;

    public List<YahooStockQuote> getQuote() {
        return quote;
    }

    public void setQuote(List<YahooStockQuote> quote) {
        this.quote = quote;
    }

}
