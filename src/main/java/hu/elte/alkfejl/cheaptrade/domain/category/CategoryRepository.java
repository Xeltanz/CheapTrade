package hu.elte.alkfejl.cheaptrade.domain.category;

import hu.elte.alkfejl.cheaptrade.domain.base.GenericRepository;

import java.util.Optional;

public interface CategoryRepository extends GenericRepository<Category> {
    Optional<Category> findByName(String name);
}
