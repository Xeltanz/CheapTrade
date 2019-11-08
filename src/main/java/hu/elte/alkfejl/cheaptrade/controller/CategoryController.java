package hu.elte.alkfejl.cheaptrade.controller;

import hu.elte.alkfejl.cheaptrade.domain.category.Category;
import hu.elte.alkfejl.cheaptrade.domain.category.CategoryRepository;
import hu.elte.alkfejl.cheaptrade.domain.category.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController extends GenericController<Category, CategoryRepository, CategoryService> {
    protected CategoryController(CategoryService service) {
        super(service);
    }
}
