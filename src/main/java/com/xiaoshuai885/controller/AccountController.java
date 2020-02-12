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
        System.out.println("表现层：查询所有的信息方法执行……");
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts",accounts);
        return "list";
    }

    @RequestMapping("/save")
    public void saveAccount(Account account,
        HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("表现层：保存账户方法执行……");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

    @RequestMapping("/delete")
    public void deleteAccount(Integer id,
        HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("表现层：删除账户方法执行……");
        if (accountService.findId(id) != null) {
            accountService.deleteAccountById(id);
            response.sendRedirect(request.getContextPath()+"/account/findAll");
        }else{
            response.getWriter().print("Id invalid");
        }
    }

    @RequestMapping("/update")
    public void updateAccountById(Account account,
        HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("表现层：更新账户方法执行");
        //判断id是否有效
        if (accountService.findId(account.getId()) != null) {
            accountService.updateAccountById(account);
            response.sendRedirect(request.getContextPath()+"/account/findAll");
        }else{
            response.getWriter().print("Id invalid");
        }
    }
}
