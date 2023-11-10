package beans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class TradeRequest implements Serializable {
    private LocalDate fillingDate = LocalDate.now();
    private User user;
    private Lot lot;
    private int period;

    public TradeRequest() {
        user = new User();
        lot = new Lot();
        period = 10;
    }
    public TradeRequest(User user, Lot lot, int period) {
        this.user = user;
        this.lot = lot;
        this.period = period;
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
}
