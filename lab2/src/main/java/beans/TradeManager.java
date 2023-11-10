package beans;

import java.util.LinkedList;
import java.util.List;

public class TradeManager {
    private List<TradeRequest> requests = new LinkedList<>();
    public List<TradeRequest> getRequests() {
        return this.requests;
    }
    public void setRequests(LinkedList<TradeRequest> list) {
        requests = list;
    }

    public TradeManager() {}
    public TradeManager(List<TradeRequest> list) {
        this.requests = list;
    }
}
