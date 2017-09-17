package market.stock.demo.rx.rxstockmarket.model.getstockupdate;

import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import market.stock.demo.rx.rxstockmarket.api.YahooService;
import market.stock.demo.rx.rxstockmarket.api.YahooServiceGeneratorFactory;
import market.stock.demo.rx.rxstockmarket.model.StockUpdate;

import static market.stock.demo.rx.rxstockmarket.utils.Constants.ENV;
import static market.stock.demo.rx.rxstockmarket.utils.Constants.QUERY;

public class GetStockUpdatePresenter {
    private  GetStockUpdateView view;
    List<StockUpdate> data;

    private static final String TAG = GetStockUpdatePresenter.class.getSimpleName();

    public GetStockUpdatePresenter(GetStockUpdateView view) {
        this.view = view;
    }

    public void getStockQuote(){
        YahooService yahooService = new YahooServiceGeneratorFactory().create();

        yahooService.yqlQuery(QUERY, ENV)
                .subscribeOn(Schedulers.io())
                .toObservable()
                .map(r -> r.getQuery().getResults().getQuote())
                .flatMap(r -> Observable.fromIterable(r))
                .map(r -> StockUpdate.create(r))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stockUpdate -> {
                    Log.d("APP", "New update " + stockUpdate.getStockSymbol());
                    view.showStockUpdates(stockUpdate);
                });
    }
}