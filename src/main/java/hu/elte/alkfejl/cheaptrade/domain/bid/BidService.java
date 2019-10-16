package hu.elte.alkfejl.cheaptrade.domain.bid;

import hu.elte.alkfejl.cheaptrade.domain.base.GenericServiceImpl;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.user.User;

import java.util.List;

public class BidService extends GenericServiceImpl<Bid, BidRepository> {


    public BidService(BidRepository repository) {
        super(repository);
    }

    public List<Bid> findByUser(User user) {
        return repository.findByUser(user);
    }

    public List<Bid> findByItem(Item item) {
        return repository.findByItem(item);
    }

}
