package hu.elte.alkfejl.cheaptrade.domain.base;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

    T save(T T);

    List<T> saveAll(List<T> Ts);

    void delete(T T);

    List<T> findAll();

    Optional<T> findById(Long id);
}
