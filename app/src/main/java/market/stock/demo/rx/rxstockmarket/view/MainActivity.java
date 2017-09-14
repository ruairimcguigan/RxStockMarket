package market.stock.demo.rx.rxstockmarket.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import market.stock.demo.rx.rxstockmarket.R;
import market.stock.demo.rx.rxstockmarket.model.StockData;
import market.stock.demo.rx.rxstockmarket.model.StockDataAdapter;

import static java.math.BigDecimal.valueOf;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hello_world_salute)
    TextView helloText;

    @BindView(R.id.stock_updates_recycler_view)
    RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;
    private StockDataAdapter stockDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initList();
        createObservableSource();
    }

    private void initList() {
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        stockDataAdapter = new StockDataAdapter();
        recyclerView.setAdapter(stockDataAdapter);
    }

    private void createObservableSource() {
        Observable.just(
                (new StockData("Google", valueOf(12.43), new Date())),
                (new StockData("Apple", valueOf(30.01), new Date())),
                (new StockData("Samsung", valueOf(25.99), new Date())),
                (new StockData("Audi", valueOf(22.33), new Date())),
                (new StockData("McDonalds", valueOf(12.43), new Date())),
                (new StockData("Aquidigital", valueOf(30.01), new Date())),
                (new StockData("Amstrad", valueOf(22.99), new Date())),
                (new StockData("Phyzer", valueOf(12.33), new Date())),
                (new StockData("Coca Cola", valueOf(54.88), new Date())))

                .doOnNext(log -> Log.d("APP", "New update " + log.getStockSymbol()))
                .subscribe(stockData -> stockDataAdapter.add(stockData));
    }
}
