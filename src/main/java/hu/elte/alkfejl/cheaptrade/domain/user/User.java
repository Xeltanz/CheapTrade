package hu.elte.alkfejl.cheaptrade.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.alkfejl.cheaptrade.domain.base.BaseEntity;
import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(callSuper = true)

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "unique_statement",
        columnNames = {"name", "email"}))
public class User extends BaseEntity {

    private String name;

    private String email;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Item> items;

    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Bid> bids;

    public enum Role {
        GUEST, USER, ADMIN
    }
}
