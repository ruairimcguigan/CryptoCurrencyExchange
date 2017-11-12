package exchange.currency.crypto.com.cryptocurrencyexchange.ui.myrates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BaseFragmentInteractionListener;
import exchange.currency.crypto.com.cryptocurrencyexchange.view.base.BaseView;

/**
 * Created by aquidigitalltd on 11/10/2017.
 */

public class MyRatesFragment extends BaseView implements MyRatesView.View{

    private BaseFragmentInteractionListener baseFragmentInteractionListener;
    private MyRatesView.Presenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "My Rates Fragment", Toast.LENGTH_SHORT).show();

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
