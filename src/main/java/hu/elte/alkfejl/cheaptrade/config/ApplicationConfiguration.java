package hu.elte.alkfejl.cheaptrade.config;

import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidRepository;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidService;
import hu.elte.alkfejl.cheaptrade.domain.category.Category;
import hu.elte.alkfejl.cheaptrade.domain.category.CategoryRepository;
import hu.elte.alkfejl.cheaptrade.domain.category.CategoryService;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemRepository;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemService;
import hu.elte.alkfejl.cheaptrade.domain.user.User;
import hu.elte.alkfejl.cheaptrade.domain.user.UserRepository;
import hu.elte.alkfejl.cheaptrade.domain.user.UserService;
import hu.elte.alkfejl.cheaptrade.security.MyUserDetailsService;
import hu.elte.alkfejl.cheaptrade.service.NotificationService;
import hu.elte.alkfejl.cheaptrade.service.NotificationServiceImpl;
import hu.elte.alkfejl.cheaptrade.service.ScheduleService;
import hu.elte.alkfejl.cheaptrade.service.ScheduleServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@EnableScheduling
public class ApplicationConfiguration {


    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public CategoryService categoryService(CategoryRepository categoryRepository) {
        return new CategoryService(categoryRepository);
    }

    @Bean
    public ItemService itemService(ItemRepository itemRepository) {
        return new ItemService(itemRepository);
    }

    @Bean
    public BidService bitService(BidRepository bidRepository) {
        return new BidService(bidRepository);
    }

    @Bean
    public ScheduleService scheduleService(Clock clock, ItemService itemService, NotificationService notificationService, BidService bidService) {
        return new ScheduleServiceImpl(clock, itemService, notificationService, bidService);
    }

    @Bean
    public NotificationService notificationService(JavaMailSender javaMailSender) {
        return new NotificationServiceImpl(javaMailSender);
    }

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository repository) {
        return new MyUserDetailsService(repository);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserService userService, ItemService itemService, BidService bidService, CategoryService categoryService) {
        return args -> {
            User kristof = User.builder().name("mata").email("mordecaivv@gmail.com").password(passwordEncoder().encode("pass")).role(User.Role.USER).build();
            User soma = User.builder().name("soma").email("soma@freemail.hu").password(passwordEncoder().encode("1234")).role(User.Role.USER).build();

            Category antiques = Category.builder().name("antiques").build();
            Category art = Category.builder().name("art").build();

            Item pebble = Item.builder().name("pebble").user(kristof).startingPrice(new BigDecimal(10)).buyOutPrice(new BigDecimal(500)).categories(Arrays.asList(antiques, art)).expireDate(LocalDateTime.now(clock()).plusMinutes(1)).isActive(true).build();
            Item bojler = Item.builder().name("bojler").user(soma).startingPrice(new BigDecimal(20000)).buyOutPrice(new BigDecimal(50000)).categories(Arrays.asList(art)).build();

            Bid licit1 = Bid.builder().user(soma).item(pebble).amount(new BigDecimal(2000)).build();
            Bid licit2 = Bid.builder().user(kristof).item(pebble).amount(new BigDecimal(100)).build();
            Bid licit3 = Bid.builder().user(soma).item(bojler).amount(new BigDecimal(21000)).build();

            userService.saveAll(Arrays.asList(kristof, soma));
            categoryService.saveAll(Arrays.asList(antiques, art));
            itemService.saveAll(Arrays.asList(pebble, bojler));
            bidService.saveAll(Arrays.asList(licit1, licit2, licit3));
        };
    }
}
