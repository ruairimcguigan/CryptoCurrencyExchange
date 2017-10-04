
package exchange.currency.crypto.com.cryptocurrencyexchange.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Market {

    @SerializedName("market")
    @Expose
    private String market;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("volume")
    @Expose
    private String volume;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

}
