package com.xiaoshuai885.controller;

import com.xiaoshuai885.domain.Account;
import com.xiaoshuai885.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("Controller层：findAll方法执行……");
        //调用service层的方法
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts",accounts);
        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account,
                     HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Controller层：save方法执行……");
        //调用service层的方法
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

    @RequestMapping("/delete")
    public void deleteAccountById(Integer id,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("Controller层：deleteAccountById方法执行……");
        accountService.deleteAccountById(id);
        System.out.println(request.getContextPath());
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

    @RequestMapping("/update")
    public void updateAccount(Account account,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        if (account.getId() == null) {
            response.sendRedirect(request.getContextPath()+"/account/findAll");
        }else{
            if (account.getName() == "" || account.getMoney() == null) {
                Account old = accountService.selectAccount(account.getId());
                if (account.getName() == "") {
                    System.out.println("name is null !");
                    //使用旧账户的名字
                    account.setName(old.getName());
                }
                if (account.getMoney() == null) {
                    System.out.println("money is null !");
                    //使用旧账户的钱
                    account.setMoney(old.getMoney());
                }
            }
            System.out.println("Controller层：updateAccount方法执行……");
            accountService.updateAccountById(account);
            response.sendRedirect(request.getContextPath()+"/account/findAll");
        }
    }
}
