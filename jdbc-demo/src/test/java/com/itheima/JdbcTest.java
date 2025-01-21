package com.itheima;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcTest {

    @Test
    public void testUpdate() throws Exception {
        //1注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");


        //2获取连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "123456";
        Connection connection=DriverManager.getConnection(url, username, password);


        //3获取SQL语句执行对象
        Statement statement = connection.createStatement();

        //4执行SQL语句
        int i =statement.executeUpdate("update user set age=25 where id = 1");
        System.out.println("SQL执行完影响的记录数："+ i);

        //5释放资源
        statement.close();
        connection.close();


    }
}
