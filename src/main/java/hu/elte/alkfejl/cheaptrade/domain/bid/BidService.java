package hu.elte.alkfejl.cheaptrade.domain.bid;

import hu.elte.alkfejl.cheaptrade.domain.GenericService;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.user.User;

import java.util.List;

public interface BidService extends GenericService<Bid> {

    /**
     * licit keresése user alapján
     *
     * @param user keresett név
     * @return a keresendő névre illő találatok
     */
    List<Bid> findByUser(User user);

    /**
     * licit keresése item alapján
     *
     * @param item keresett név
     * @return a keresendő névre illő találatok
     */
    List<Bid> findByItem(Item item);
}
