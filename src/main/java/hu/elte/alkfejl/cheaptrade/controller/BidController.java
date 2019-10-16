package hu.elte.alkfejl.cheaptrade.controller;

import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidRepository;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidService;
import hu.elte.alkfejl.cheaptrade.domain.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bids")
public class BidController extends GenericController<Bid, BidRepository, BidService> {


    protected BidController(BidService service) {
        super(service);
    }

    @GetMapping("/{user}")
    public List<Bid> findByUser(@PathVariable User user) {
        return service.findByUser(user);
    }
}
