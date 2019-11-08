package hu.elte.alkfejl.cheaptrade.service;


import hu.elte.alkfejl.cheaptrade.domain.bid.Bid;
import hu.elte.alkfejl.cheaptrade.domain.bid.BidService;
import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import hu.elte.alkfejl.cheaptrade.domain.item.ItemService;
import hu.elte.alkfejl.cheaptrade.utils.CheapTradeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Clock;
import java.time.LocalTime;
import java.util.Optional;

@Slf4j
public class ScheduleServiceImpl implements ScheduleService {
    private final ItemService itemService;
    private final NotificationService notificationService;
    private final BidService bidService;
    private Clock clock;

    public ScheduleServiceImpl(Clock clock, ItemService itemService, NotificationService notificationService, BidService bidService) {
        this.clock = clock;
        this.itemService = itemService;
        this.notificationService = notificationService;
        this.bidService = bidService;
    }

    @Override
    @Scheduled(cron = "0 * * * * ?")
    public void scheduleServiceMethod() {
        itemService.findAll().stream()
                .filter(Item::isActive)
                .filter(itemService::isExpired)
                .forEach(this::resolveAuction);
        log.info(LocalTime.now(clock).toString());
    }

    @Override
    public void resolveAuction(Item item) {
        itemService.setItemInactive(item);
        log.info("lejárt {} aukció", item.getName());
        Optional<Bid> topBid = itemService.findTopBidWithBids(item, bidService.findAll());
        if (topBid.isPresent()) { //todo sending email temporarily disabled
            //aukció győztesének
            notificationService.sendEmail(topBid.get().getUser().getEmail(), "CheatTrade - Nyertes Aukció Lezárult", "Gratulálunk, megnyertél egy aukciót! \n Tárgy:" + item.getName() + "\n" + CheapTradeUtils.formatBigDecimal(topBid.get().getAmount()) + " HUF" + "\nTulajdonos címe: " + item.getUser().getEmail());
            //aukció tulajdonosának
            notificationService.sendEmail(item.getUser().getEmail(), "CheatTrade - Aukciód Lezárult", topBid.get().getUser().getName() + " nyerte meg a következö aukciódat: " + item.getName() + ".\n" + CheapTradeUtils.formatBigDecimal(topBid.get().getAmount()) + " HUF" + "\ncíme: " + topBid.get().getUser().getEmail());
        } else {
            //aukció tulajdonosának (nincs licit)
            notificationService.sendEmail(item.getUser().getEmail(), "ebéj - Aukciód Lezárult", "Nem érkezett licit az aukciódra: " + item.getName());
        }
    }
}
