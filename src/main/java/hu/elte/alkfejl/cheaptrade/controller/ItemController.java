package hu.elte.alkfejl.cheaptrade.controller;


import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemRepository;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController extends GenericController<Item, ItemRepository, ItemService> {

    protected ItemController(ItemService service) {
        super(service);
    }

    @GetMapping("/{id}/bids")
    public List<Bid> findByBidsByItemId(@PathVariable Long id) {

        Item byId = service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found id: " + id));
        ;
        return byId.getBids();
    }
}
