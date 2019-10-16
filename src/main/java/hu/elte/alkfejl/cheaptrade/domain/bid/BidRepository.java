package hu.elte.alkfejl.cheaptrade.domain.bid;

import hu.elte.alkfejl.cheaptrade.domain.base.GenericRepository;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.user.User;

import java.util.List;

public interface BidRepository extends GenericRepository<Bid> {
    List<Bid> findByUser(User user);

    List<Bid> findByItem(Item item);
}
