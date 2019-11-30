package com.mina.homework.meeting.service;

import com.mina.homework.meeting.dao.AccountDao;
import com.mina.homework.meeting.dao.DBUtils;
import com.mina.homework.meeting.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    AccountDao accountDao;

    public int reg(String account, String password){
         Account acc = new Account(account, password);
         return this.reg(acc);

    }

    private int reg(Account account) {
        return accountDao.reg(account);
    }
}
