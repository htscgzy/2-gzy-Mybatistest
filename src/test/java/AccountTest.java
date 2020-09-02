import dao.IAccountDao;
import dao.IUserDao;
import domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {

    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IAccountDao accountDao;


    @Before
    public void setUp() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        accountDao = session.getMapper(IAccountDao.class);
    }

    @Test
    public void test_findAll() {
        List<AccountUser> accountUsers = accountDao.findAll();
        for(AccountUser a: accountUsers)
            System.out.println(a);

        assert accountUsers.size() == 3;
    }

    @After
    public void tearDown() throws Exception {
        session.commit();
        session.close();
        in.close();
    }
}
