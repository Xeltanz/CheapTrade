package hu.elte.alkfejl.cheaptrade.service;

import hu.elte.alkfejl.cheaptrade.domain.item.Item;
import org.springframework.scheduling.annotation.Scheduled;

public interface ScheduleService {
    /**
     * Kiválasztja a lejárt aukciókat, meghatározott időközönként ütemezve (napi 1?)
     */
    @Scheduled()
    void scheduleServiceMethod();

    /**
     * A lejárt aukciót frissíti, inaktívvá teszi
     * és a notificatonServicen keresztül emaileket küld
     *
     * @param item a lejárt aukció
     */
    void resolveAuction(Item item);
}
