package exchange.currency.crypto.com.cryptocurrencyexchange.view.markets;

import android.util.Log;

import exchange.currency.crypto.com.cryptocurrencyexchange.model.api.CryptoCurrencyService;
import exchange.currency.crypto.com.cryptocurrencyexchange.model.api.CryptoCurrencyServiceFactory;
import exchange.currency.crypto.com.cryptocurrencyexchange.model.json.CryptoResult;
import exchange.currency.crypto.com.cryptocurrencyexchange.model.json.MarketUpdate;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BasePresenter;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.markets.MarketView.Presenter;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.markets.MarketView.View;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MarketPresenter extends BasePresenter<View> implements Presenter {

    private static final String TAG = MarketPresenter.class.getSimpleName();
    private MarketView.View view;
    private MarketView.Presenter presenter;

    public MarketPresenter(MarketView.View view) {
        this.view = view;
    }

    @Override
    public void getMarketUpdates() {

       CryptoCurrencyService currencyService = new CryptoCurrencyServiceFactory().create();
       currencyService.cryptoMarketQuery("btc-usd")
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe((CryptoResult marketUpdate) -> {
                   Log.d(TAG, "getCurrencyUpdatesAllDetails: " + marketUpdate.getQuery().getCurrencyUpdatesAllDetails());

//                   view.showMarketUpdates(marketUpdate.getQuery().getCurrencyUpdatesAllDetails());
               });

    }

    @Override
    public void getCurrencyUpdatesPerMarket() {

        CryptoCurrencyService currencyService = new CryptoCurrencyServiceFactory().create();

        currencyService.cryptoMarketQuery("btc-usd")
                // convert an Observable of the Single type into an actual Observable
                // to match the type of Observable.fromIterable()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .map(r -> r.getQuery().getCurrencyUpdatesAllDetails())
                .flatMap(Observable::fromIterable)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(r -> {
                    Log.d(TAG, "getCurrencyUpdatesAllDetails: " + r.getMarket());

                    MarketUpdate marketUpdate = new MarketUpdate(r.getMarket(), r.getVolume(), r.getPrice());
                    view.setProgressBar(false);
                    view.showMarketUpdates(marketUpdate);

                });

    }
}
