package hu.elte.alkfejl.cheaptrade.domain.item;

import hu.elte.alkfejl.cheaptrade.domain.base.GenericServiceImpl;

import java.util.Optional;

public class ItemService extends GenericServiceImpl<Item, ItemRepository> {

    public ItemService(ItemRepository repository) {
        super(repository);
    }

    public Optional<Item> findByName(String itemName) {
        return repository.findByName(itemName);
    }
}
