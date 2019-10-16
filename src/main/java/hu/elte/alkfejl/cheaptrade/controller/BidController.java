package hu.elte.alkfejl.cheaptrade.controller;

import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidService;
import hu.elte.alkfejl.cheaptrade.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bids")
public class BidController {
    @Autowired
    private BidService bidService;

    @GetMapping("")
    public List<Bid> findAllBid() {
        return bidService.findAll();
    }

    @GetMapping("/{user}")
    public List<Bid> findByUser(@PathVariable User user) {
        return bidService.findByUser(user);
    }
}
