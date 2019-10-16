package hu.elte.alkfejl.cheaptrade.domain.bid;

import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.user.User;

import java.util.List;
import java.util.Optional;

public class BidServiceImpl implements BidService {
    private final BidRepository bidRepository;

    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public List<Bid> saveAll(List<Bid> bids) {
        return bidRepository.saveAll(bids);
    }

    @Override
    public void delete(Bid bid) {
        bidRepository.delete(bid);
    }

    @Override
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

    @Override
    public Optional<Bid> findById(Long id) {
        return bidRepository.findById(id);
    }

    @Override
    public List<Bid> findByUser(User user) {
        return bidRepository.findByUser(user);
    }

    @Override
    public List<Bid> findByItem(Item item) {
        return bidRepository.findByItem(item);
    }

}
