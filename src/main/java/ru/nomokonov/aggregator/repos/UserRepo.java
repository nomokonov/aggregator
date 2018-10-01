package ru.nomokonov.aggregator.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.nomokonov.aggregator.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByActivationCode(String code);
    User findOneById(Long id);
}
