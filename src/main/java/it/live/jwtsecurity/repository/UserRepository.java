package it.live.jwtsecurity.repository;

import it.live.jwtsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Integer> {
    Optional<User> findByEmail(String email);
}
