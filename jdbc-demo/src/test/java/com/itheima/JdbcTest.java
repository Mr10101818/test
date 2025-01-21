package com.itheima;

import com.itheima.pojo.User;
import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.*;

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

    @Test
    public void testSelect() throws Exception {

        String JDBC_URL = "jdbc:mysql://localhost:3306/web01";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "123456";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. 加载数据库驱动 (对于较新的JDBC驱动，这一步通常是不需要显式调用的)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 获取数据库连接
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // 3. 准备SQL语句
            String sql = "SELECT id, username, password, name, age FROM user WHERE username=? AND password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "daqiao");
            pstmt.setString(2, "123456");

            // 4. 执行查询
            rs = pstmt.executeQuery();

            // 5. 处理结果集
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("age")
                );

                // 输出用户信息到控制台
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try { if (rs != null) rs.close(); } catch (SQLException e) { /* ignored */ }
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { /* ignored */ }
            try { if (conn != null) conn.close(); } catch (SQLException e) { /* ignored */ }
        }
    }
}
