package exchange.currency.crypto.com.cryptocurrencyexchange;

import dagger.Module;
import dagger.android.AndroidInjectionModule;

/**
 * The AppModule is an abstract class that is annotated with the @Module annotation and
 * includes the AndroidInjectionModule, which contains bindings to ensure the usability
 * of dagger.android framework classes.
 */
@Module(includes = AndroidInjectionModule.class)
abstract class AppModule {
}
