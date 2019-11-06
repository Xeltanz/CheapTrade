package hu.elte.alkfejl.cheaptrade.domain.user;

import hu.elte.alkfejl.cheaptrade.domain.base.GenericRepository;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User> {
    Optional<User> findByName(String name);

    Optional<User> findByEmail(String name);

    Optional<User> findByEmailAndPassword(String email, String password);
}
