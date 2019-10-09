package hu.elte.alkfejl.cheaptrade.domain.item;

import hu.elte.alkfejl.cheaptrade.domain.base.GenericRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ItemRepository extends GenericRepository<Item> {
    Optional<Item> findByName(String name);

    Optional<Item> findByCreatedAt(LocalDate createdAt);

}
