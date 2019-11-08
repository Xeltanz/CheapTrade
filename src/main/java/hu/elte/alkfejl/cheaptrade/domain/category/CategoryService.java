package hu.elte.alkfejl.cheaptrade.domain.category;

import hu.elte.alkfejl.cheaptrade.domain.base.GenericServiceImpl;

import java.util.Optional;

public class CategoryService extends GenericServiceImpl<Category, CategoryRepository> {
    public CategoryService(CategoryRepository repository) {
        super(repository);
    }

    public Optional<Category> findByName(String name) {
        return repository.findByName(name);
    }


}
