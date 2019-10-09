package hu.elte.alkfejl.cheaptrade.domain.base;

import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImpl<T extends BaseEntity, R extends GenericRepository<T>> implements GenericService<T> {

    protected final R repository;

    public GenericServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public List<T> saveAll(List<T> ts) {
        return repository.saveAll(ts);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }
}
