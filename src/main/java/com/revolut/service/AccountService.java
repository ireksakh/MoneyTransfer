package com.revolut.service;

import com.revolut.dao.AccountDao;
import com.revolut.model.Account;


public class AccountService {
    private AccountDao accountDao = new AccountDao();


    public AccountService() {
    }

    public Account getAccountById(int id) {
        return accountDao.getAccountById(id);
    }

    public Account update(Account account) {
        return accountDao.update(account);

    }


    public double gerAccountBalance(int id) {
        return accountDao.getAccountBalance(id);
    }

    public void transfer(int sourceId, int destinationId, double amount) {
        accountDao.transfer(sourceId, destinationId, amount);
    }
}







