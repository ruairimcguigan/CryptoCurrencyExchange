package exchange.currency.crypto.com.cryptocurrencyexchange.view.markets;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import exchange.currency.crypto.com.cryptocurrencyexchange.R;
import exchange.currency.crypto.com.cryptocurrencyexchange.model.json.Market;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BaseFragment;

import static android.view.View.VISIBLE;


public class MarketFragment extends BaseFragment implements MarketView.View{

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.markets_list)
    RecyclerView marketsList;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefresh;

    @Override
    public void setProgressBar(boolean show) {
        if(show){
            progressBar.setVisibility(VISIBLE);
        }
        else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMarketUpdates(Market market) {

    }
}
