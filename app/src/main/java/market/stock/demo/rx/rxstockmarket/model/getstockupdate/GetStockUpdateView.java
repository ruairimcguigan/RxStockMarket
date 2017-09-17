package market.stock.demo.rx.rxstockmarket.model.getstockupdate;

import market.stock.demo.rx.rxstockmarket.model.StockUpdate;

public interface GetStockUpdateView {

    void showStockUpdates(StockUpdate stockUpdate);

    void showProgress();

    void hideProgress();
}
