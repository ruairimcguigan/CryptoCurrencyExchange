package exchange.currency.crypto.com.cryptocurrencyexchange.model.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import exchange.currency.crypto.com.cryptocurrencyexchange.util.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CryptoCurrencyServiceFactory {

    /**
     * Interceptor used for logging
     */
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    /**
     * OkHttpClient to be used
     */
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


    Retrofit retrofit = new Retrofit.Builder()
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build();

    /**
     * Using this provides for creating functioning object that takes interface
     * @return
     */
    public CryptoCurrencyService create(){
        return retrofit.create(CryptoCurrencyService.class);
    }


}
