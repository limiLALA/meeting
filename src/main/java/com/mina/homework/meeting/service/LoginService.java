package com.mina.homework.meeting.service;

import com.mina.homework.meeting.dao.AccountDao;
import com.mina.homework.meeting.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    AccountDao accountDao;

    public boolean login(String account, String password){
        Account acc = new Account(account, password);
        return this.login(acc);
    }

    private boolean login(Account account) {

        return accountDao.login(account);
    }
}
