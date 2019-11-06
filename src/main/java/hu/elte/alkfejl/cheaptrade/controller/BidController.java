package hu.elte.alkfejl.cheaptrade.controller;

import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidRepository;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bids")
public class BidController extends GenericController<Bid, BidRepository, BidService> {

    protected BidController(BidService service) {
        super(service);
    }

}
