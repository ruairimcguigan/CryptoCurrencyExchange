package exchange.currency.crypto.com.cryptocurrencyexchange.view.base;

/**
 * Created by c0249298 on 04/10/2017.
 */

public interface BasePresenterInteractor<V> {

    void onViewActive(V view);

    void onViewInactive();
}
