package market.stock.demo.rx.rxstockmarket.model;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import market.stock.demo.rx.rxstockmarket.R;


public class StockDataAdapter extends RecyclerView.Adapter<StockDataAdapter.StockUpdateViewHolder> {

    private final List<StockUpdate> data = new ArrayList<>();

    @Override
    public StockUpdateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stock_update_item, parent, false);

        return new StockUpdateViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StockUpdateViewHolder holder, int position) {

        StockUpdate stockUpdate = data.get(position);

        holder.setStockSymbol(stockUpdate.getStockSymbol());
        holder.setPrice(stockUpdate.getPrice());
        holder.setDate(stockUpdate.getDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void add(StockUpdate newStockUpdate) {
        for (StockUpdate stockUpdate : data) {

            if (stockUpdate.getPrice() != null) {
                if (stockUpdate.getStockSymbol().equals(newStockUpdate.getStockSymbol())) {
                    if (stockUpdate.getPrice().equals(newStockUpdate.getPrice())) {
                        return;
                    }
                    break;
                }
            }
        }

        this.data.add(0, newStockUpdate);
        notifyItemInserted(0);
    }


    class StockUpdateViewHolder extends RecyclerView.ViewHolder {

        private final NumberFormat PRICE_FORMAT = new DecimalFormat("#0.00");

        @BindView(R.id.stock_item_symbol)
        TextView stockSymbol;
        @BindView(R.id.stock_item_date)
        TextView date;
        @BindView(R.id.stock_item_price)
        TextView price;

        StockUpdateViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

        void setStockSymbol(String stockSymbol) {
            this.stockSymbol.setText(stockSymbol);
        }

        void setPrice(BigDecimal price) {
            if (price != null) {
                this.price.setText(PRICE_FORMAT.format(price.floatValue()));
            }
        }

        void setDate(Date date) {
            this.date.setText(DateFormat.format("yyyy-MM-dd hh:mm", date));
        }
    }
}
