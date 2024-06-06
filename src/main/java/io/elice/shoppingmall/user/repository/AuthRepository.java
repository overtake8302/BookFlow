package io.elice.shoppingmall.user.repository;

import io.elice.shoppingmall.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    User findByUsername(String username);
}
