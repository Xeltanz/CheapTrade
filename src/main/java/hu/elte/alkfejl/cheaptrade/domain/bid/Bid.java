package hu.elte.alkfejl.cheaptrade.domain.bid;

import hu.elte.alkfejl.cheaptrade.domain.base.BaseEntity;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.user.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(callSuper = true)

@Entity
public class Bid extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Item item;

    private BigDecimal amount;

    private boolean isBuyout;

}
