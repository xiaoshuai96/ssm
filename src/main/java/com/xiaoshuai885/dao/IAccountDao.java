package com.xiaoshuai885.dao;

import com.xiaoshuai885.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dao
 */
@Repository
public interface IAccountDao {
    /**
     * 查询所有账户信息
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 根据id删除账户信息
     *
     * @param id
     * @return
     */
    @Delete({"delete from account where id = #{id}"})
    public void deleteAccountById(Integer id);

    /**
     * 保存新账户
     *
     * @param account
     */
    @Insert("insert into account (name,money) values(#{name},#{money})")
    public void saveAccount(Account account);

    /**
     * 根据id更改账户信息
     * @param account
     */
    @Update("update account set name = #{name},money = #{money} where id = #{id}")
    public void updateAccountById(Account account);

    /**
     * 查看此id是否有效
     * @param id
     * @return
     */
    @Select("select * from account where id = #{id}")
    public Account findId(Integer id);
}
