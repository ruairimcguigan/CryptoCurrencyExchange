package exchange.currency.crypto.com.cryptocurrencyexchange.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class NetworkHelper {

    private static NetworkHelper networkHelper;

    public static synchronized NetworkHelper getInstance() {
        if (networkHelper == null) {
            networkHelper = new NetworkHelper();
        }
        return networkHelper;
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
