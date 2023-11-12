package beans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class TradeRequest implements Serializable {
    private int id = 0;
    private LocalDate fillingDate = LocalDate.now();
    private User user;
    private Lot lot;
    private int period;
    private TradeStatus status = TradeStatus.WAITING;

    public TradeRequest() {
        user = new User();
        lot = new Lot();
        period = 10;
    }
    public TradeRequest(int id) {
        this.id = id;
    }
    public TradeRequest(User user, Lot lot, int period) {
        this.user = user;
        this.lot = lot;
        this.period = period;
    }

    public TradeRequest(int id, User user, Lot lot, int period) {
        this(user, lot, period);
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return this.user;
    }

    public Lot getLot() {
        return this.lot;
    }

    public void setPeriod(int p) {
        this.period = p;
    }
    public int getPeriod() {
        return this.period;
    }

    public LocalDate getFillingDate() {
        return this.fillingDate;
    }
    public void setFillingDate(LocalDate date) {
        this.fillingDate = date;
    }

    public TradeStatus getStatus() {
        return this.status;
    }
    public void setStatus(TradeStatus status) {
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ").append(user.getLogin()).append("\n");
        sb.append("Lot name: ").append(lot.getName()).append("\n");
        sb.append("Lot desc: ").append(lot.getDescriptionPath()).append("\n");
        sb.append("Lot image: ").append(lot.getImageName()).append("\n");
        sb.append("Period: ").append(period).append("\n");
        sb.append("Date of request: ").append(fillingDate).append("\n");
        sb.append("Status: ").append(status).append("\n");

        return sb.toString();
    }
}
