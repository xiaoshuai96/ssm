package com.xiaoshuai885.service.impl;

import com.xiaoshuai885.dao.IAccountDao;
import com.xiaoshuai885.domain.Account;
import com.xiaoshuai885.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao dao;

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }

    @Override
    public void deleteAccountById(Integer id) {
        dao.deleteAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        dao.saveAccount(account);
    }

    @Override
    public void updateAccountById(Account account) {
        dao.updateAccountById(account);
    }

    @Override
    public Account findId(Integer id) {
        return dao.findId(id);
    }
}
