package hu.elte.alkfejl.cheaptrade.config;

import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidRepository;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidService;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidServiceImpl;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemRepository;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemService;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemServiceImpl;
import hu.elte.alkfejl.cheaptrade.domain.user.User;
import hu.elte.alkfejl.cheaptrade.domain.user.UserRepository;
import hu.elte.alkfejl.cheaptrade.domain.user.UserService;
import hu.elte.alkfejl.cheaptrade.domain.user.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public ItemService itemService(ItemRepository itemRepository) {
        return new ItemServiceImpl(itemRepository);
    }

    @Bean
    public BidService bitService(BidRepository bidRepository) {
        return new BidServiceImpl(bidRepository);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserService userService, ItemService itemService, BidService bidService) {
        return args -> {
            User kristof = User.builder().name("Kristóf").email("email@email.hu").password("pass").build();
            User soma = User.builder().name("Soma").email("soma@freemail.hu").password("1234").build();
            Item pebble = Item.builder().name("pebble").user(kristof).buyOutPrice(new BigDecimal(1000)).build();
            Bid licit1 = Bid.builder().user(soma).item(pebble).amount(new BigDecimal(2000)).build();
            Bid licit2 = Bid.builder().user(kristof).item(pebble).amount(new BigDecimal(2500)).build();
            Bid licit3 = Bid.builder().user(soma).item(pebble).amount(new BigDecimal(3000)).build();
            userService.saveAll(Arrays.asList(kristof, soma));
            itemService.save(pebble);
            bidService.saveAll(Arrays.asList(licit1, licit2, licit3));
        };
    }
}
