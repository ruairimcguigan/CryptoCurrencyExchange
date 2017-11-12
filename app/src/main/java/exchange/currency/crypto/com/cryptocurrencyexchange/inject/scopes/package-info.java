
/**
 * Contains the different custom scopes used.
 * <p>
 * Note that the standard {@link javax.inject.Singleton} scope is used as the application scope
 * (there is no PerApplication scope annotation). This is done in order to support singleton
 * scoped classes from other libraries (which do not have access to this project's custom scopes).
 */
package exchange.currency.crypto.com.cryptocurrencyexchange.inject.scopes;