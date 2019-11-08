package hu.elte.alkfejl.cheaptrade.domain.category;


import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.alkfejl.cheaptrade.domain.base.BaseEntity;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(callSuper = true)

@Entity
public class Category extends BaseEntity {

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Item> items;

    private String name;


}
