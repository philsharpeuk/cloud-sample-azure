package org.sharpeideas.cloud.sample.azure.account.dataaccess;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by phil on 17/04/2016.
 */
@Component
public class AccountDAO {

    Map<String, Account> accounts = new HashMap<>();
    BigDecimal defaultBalance = null;

    public synchronized Account getByNumber(String num) {
        Account a = accounts.get(num);
        if(a == null) {
            a = new Account();
            a.setId(new Random().nextLong());
            a.setNumber(num);
            a.setOwner("System");
            if(defaultBalance != null) {
                a.deposit(defaultBalance);
            }
            accounts.put(num, a);
        }
        return a;
    }
}
