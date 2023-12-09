package org.education.beans;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.List;

/**
 * @author nstah
 * @version 0.5
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trades")
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trade_id")
    private int id;

    @Column(name = "trade_lot_name")
    private String name;
    @Column(name = "trade_lot_description")
    private String description;
    @Column(name = "trade_lot_address")
    private String address;
    @Column(name = "trade_lot_price")
    private BigDecimal price;
    @Column(name = "trade_current_max_bid");
    private BigDecimal maxBid;
}
