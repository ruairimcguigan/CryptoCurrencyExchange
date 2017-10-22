package exchange.currency.crypto.com.cryptocurrencyexchange.model.api;

import exchange.currency.crypto.com.cryptocurrencyexchange.model.json.CryptoResult;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface CryptoCurrencyService {

    /**
     * Get markets for specific currency
     * @param currency
     * @return
     */
    @GET("{currency}")
    Single<CryptoResult> cryptoMarketQuery(@Path("currency") String currency);
}
