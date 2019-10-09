package hu.elte.alkfejl.cheaptrade.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);

    Optional<Item> findByCreatedAt(LocalDate createdAt);

}
