package hu.elte.alkfejl.cheaptrade.domain.item;

import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository ItemRepository) {
        this.itemRepository = ItemRepository;
    }

    @Override
    public Item save(Item Item) {
        return itemRepository.save(Item);
    }

    @Override
    public List<Item> saveAll(List<Item> Items) {
        return itemRepository.saveAll(Items);
    }

    @Override
    public void delete(Item Item) {
        itemRepository.delete(Item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findByName(String itemName) {
        return itemRepository.findByName(itemName);
    }
}
