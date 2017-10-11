package exchange.currency.crypto.com.cryptocurrencyexchange.view.base;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import exchange.currency.crypto.com.cryptocurrencyexchange.R;

/**
 * Abstract base class to be extended by any MVP View such as {@link Fragment} and
 * {@link android.support.v4.app.ActivityCompat}. It contains common attributes and methods to be
 * shared across Presenters.
 */

public abstract class BaseView extends Fragment implements BaseViewInteractor {

    @BindView(R.id.progressBar)
    protected ProgressBar progressBar;

    @Override
    public void setProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

}
