package beans;

import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Trade implements Serializable {
    private TradeRequest requestInformation;
    private  LocalDateTime startDateTime = LocalDateTime.now();
    private TradeStatus status;
    private BigDecimal maxBid;
    private String maxBidUserLogin;

    public Trade() {
        requestInformation = null;
        status = TradeStatus.WAITING;
    }

    public Trade(TradeRequest request, TradeStatus status, LocalDateTime date) {
        this.requestInformation = request;
        this.status = status;
        this.startDateTime = date;
        this.maxBid = request.getLot().getPrice();
    }

    public TradeRequest getRequestInformation() {
        return this.requestInformation;
    }
    public void setRequestInformation(TradeRequest req) {
        this.requestInformation = req;
    }
    
    public void setStatus(TradeStatus status) {
        this.status = status;
    }
    public TradeStatus getStatus() {
        return this.status;
    }

    public void setStartDateTime(LocalDateTime date) {
        this.startDateTime = date;
    }
    public LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public void setBid(String login, BigDecimal bid) {
        this.maxBid = bid;
        this.maxBidUserLogin = login;
    }

    public void setMaxBid(double bid) {
        this.maxBid = new BigDecimal(bid);
    }
    public BigDecimal getMaxBid() {return this.maxBid;}
    public void setMaxBidUserLogin(String login) {
        this.maxBidUserLogin = login;
    }
    public String getMaxBidUserLogin() {return this.maxBidUserLogin;}

}
