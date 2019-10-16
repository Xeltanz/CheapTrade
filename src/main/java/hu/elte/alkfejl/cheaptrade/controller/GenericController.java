package hu.elte.alkfejl.cheaptrade.controller;

import hu.elte.alkfejl.cheaptrade.domain.base.BaseEntity;
import hu.elte.alkfejl.cheaptrade.domain.base.GenericRepository;
import hu.elte.alkfejl.cheaptrade.domain.base.GenericServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public abstract class GenericController<T extends BaseEntity, R extends GenericRepository<T>, S extends GenericServiceImpl<T, R>> {

    final S service;

    protected GenericController(S service) {
        this.service = service;
    }

    @GetMapping("")
    public List<T> findAllItem() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<T> findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
