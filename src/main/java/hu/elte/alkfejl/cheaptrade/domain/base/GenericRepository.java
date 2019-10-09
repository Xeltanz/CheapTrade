package hu.elte.alkfejl.cheaptrade.domain.base;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
