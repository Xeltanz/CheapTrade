package hu.elte.alkfejl.cheaptrade.domain.item;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.alkfejl.cheaptrade.domain.base.BaseEntity;
import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;
import hu.elte.alkfejl.cheaptrade.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


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

    @Enumerated(value = EnumType.STRING)
    private Category category;

    private boolean isActive;

    @OneToMany(mappedBy = "item", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Bid> bids;
}
