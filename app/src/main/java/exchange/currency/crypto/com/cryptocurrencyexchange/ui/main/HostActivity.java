package exchange.currency.crypto.com.cryptocurrencyexchange.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjector;
import exchange.currency.crypto.com.cryptocurrencyexchange.R;
import exchange.currency.crypto.com.cryptocurrencyexchange.ui.common.view.BaseActivity;
import exchange.currency.crypto.com.cryptocurrencyexchange.util.NetworkHelper;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BaseFragmentInteractionListener;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.markets.MarketFragment;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

//import exchange.currency.crypto.com.cryptocurrencyexchange.view.myrates.MyRatesFragment;
//import exchange.currency.crypto.com.cryptocurrencyexchange.view.ratechanges.RateChangeFragment;

/**
 * The container responsible for showing and destroying relevant {@link Fragment}, handling
 * back and up navigation using the Fragment back stack and maintaining global state
 * and event subscriptions. This is based on the Fragment Oriented Architecture explained here
 * http://vinsol.com/blog/2014/09/15/advocating-fragment-oriented-applications-in-android/
 */

public class HostActivity extends BaseActivity implements BaseFragmentInteractionListener {

    @BindView(R.id.fragment_placeholder)
    FrameLayout rootPlaceholder;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private IntentFilter connectivityIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        ButterKnife.bind(this);

        showFragment(MarketFragment.class);
        setNoConnectivityBroadcast();
        setBottomNavigationChangeListener();
    }

    private OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        showFragment(MarketFragment.class);
                        return true;
                    case R.id.navigation_dashboard:
//                        showFragment(exchange.currency.crypto.com.cryptocurrencyexchange.view.ratechanges.RateChangeFragment.class);
                         return true;
                    case R.id.navigation_notifications:
//                        showFragment(exchange.currency.crypto.com.cryptocurrencyexchange.view.myrates.MyRatesFragment.class);
                        return true;
                }
                return false;
            };

    @Override
    protected void onResume() {
        registerReceiver(connectivityBroadcastReceiver, connectivityIntentFilter);
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(connectivityBroadcastReceiver);
    }

    BroadcastReceiver connectivityBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (!NetworkHelper.getInstance().isNetworkAvailable(context)) {
                Toast.makeText(context, "Please check connectivity", Toast.LENGTH_SHORT).show();
            }
        }
    };


    private void setBottomNavigationChangeListener() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    // todo - move to presenter?
    private void setNoConnectivityBroadcast() {
        connectivityIntentFilter = new IntentFilter(CONNECTIVITY_ACTION);
    }

    @Override
    public AndroidInjector<android.app.Fragment> fragmentInjector() {
        return null;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
