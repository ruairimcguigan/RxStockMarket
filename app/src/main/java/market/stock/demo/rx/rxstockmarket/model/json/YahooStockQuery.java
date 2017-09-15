package market.stock.demo.rx.rxstockmarket.model.json;

import java.util.Date;

public class YahooStockQuery {

    private int count;
    private Date created;
    private YahooStockResults results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public YahooStockResults getResults() {
        return results;
    }

    public void setResults(YahooStockResults results) {
        this.results = results;
    }
}
