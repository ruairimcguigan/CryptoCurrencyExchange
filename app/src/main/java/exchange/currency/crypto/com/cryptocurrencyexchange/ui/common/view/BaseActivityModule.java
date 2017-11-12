package exchange.currency.crypto.com.cryptocurrencyexchange.ui.common.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import exchange.currency.crypto.com.cryptocurrencyexchange.inject.scopes.PerActivity;
import exchange.currency.crypto.com.cryptocurrencyexchange.util.Constants;

/**
 * Provides base activity dependencies. This must be included in all activity modules, which must
 * provide a concrete implementation of {@link Activity}.
 */
@Module
public abstract class BaseActivityModule {

    @Binds
    @PerActivity
    /*
     * PerActivity annotation isn't necessary since Activity instance is unique but is here for
     * convention. In general, providing Application, Activity, Fragment, BroadcastReceiver,
     * etc does not require scoped annotations since they are the components being injected and
     * their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */

    abstract Context activityContext(Activity activity);

    @Provides
    @Named(Constants.ACTIVITY_FRAGMENT_MANAGER)
    @PerActivity
    static FragmentManager activityFragmentManager(Activity activity){
        return activity.getFragmentManager();
    }
}
