package hu.elte.alkfejl.cheaptrade.domain.bid;

import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByUser(User user);

    List<Bid> findByItem(Item item);
}
