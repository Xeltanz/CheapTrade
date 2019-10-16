package hu.elte.alkfejl.cheaptrade.controller;


import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemRepository;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("items")
public class ItemController extends GenericController<Item, ItemRepository, ItemService> {

    protected ItemController(ItemService service) {
        super(service);
    }
}
