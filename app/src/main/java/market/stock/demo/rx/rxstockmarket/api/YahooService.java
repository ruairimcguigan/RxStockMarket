package market.stock.demo.rx.rxstockmarket.api;

import io.reactivex.Single;
import market.stock.demo.rx.rxstockmarket.model.json.YahooStockResult;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YahooService {

    @GET("yql?format=json")
    Single<YahooStockResult> yqlQuery(
            @Query("q") String query,
            @Query("env") String env
    );
}
