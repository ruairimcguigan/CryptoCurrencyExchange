package exchange.currency.crypto.com.cryptocurrencyexchange.view.markets;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import exchange.currency.crypto.com.cryptocurrencyexchange.R;
import exchange.currency.crypto.com.cryptocurrencyexchange.model.json.MarketUpdate;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BaseView;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BaseFragmentInteractionListener;

import static android.view.View.VISIBLE;


/**
 * * The {@link Fragment} that receives markets update data from its {@link MarketPresenter} and
 * renders a list of markets, with name, price and volume, and also handles user actions.
 */
public class MarketFragment extends BaseView implements MarketView.View{

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.markets_list)
    RecyclerView marketsList;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefresh;

    private BaseFragmentInteractionListener baseFragmentInteractionListener;
    private MarketAdapter marketAdapter;
    private List<MarketUpdate> marketsData = new ArrayList<>();
    private MarketView.Presenter presenter;
    private boolean shouldRefreshMarkets;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "Market Fragment", Toast.LENGTH_SHORT).show();

        return super.onCreateView(inflater, container, savedInstanceState);

    }

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
    public void onAttach(Context context) {
        super.onAttach(context);
        baseFragmentInteractionListener = (BaseFragmentInteractionListener)getActivity();
    }

    @Override
    public void showMarketUpdates(MarketUpdate marketUpdate) {

    }
}
