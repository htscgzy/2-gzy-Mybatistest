package dao;

import domain.QueryVo;
import domain.QueryVolds;
import domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    User findByID(int uid);
    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(int uid);
    List<User> findByName(String str);
    int count();
    List<User> findByVo(QueryVo queryVo);
    List<User> findInlds(QueryVolds queryVolds);
}
