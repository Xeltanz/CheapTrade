package hu.elte.alkfejl.cheaptrade.domain.item;

import hu.elte.alkfejl.cheaptrade.domain.base.GenericRepository;
import hu.elte.alkfejl.cheaptrade.domain.user.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends GenericRepository<Item> {
    Optional<Item> findByName(String name);

    List<Item> findByUser(User user);

    List<Item> findByUserId(Long id);

    List<Item> findByCategory(Category category);

    Optional<Item> findByCreatedAt(LocalDate createdAt);

}
