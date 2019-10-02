package hu.elte.alkfejl.cheaptrade.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName = "sequences", allocationSize = 40)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


//    @Column(nullable = false)
//    @Enumerated(value = EnumType.STRING)
//    private Authority authority;

//    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    private List<Product> products;
//
//    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    private List<Bid> bids;
}
