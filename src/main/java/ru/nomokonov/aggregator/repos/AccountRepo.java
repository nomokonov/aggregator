package ru.nomokonov.aggregator.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.nomokonov.aggregator.domain.Account;
import ru.nomokonov.aggregator.domain.User;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Account findOneByIdAndUser(Long id,User user);

    List<Account> findAllByUser(User user);

}
