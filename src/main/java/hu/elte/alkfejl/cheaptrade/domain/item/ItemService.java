package hu.elte.alkfejl.cheaptrade.domain.item;

import hu.elte.alkfejl.cheaptrade.domain.base.GenericServiceImpl;
import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ItemService extends GenericServiceImpl<Item, ItemRepository> {

    public ItemService(ItemRepository repository) {
        super(repository);
    }

    public Optional<Item> findByName(String itemName) {
        return repository.findByName(itemName);
    }

    public Optional<Bid> findTopBidWithBids(Item item, List<Bid> bids) {
        return bids.stream().filter(bid -> bid.getItem().equals(item)).max(Comparator.comparing(Bid::getAmount));
    }

    public boolean isExpired(Item item) {
        LocalDateTime expireDate = item.getExpireDate();
        return expireDate != null && expireDate.isBefore(LocalDateTime.now());
    }

    public void setItemInactive(Item item) {
        item.setActive(false);
        repository.save(item);
    }
}
