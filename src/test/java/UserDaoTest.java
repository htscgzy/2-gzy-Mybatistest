import dao.IUserDao;
import domain.QueryVo;
import domain.QueryVolds;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoTest {

    private InputStream in;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;


    @Before
    public void setUp() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public void test_selectbyid() {
        User user = userDao.findByID(42);
        System.out.println(user);
        Assert.assertEquals("李四",user.getUsername());
    }

    @Test
    public void test_save() {
        User user=new User();

        user.setUsername("华泰");
        user.setBirthday(new Date());
        user.setAddress("南京市建邺区");
        user.setSex("男");

        int id = userDao.saveUser(user);
        System.out.println(user.getId());

        Assert.assertEquals("南京市建邺区",userDao.findByID(user.getId()).getAddress());
    }

    @Test
    public void test_update() {
        int id=46;
        User user = userDao.findByID(id);
        user.setAddress("北京市");
        int res = userDao.updateUser(user);

        Assert.assertEquals("北京市",userDao.findByID(id).getAddress());
        //Assert.assertEquals("北京市",user.getAddress());

    }

    @Test
    public void test_delete() {
        int res = userDao.deleteUser(56);

        assert res==1;
    }

    @Test
    public void test_findbyname() {
        List<User> users = userDao.findByName("王");
        assert users.size()==2;
    }

    @Test
    public void test_count() {
        int count = userDao.count();
        assert count == 10;
    }

    @Test
    public void test_findByVo() {
        QueryVo queryVo = new QueryVo();
        queryVo.setAddress("%南京%");
        queryVo.setUsername("%王%");

        List<User> users = userDao.findByVo(queryVo);

        assert users.size()==1;
    }

    @Test
    public void test_findByVo_withoutAddress() {
        QueryVo queryVo = new QueryVo();
        queryVo.setAddress(null);
        queryVo.setUsername("%王%");

        List<User> users = userDao.findByVo(queryVo);

        assert users.size()==2;
    }

    @Test
    public void test_FindInlds() {
        QueryVolds queryVolds = new QueryVolds();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(45);
        ids.add(46);
        queryVolds.setIds(ids);

        List<User> users = userDao.findInlds(queryVolds);

        assert users.size()==4;
    }

    @Test
    public void test_finAll() {
        List<User> count = userDao.findAll();
        for(User u:count)
            System.out.println(u);
        assert count.size() == 10;

    }

    @After
    public void tearDown() throws Exception {
        session.commit();
        session.close();
        in.close();
    }
}
