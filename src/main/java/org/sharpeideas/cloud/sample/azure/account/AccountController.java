package org.sharpeideas.cloud.sample.azure.account;

import org.sharpeideas.cloud.sample.azure.account.dataaccess.Account;
import org.sharpeideas.cloud.sample.azure.account.dataaccess.AccountDAO;
import org.sharpeideas.cloud.sample.azure.account.dataaccess.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by phil on 09/04/2016.
 */
@RestController
@Component
public class AccountController {
    private final AccountDAO accountRepository;
    protected Logger logger = Logger.getLogger(AccountController.class
            .getName());

    /**
     * Create an instance plugging in the respository of Accounts.
     *
     * @param accountRepository
     *            An account repository implementation.
     */
    @Autowired
    public AccountController(AccountDAO accountRepository) {
        this.accountRepository = accountRepository;

    }

    /**
     * Fetch an account with the specified account number.
     *
     * @param accountNumber
     *            A numeric, 9 digit account number.
     * @return The account if found.
     * @throws AccountNotFoundException
     *             If the number is not recognised.
     */
    @RequestMapping("/accounts/{accountNumber}")
    public Account byNumber(@PathVariable("accountNumber") String accountNumber) {

        logger.info("accounts-service byNumber() invoked: " + accountNumber);
        Account account = accountRepository.getByNumber(accountNumber);
        logger.info("accounts-service byNumber() found: " + account);

        if (account == null)
            throw new AccountNotFoundException(accountNumber);
        else {
            return account;
        }
    }

    /**
     * Fetch accounts with the specified name. A partial case-insensitive match
     * is supported. So <code>http://.../accounts/owner/a</code> will find any
     * accounts with upper or lower case 'a' in their name.
     *
     * @param partialName
     * @return A non-null, non-empty set of accounts.
     * @throws AccountNotFoundException
     *             If there are no matches at all.
     */
    @RequestMapping("/accounts/owner/{name}")
    public List<Account> byOwner(@PathVariable("name") String partialName) {
//        logger.info("accounts-service byOwner() invoked: "
//                + accountRepository.getClass().getName() + " for "
//                + partialName);

        List<Account> accounts = null; //accountRepository
//                .findByOwnerContainingIgnoreCase(partialName);
        logger.info("accounts-service byOwner() found: " + accounts);

        if (accounts == null || accounts.size() == 0)
            throw new AccountNotFoundException(partialName);
        else {
            return accounts;
        }
    }

}
