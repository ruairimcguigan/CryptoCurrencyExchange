package exchange.currency.crypto.com.cryptocurrencyexchange.model.json;

import java.util.ArrayList;
import java.util.List;

public class CryptoResults {

    private List<MarketUpdate> updates = new ArrayList<>();

    public List<MarketUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(List<MarketUpdate> updates) {
        this.updates = updates;
    }

}
