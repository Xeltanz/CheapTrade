package hu.elte.alkfejl.cheaptrade.controller;

import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.user.User;
import hu.elte.alkfejl.cheaptrade.domain.user.UserRepository;
import hu.elte.alkfejl.cheaptrade.domain.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController extends GenericController<User, UserRepository, UserService> {

    protected UserController(UserService service) {
        super(service);
    }

    @GetMapping("/{id}/bids")
    public List<Bid> findByBidsByUserId(@PathVariable Long id) {

        User byId = service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found id: " + id));
        ;
        return byId.getBids();
    }

    @GetMapping("/{id}/items")
    public List<Item> findByItemsByUserId(@PathVariable Long id) {

        User byId = service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found id: " + id));
        ;
        return byId.getItems();
    }
}
