package hu.elte.alkfejl.cheaptrade.domain.user;

import hu.elte.alkfejl.cheaptrade.domain.GenericService;

import java.util.Optional;

public interface UserService extends GenericService<User> {
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
