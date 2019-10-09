package hu.elte.alkfejl.cheaptrade.domain.user;

import hu.elte.alkfejl.cheaptrade.domain.base.GenericServiceImpl;

import java.util.Optional;

public class UserService extends GenericServiceImpl<User, UserRepository> {

    public UserService(UserRepository repository) {
        super(repository);
    }

    public Optional<User> findByName(String userName) {
        return repository.findByName(userName);
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
