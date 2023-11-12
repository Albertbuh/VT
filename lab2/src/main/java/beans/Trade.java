package beans;

import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Trade implements Serializable {
    private TradeRequest requestInformation;
    private  LocalDateTime startDate = LocalDateTime.now();
    private User admin;
    private TradeStatus status;

    public Trade() {
        requestInformation = null;
        admin = new User("admin","admin","ADMIN");
        status = TradeStatus.WAITING;
    }

    public Trade(TradeRequest request, User admin, TradeStatus status, LocalDateTime date) {
        this.requestInformation = request;
        this.admin = admin;
        this.status = status;
        this.startDate = date;
    }

    public TradeRequest getRequestInformation() {
        return this.requestInformation;
    }
    public void setRequestInformation(TradeRequest req) {
        this.requestInformation = req;
    }

    public User getAdmin() {
        return this.admin;
    }
    public void setAdmin(User admin) {
        if(Objects.equals(admin.getRole(), "ADMIN"))
            this.admin = admin;
    }

    public void setStatus(TradeStatus status) {
        this.status = status;
    }
    public TradeStatus getStatus() {
        return this.status;
    }

    public void setStartDate(LocalDateTime date) {
        this.startDate = date;
    }
    public LocalDateTime getStartDate() {
        return this.startDate;
    }

}
