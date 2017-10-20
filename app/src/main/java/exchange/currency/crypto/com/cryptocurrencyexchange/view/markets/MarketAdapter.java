package exchange.currency.crypto.com.cryptocurrencyexchange.view.markets;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import exchange.currency.crypto.com.cryptocurrencyexchange.R;
import exchange.currency.crypto.com.cryptocurrencyexchange.MarketUpdate;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder> {

    private List<MarketUpdate> marketUpdates = new ArrayList<>();
    private Fragment fragment;

    public MarketAdapter(Fragment fragment, List<MarketUpdate> marketUpdates) {
        this.marketUpdates = marketUpdates;
        this.fragment = fragment;
    }

    @Override
    public MarketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.market_list_item, parent, false);

        return new MarketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MarketViewHolder holder, int position) {
        MarketUpdate marketUpdate = marketUpdates.get(position);

        holder.setMarketName(marketUpdate.getMarket());
        holder.setPrice(BigDecimal.valueOf(Long.parseLong(marketUpdate.getPrice())));
        holder.setVolume(marketUpdate.getVolume());
    }

    //todo add method depending on list returned or item

    @Override
    public int getItemCount() {
        return marketUpdates.size();
    }


    class MarketViewHolder extends RecyclerView.ViewHolder{

        private final NumberFormat PRICE_FORMAT = new DecimalFormat("#0.00");

        @BindView(R.id.market_item_name)
        TextView nameView;
        @BindView(R.id.market_item_price)
        TextView priceView;
        @BindView(R.id.market_item_volume)
        TextView volumeView;

        public MarketViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setMarketName(String name){
            this.nameView.setText(name);
        }

        void setPrice(BigDecimal price){
            if (price != null){
                this.priceView.setText(PRICE_FORMAT.format(price.floatValue()));
            }
        }

        void setVolume(String volume){
            volumeView.setText(volume);
        }
    }
}
