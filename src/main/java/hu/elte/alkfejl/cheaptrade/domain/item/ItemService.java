package hu.elte.alkfejl.cheaptrade.domain.item;

import hu.elte.alkfejl.cheaptrade.domain.GenericService;

import java.util.Optional;

public interface ItemService extends GenericService<Item> {
    /**
     * felhasználó keresése név alapján
     *
     * @param itemName keresett név
     * @return a keresendő névre illő találatok
     */
    Optional<Item> findByName(String itemName);
}
