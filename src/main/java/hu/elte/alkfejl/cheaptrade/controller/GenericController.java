package hu.elte.alkfejl.cheaptrade.controller;

import hu.elte.alkfejl.cheaptrade.domain.base.BaseEntity;
import hu.elte.alkfejl.cheaptrade.domain.base.GenericRepository;
import hu.elte.alkfejl.cheaptrade.domain.base.GenericServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericController<T extends BaseEntity, R extends GenericRepository<T>, S extends GenericServiceImpl<T, R>> {

    protected final S service;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<T> post(@RequestBody T t) {
        return ResponseEntity.ok(service.save(t));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T entity) {
        Optional<T> oT = service.findById(id);
        if (oT.isPresent()) {
            entity.setId(id);
            return ResponseEntity.ok(service.save(entity));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

}
