package com.xiaoshuai885.dao;

import com.xiaoshuai885.domain.Account;

import java.util.List;
public interface IAccountDao {

    public List<Account> findAll();

    public void deleteAccountById(Integer id);

    public void saveAccount(Account account);

    public void updateAccountById(Account account);

    public Account selectAccount(Integer id);
}
