package hu.elte.alkfejl.cheaptrade.security;

import hu.elte.alkfejl.cheaptrade.domain.user.User;
import hu.elte.alkfejl.cheaptrade.domain.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public MyUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByName(username).orElseThrow(() -> new IllegalArgumentException("User: " + username + " not found."));

        return new MyUserDetails(user);
    }
}
