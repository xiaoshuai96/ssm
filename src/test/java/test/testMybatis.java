package test;

import com.xiaoshuai885.dao.IAccountDao;
import com.xiaoshuai885.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class testMybatis {
    @Test
    public void run01() throws Exception{
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        IAccountDao dao = session.getMapper(IAccountDao.class);
        //调用方法
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        session.close();
        in.close();
    }

    @Test
    public void run02() throws Exception{
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        IAccountDao dao = session.getMapper(IAccountDao.class);
        //调用方法
        Account account = new Account();
        account.setName("xxx");
        account.setMoney(1000d);
        dao.saveAccount(account);
        session.commit();
        session.close();
        in.close();
    }
}
