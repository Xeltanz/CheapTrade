package hu.elte.alkfejl.cheaptrade.domain.base;

import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
    List<Item> findByCreatedAt(LocalDate createdAt);
}
