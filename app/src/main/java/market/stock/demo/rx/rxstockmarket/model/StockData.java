package market.stock.demo.rx.rxstockmarket.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class StockData implements Serializable {

    private final String stockSymbol;
    private final BigDecimal price;
    private final Date date;

    public String getStockSymbol() {
        return stockSymbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }


    public StockData(String stockSymbol, BigDecimal price, Date date) {
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.date = date;
    }

}

