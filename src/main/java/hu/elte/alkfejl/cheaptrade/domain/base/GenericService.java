package hu.elte.alkfejl.cheaptrade.domain.base;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    /**
     * @param T
     * @return
     */
    T save(T T);

    /**
     * @param Ts
     * @return
     */
    List<T> saveAll(List<T> Ts);

    /**
     * @param T
     */
    void delete(T T);

    /**
     * @return
     */
    List<T> findAll();

    /**
     * @param id
     * @return
     */
    Optional<T> findById(Long id);
}
