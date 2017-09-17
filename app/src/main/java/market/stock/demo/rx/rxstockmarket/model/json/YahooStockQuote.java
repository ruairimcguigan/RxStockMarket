package market.stock.demo.rx.rxstockmarket.model.json;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class YahooStockQuote {

    private String symbol;

    @SerializedName("Name")
    private String name;

    @SerializedName("DaysLow")
    private BigDecimal daysLow;

    @SerializedName("LastTradePriceOnly")
    private BigDecimal lastTradePriceOnly;

    @SerializedName("DaysHigh")
    private BigDecimal daysHigh;

    @SerializedName("Volume")
    private String volume;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDaysLow() {
        return daysLow;
    }

    public void setDaysLow(BigDecimal daysLow) {
        this.daysLow = daysLow;
    }

    public BigDecimal getDaysHigh() {
        return daysHigh;
    }

    public void setDaysHigh(BigDecimal daysHigh) {
        this.daysHigh = daysHigh;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public BigDecimal getLastTradePriceOnly() {
        return lastTradePriceOnly;
    }

    public void setLastTradePriceOnly(BigDecimal lastTradePriceOnly) {
        this.lastTradePriceOnly = lastTradePriceOnly;
    }
}
