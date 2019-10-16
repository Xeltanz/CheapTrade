package hu.elte.alkfejl.cheaptrade.domain.item;


import hu.elte.alkfejl.cheaptrade.domain.base.BaseEntity;
import hu.elte.alkfejl.cheaptrade.domain.user.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(callSuper = true)

@Entity
public class Item extends BaseEntity {

    @ManyToOne
    private User user;

    private String name;

    private String description;

    private BigDecimal startingPrice;

    private BigDecimal buyOutPrice;

    private LocalDateTime expireDate;

    private String picturePath;

    private Category category;

    private boolean isActive;
}
