package hu.elte.alkfejl.cheaptrade.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    Optional<User> findByCreatedAt(String name);

    Optional<User> findByEmail(String name);

    Optional<User> findByEmailAndPassword(String email, String password);
}
