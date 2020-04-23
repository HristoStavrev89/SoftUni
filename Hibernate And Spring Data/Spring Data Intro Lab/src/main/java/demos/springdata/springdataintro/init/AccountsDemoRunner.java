package demos.springdata.springdataintro.init;


import demos.springdata.springdataintro.domain.AccountService;
import demos.springdata.springdataintro.domain.UserService;
import demos.springdata.springdataintro.model.Account;
import demos.springdata.springdataintro.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Slf4j
public class AccountsDemoRunner implements ApplicationRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User("Ivan Petrov", 35);
        User user2 = new User("Stamat Dimitrov", 49);

        Account account1 = new Account(new BigDecimal(5200), user1);
        user1.getAccounts().add(account1);
        Account account2 = new Account(new BigDecimal(35000), user2);
        user2.getAccounts().add(account2);

        userService.registerUser(user1);
        userService.registerUser(user2);

        log.info("!!! Initial balance for user: {}",
                accountService.getAccount(account1.getId()));
        accountService.withDrawMoney(account1.getId(), new BigDecimal(500));
        log.info("!!! Balance after withdraw: {}",
                accountService.getAccount(account1.getId()));
        accountService.depositMoney(account1.getId(), new BigDecimal(200));
        log.info("!!! Balance after deposit: {}",
                accountService.getAccount(account1.getId()));

        accountService.transferMoney(account1.getId(), account2.getId(), new BigDecimal(2000));
        log.info("!!! Balance FROM after transfer: {}",
                accountService.getAccount(account1.getId()));
        log.info("!!! Balance TO after transfer: {}",
                accountService.getAccount(account1.getId()));
    }
}
