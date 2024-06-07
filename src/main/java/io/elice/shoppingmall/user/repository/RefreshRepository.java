package io.elice.shoppingmall.user.repository;

import io.elice.shoppingmall.user.model.Refresh;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshRepository extends JpaRepository<Refresh, Long> {
    boolean existsByRefresh(String refresh);

    @Transactional
    void deleteByRefresh(String refresh);
}
