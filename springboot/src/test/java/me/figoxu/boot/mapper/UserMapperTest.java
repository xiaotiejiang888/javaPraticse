package me.figoxu.boot.mapper;

import java.util.List;

import me.figoxu.boot.BaseSpringTest;
import me.figoxu.boot.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


public class UserMapperTest extends BaseSpringTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new User("aa", "a123456", 1));
        userMapper.insert(new User("bb", "b123456", 0));
        userMapper.insert(new User("cc", "b123456", 0));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = userMapper.getAll();
        if(users==null || users.size()==0){
            System.out.println("is null");
        }else{
            System.out.println(users.toString());
        }
    }


    @Test
    public void testUpdate() throws Exception {
        User user = userMapper.getOne(1l);
        System.out.println(user.toString());
        user.setNickname("neo");
        userMapper.update(user);
        User u = userMapper.getOne(1l);
        String nickName = u.getNickname();
        Assert.assertTrue(("neo".equals(nickName)));
    }

}