package ru.nomokonov.aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.nomokonov.aggregator.domain.Account;
import ru.nomokonov.aggregator.domain.User;
import ru.nomokonov.aggregator.repos.AccountRepo;
import ru.nomokonov.aggregator.repos.UserRepo;

import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private UserRepo userRepo;

    public void updateAccount(
            Account account,
            String account_name,
            String account_number,
            String account_address,
            String lastname,
            String firstname,
            String patronymic) {

        if (!StringUtils.isEmpty(account_name)) {
            account.setAccount_name(account_name);
        }
        if (!StringUtils.isEmpty(account_number)) {
            account.setAccount_number(account_number);
        }
        if (!StringUtils.isEmpty(account_address)) {
            account.setAccount_address(account_address);
        }
        if (!StringUtils.isEmpty(lastname)) {
            account.setLastname(lastname);
        }
        if (!StringUtils.isEmpty(firstname)) {
            account.setFirstname(firstname);
        }
        if (!StringUtils.isEmpty(patronymic)) {
            account.setPatronymic(patronymic);
        }
        accountRepo.save(account);
    }

   public Account findOneByIdAndUser(Long account_id, User user){
        return accountRepo.findOneByIdAndUser(account_id,user);
   }

    public List<Account> findAll(User user) {
        return accountRepo.findAllByUser(user);

    }

    public boolean addAccount(User  user,Account account){
        User userCurr = userRepo.findOneById(user.getProfile_id());
        account.setUser(userCurr);
        account.setRegistration_date(new Date());
        accountRepo.save(account);
        return true;

    }
}
