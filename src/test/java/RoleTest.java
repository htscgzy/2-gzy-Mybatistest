import dao.IAccountDao;
import dao.IRoleDao;
import domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class RoleTest {
    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IRoleDao roleDao;


    @Before
    public void setUp() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        roleDao = session.getMapper(IRoleDao.class);
    }

    @Test
    public void test_findAll() {
        List<Role> roles = roleDao.findAll();

        Assert.assertEquals(3,roles.size());

        for(Role r:roles){
            System.out.println("--每个角色的信息--");
            System.out.println(r);
            System.out.println(r.getUsers());
        }
    }
}
