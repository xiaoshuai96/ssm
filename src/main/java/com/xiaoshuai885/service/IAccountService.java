package com.xiaoshuai885.service;

import com.xiaoshuai885.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAccountService {
    /**
     * 查询所有账户信息
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据id删除账户信息
     *
     * @param id
     * @return
     */
    public void deleteAccountById(Integer id);

    /**
     * 保存新账户
     *
     * @param account
     */
    public void saveAccount(Account account);

    /**
     * 根据id更改账户信息
     * @param account
     */
    public void updateAccountById(Account account);

    /**
     * 查看此id是否有效
     * @param id
     * @return
     */
    @Select("select * from account where id = #{id}")
    public Account findId(Integer id);
}
