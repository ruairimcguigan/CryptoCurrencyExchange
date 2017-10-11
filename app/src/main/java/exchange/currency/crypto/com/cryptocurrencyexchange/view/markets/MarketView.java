package exchange.currency.crypto.com.cryptocurrencyexchange.view.markets;

import exchange.currency.crypto.com.cryptocurrencyexchange.model.json.MarketUpdate;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BasePresenterInteractor;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BaseViewInteractor;

 interface MarketView {

    interface View extends BaseViewInteractor {

        void showMarketUpdates(MarketUpdate marketUpdate);
    }

    interface Presenter extends BasePresenterInteractor<View> {

        void getMarketUpdates();
    }
}
