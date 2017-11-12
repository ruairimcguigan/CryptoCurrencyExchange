package exchange.currency.crypto.com.cryptocurrencyexchange.ui.common.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import exchange.currency.crypto.com.cryptocurrencyexchange.R;
import exchange.currency.crypto.com.cryptocurrencyexchange.navigation.Navigator;

import static android.support.v4.app.FragmentManager.OnBackStackChangedListener;

/**
 * Abstract Activity for all Activities to extend.
 *
 * The BaseActivity contains dagger.android code that is very similar to the code in App.
 * The only difference is that the BaseActivity implements HasFragmentInjector, indicating
 * that fragments are to participate in dagger.android injection.
 *
 * The BaseActivity could extend DaggerActivity instead of implementing HasFragmentInjector.
 * However, inheritance should be avoided so that the option to inherit from something else
 * later on is open.
 *
 * The abstract base container responsible for showing and destroying {@link Fragment} and handling
 * back and up navigation using the Fragment back stack. This is based on the
 * Fragment Oriented Architecture explained here
 * http://vinsol.com/blog/2014/09/15/advocating-fragment-oriented-applications-in-android/
 */

public abstract class BaseActivity extends AppCompatActivity
        implements HasFragmentInjector, OnBackStackChangedListener {

    @Inject
    protected Navigator navigator;

    @Inject
    DispatchingAndroidInjector<android.app.Fragment> fragmentInjector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    public final <T extends Fragment> void showFragment(Class<T> fragmentClass, Bundle bundle, boolean addToBackStack) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentClass.getSimpleName());

        if (fragment == null){
            try{
                fragment = fragmentClass.newInstance();
                fragment.setArguments(bundle);
            }catch (InstantiationException e){
                throw new RuntimeException(getApplicationContext().getString(R.string.fragment_not_created_message, e));
            } catch (IllegalAccessException e){
                throw new RuntimeException(getApplicationContext().getString(R.string.fragment_not_created_message, e));
            }
        }

        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.replace(R.id.fragment_placeholder, fragment, fragmentClass.getSimpleName());

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }

    public final <T extends Fragment> void showFragment(Class<T> fragmentClass) {
        showFragment(fragmentClass, null, false);
    }

    public void popFragmentBackStack() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
    }

    private void shouldShowActionBarUpButton() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            popFragmentBackStack();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackStackChanged() {
        shouldShowActionBarUpButton();
    }
}
