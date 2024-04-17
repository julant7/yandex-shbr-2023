package ru.yandex.test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.yandex.test_task.entity.District;

import java.math.BigInteger;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface DistrictRepository extends JpaRepository<District, BigInteger> {
    @Override
    Optional<District> findById(BigInteger id);
}
