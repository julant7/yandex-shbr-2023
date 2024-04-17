package ru.yandex.test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.yandex.test_task.entity.Courier;
import ru.yandex.test_task.entity.Order;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, BigInteger> {

    Optional<Order> findById(String id);

    @Query(value = "SELECT * FROM orders LIMIT ?2 OFFSET ?1", nativeQuery = true)
    Optional<List<Order>> findOrdersWithRestrictions(BigInteger offset, BigInteger limit);

}
