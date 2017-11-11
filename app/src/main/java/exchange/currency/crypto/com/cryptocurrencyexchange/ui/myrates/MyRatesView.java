package exchange.currency.crypto.com.cryptocurrencyexchange.view.myrates;

import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BasePresenterInteractor;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BaseViewInteractor;

/**
 * Created by aquidigitalltd on 11/10/2017.
 */

public interface MyRatesView  {

    interface View extends BaseViewInteractor {
        // TODO: 11/10/2017  add required View contracts for my rates

    }

    interface Presenter extends BasePresenterInteractor<MyRatesView.View> {
        // TODO: 11/10/2017  add required presenter contracts for rate change
    }
}
