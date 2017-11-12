package exchange.currency.crypto.com.cryptocurrencyexchange.ui.markets;

import exchange.currency.crypto.com.cryptocurrencyexchange.model.json.MarketUpdate;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BasePresenterInteractor;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BaseViewInteractor;

 public interface MarketView {

    interface View extends BaseViewInteractor {

        void showMarketUpdates(MarketUpdate marketUpdate);
    }

  public interface Presenter extends BasePresenterInteractor<View> {

        void getMarketUpdates();

        void getCurrencyUpdatesPerMarket();
    }
}
