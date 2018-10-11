package ru.nomokonov.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nomokonov.aggregator.domain.Account;
import ru.nomokonov.aggregator.domain.Counter;
import ru.nomokonov.aggregator.domain.User;
import ru.nomokonov.aggregator.repos.AccountRepo;
import ru.nomokonov.aggregator.repos.UserRepo;
import ru.nomokonov.aggregator.service.AccountService;
import ru.nomokonov.aggregator.service.UserSevice;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserSevice userSevice;
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AccountService accountService;

    @GetMapping("{account_id}")
    public String main(@AuthenticationPrincipal User user,
                       @PathVariable(value="account_id") Long  account_id,
                       Model model) {
        Account accountFromDb = accountService.findOneByIdAndUser(account_id, user);
        model.addAttribute("account", accountFromDb);
        return "account";
    }

    @GetMapping("new")
    public String newAccount(@AuthenticationPrincipal User user,
                             Model model) {

        Account accountNew = new Account();
        model.addAttribute("action", "new");   //set attribute for  Title page
        model.addAttribute("account", accountNew);

        return "accountEdit";
    }

    @PostMapping ("add")
    public String SaveAccount(@AuthenticationPrincipal User user,

                              @RequestParam String  account_name,
                              @RequestParam String  account_number,
                              @RequestParam String  account_address,
                              @RequestParam String  lastname,
                              @RequestParam String  firstname,
                              @RequestParam String  patronymic,

                              Model model)     {
        Account account = new Account();
        account.setAccount_name(account_name);
        account.setActive(true);
        account.setAccount_number(account_number);
        account.setAccount_address(account_address);
        account.setFirstname(firstname);
        account.setLastname(lastname);
        account.setPatronymic(patronymic);
        accountService.addAccount(user, account);
        List<Account> accounts = accountService.findAll(user);
        model.addAttribute("accounts", accounts);
        return "accountsList";

    }

    @GetMapping("{account_id}/edit")
    public String EditAccount(@AuthenticationPrincipal User user,
                              @PathVariable(value="account_id") Long  account_id,
                              Model model) {

        model.addAttribute("action", "edit");

        Account accountFromDb = accountService.findOneByIdAndUser(account_id, user);
        model.addAttribute("account", accountFromDb);
        if(accountFromDb == null )
            return "account";

        return "accountEdit";
    }




    @PostMapping ("{account_id}/save")
    public String SaveAccount(@AuthenticationPrincipal User user,
                              @PathVariable(value="account_id") Long  account_id,
                              @RequestParam String  account_name,
                              @RequestParam String  account_number,
                              @RequestParam String  account_address,
                              @RequestParam String  lastname,
                              @RequestParam String  firstname,
                              @RequestParam String  patronymic,

                              Model model)     {

        Account accountFromDb = accountService.findOneByIdAndUser(account_id, user);

        if(accountFromDb == null )
            return "account";
        else {
            accountService.updateAccount(accountFromDb, account_name, account_number, account_address, lastname, firstname, patronymic);
            model.addAttribute("account", accountFromDb);
            return "redirect:/account/"+accountFromDb.getId();
        }
    }

    @GetMapping("{account_id}/counter/new")
    public String NewCountAccount(@AuthenticationPrincipal User user,
                              @PathVariable(value="account_id") Long  account_id,
                              Model model) {

        model.addAttribute("action", "new");

        Account accountFromDb = accountService.findOneByIdAndUser(account_id, user);
        model.addAttribute("account", accountFromDb);
        model.addAttribute("count", new Counter());
        if(accountFromDb == null )
            return "account";

        return "counterEdit";
    }

    @PostMapping ("{account_id}/counter/add")
    public String SaveCounter(@AuthenticationPrincipal User user,
                              @PathVariable(value="account_id") Long  account_id,
                              @RequestParam String  counter_name,
                              @RequestParam String  counter_unit,
                              Model model)     {

        Account accountFromDb = accountService.findOneByIdAndUser(account_id, user);
        if(accountFromDb == null )
            return "account";

        Counter counter = new Counter();
        counter.setName(counter_name);
        counter.setUnit(counter_unit);
        counter.setAccount(accountFromDb);
        counter.setActive(true);

        model.addAttribute("account", accountFromDb);
        return "redirect:account/"+ accountFromDb.getId().toString();
    }
}
