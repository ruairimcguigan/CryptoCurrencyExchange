package exchange.currency.crypto.com.cryptocurrencyexchange.view.markets;

import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import exchange.currency.crypto.com.cryptocurrencyexchange.R;
import exchange.currency.crypto.com.cryptocurrencyexchange.model.json.Market;

/**
 * Created by c0249298 on 05/10/2017.
 */

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> {

    private List<Market> markets;
    private Fragment fragment;

    public MarketAdapter(Fragment fragment, List<Market> markets) {
        this.markets = markets;
        this.fragment = fragment;
    }

    @Override
    public MarketAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.market_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
