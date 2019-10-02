package hu.elte.alkfejl.cheaptrade.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName = "sequences", allocationSize = 40)
    @Column(nullable = false)
    protected Long id;

    @Column(nullable = false)
    protected LocalDate createdAt;
}
