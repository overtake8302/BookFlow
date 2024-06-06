package io.elice.shoppingmall.user.repository;

import io.elice.shoppingmall.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<User, Long> {
    List<User> findByUsernameAll();
}
