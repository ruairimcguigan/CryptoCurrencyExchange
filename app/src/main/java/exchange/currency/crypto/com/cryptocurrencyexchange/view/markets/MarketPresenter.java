package exchange.currency.crypto.com.cryptocurrencyexchange.view.markets;

import android.util.Log;

import exchange.currency.crypto.com.cryptocurrencyexchange.model.api.CryptoCurrencyService;
import exchange.currency.crypto.com.cryptocurrencyexchange.model.api.CryptoCurrencyServiceFactory;
import exchange.currency.crypto.com.cryptocurrencyexchange.model.json.CryptoResult;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BasePresenter;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.markets.MarketView.Presenter;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.markets.MarketView.View;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MarketPresenter extends BasePresenter<View> implements Presenter {

    private static final String TAG = MarketPresenter.class.getSimpleName();
    private MarketView view;

    public MarketPresenter(MarketView view) {
        this.view = view;
    }

    @Override
    public void getMarketUpdates() {

       CryptoCurrencyService currencyService = new CryptoCurrencyServiceFactory().create();
       currencyService.cryptoMarketQuery("btc-usd")
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe((CryptoResult data) -> {
                   Log.d(TAG, "getMarketUpdates: " + data.getQuery().getMarketUpdates());
               });

    }
}
