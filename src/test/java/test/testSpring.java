package test;

import com.xiaoshuai885.domain.Account;
import com.xiaoshuai885.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testSpring {
    @Test
    public void run01() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        List<Account> all = service.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
}
