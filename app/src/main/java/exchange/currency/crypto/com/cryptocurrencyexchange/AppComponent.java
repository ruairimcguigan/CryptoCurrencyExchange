package exchange.currency.crypto.com.cryptocurrencyexchange;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Injects application dependencies.
 *
 * The AppComponent is annotated with @Component and @Singleton to indicate that its modules
 * (AppModule) are to provide @Singleton scoped or unscoped dependencies.
 */

@Singleton
@Component(modules = AppModule.class)
interface AppComponent extends AndroidInjector<CryptoApplication>{

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<CryptoApplication> {

    }
}
