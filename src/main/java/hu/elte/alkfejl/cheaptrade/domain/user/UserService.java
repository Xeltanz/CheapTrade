package hu.elte.alkfejl.cheaptrade.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    /**
     * Új felhasználó hozzáadása
     *
     * @param user új felhasználó
     * @return regisztrált felhasználó
     */
    User save(User user);

    /**
     * Felhasználó törlése
     *
     * @param user törölni kívánt felhasználó
     */
    void delete(User user);

    /**
     * Az összes felhasználó lekérése
     *
     * @return összes felhasználó listában
     */
    List<User> findAll();

    /**
     * Felhasználó keresése azonosító alapján
     *
     * @param id felhasználó azonosító
     * @return keresett felhasználó
     */
    Optional<User> findById(Long id);

    /**
     * felhasználó keresése név alapján
     *
     * @param userName keresett név
     * @return a keresendő névre illő találatok
     */
    Optional<User> findByName(String userName);

    /**
     * felhasználó keresése email cím alapján
     *
     * @param email keresett emailcím
     * @return a keresendő névre illő találat
     */
    Optional<User> findByEmail(String email);
}
