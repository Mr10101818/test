package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findall();
        userList.forEach(System.out::println);
    }
    @Test
    public void testDeleteById(){
        Integer i = userMapper.deleteById(4);
        System.out.println("执行完毕后的影响数："+ i);
    }

    @Test
    public void testInsert(){
        User user= new User(null, "zhouyu", "666888", "周瑜", 18);
        userMapper.insert(user);
    }

    @Test
    public void testUpdate(){
        User user= new User(1, "yujin", "666888", "于禁", 18);
        userMapper.update(user);
    }

    @Test
    public void testFindByUsernameAndPassword(){
        User user=userMapper.findByUsernameAndPassword("zhouyu", "666888");
        System.out.println(user);
    }
}
