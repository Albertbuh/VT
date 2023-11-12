package beans;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class TradeManager implements Serializable {
    private List<TradeRequest> requests = new LinkedList<>();
    public List<TradeRequest> getRequests() {
        return this.requests;
    }
    public void setRequests(LinkedList<TradeRequest> list) {
        requests = list;
    }


    private List<Trade> trades = new LinkedList<>();
    public List<Trade> getTrades() {
        return this.trades;
    }
    public TradeManager setTrades(List<Trade> list) {

        trades = list;
        return this;
    }
    public TradeManager() {}
    public TradeManager(List<TradeRequest> list) {
        this.requests = list;
    }
}
