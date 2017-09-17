package market.stock.demo.rx.rxstockmarket.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import market.stock.demo.rx.rxstockmarket.R;
import market.stock.demo.rx.rxstockmarket.model.StockDataAdapter;
import market.stock.demo.rx.rxstockmarket.model.StockUpdate;
import market.stock.demo.rx.rxstockmarket.model.getstockupdate.GetStockUpdatePresenter;
import market.stock.demo.rx.rxstockmarket.model.getstockupdate.GetStockUpdateView;

public class GetStockUpdateActivity extends AppCompatActivity
        implements GetStockUpdateView{

    @BindView(R.id.hello_world_salute)
    TextView helloText;

    @BindView(R.id.stock_updates_recycler_view)
    RecyclerView recyclerView;

    private GetStockUpdatePresenter presenter;
    private LinearLayoutManager layoutManager;
    private StockDataAdapter stockDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        setPresenter();
        initList();
        setAdapter();
        createObservableSource();
    }

    private void setPresenter() {
        presenter = new GetStockUpdatePresenter(this);
    }

    private void initList() {
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setAdapter() {
        stockDataAdapter = new StockDataAdapter();
        recyclerView.setAdapter(stockDataAdapter);

    }

    private void createObservableSource() {
        presenter.getStockQuote();
    }

    @Override
    public void showStockUpdates(StockUpdate stockUpdate) {
        stockDataAdapter.add(stockUpdate);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
