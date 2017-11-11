package exchange.currency.crypto.com.cryptocurrencyexchange.view.base;

/**
 * Created by c0249298 on 04/10/2017.
 */

public class BasePresenter<V> implements BasePresenterInteractor<V> {

    protected V view;

    @Override
    public void onViewActive(V view) {
        this.view = view;
    }

    @Override
    public void onViewInactive() {
        view = null;
    }
}