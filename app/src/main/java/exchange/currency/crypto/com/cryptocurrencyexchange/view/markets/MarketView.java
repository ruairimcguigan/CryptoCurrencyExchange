package exchange.currency.crypto.com.cryptocurrencyexchange.view.markets;

import exchange.currency.crypto.com.cryptocurrencyexchange.model.json.Market;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BasePresenterInteractor;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BaseViewInteractor;

/**
 * Created by c0249298 on 04/10/2017.
 */

 interface MarketView {

    interface View extends BaseViewInteractor {

        void showMarketUpdates(Market market);
    }

    interface Presenter extends BasePresenterInteractor<View> {

        void getMarketUpdates();
    }
}
