package hu.elte.alkfejl.cheaptrade.domain.item;

import hu.elte.alkfejl.cheaptrade.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByName(String name);

    List<Item> findByUser(User user);

    List<Item> findByUserId(Long id);

    List<Item> findByCategory(Category category);


    Optional<Item> findByCreatedAt(LocalDate createdAt);


}
