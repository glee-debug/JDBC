package cn.tedu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) {
        try {
            Connection conn = DBUtils.getConn();
            // 创建执行sql语句的对象
            Statement s = conn.createStatement();
            String sql = "create table jdbct1(id int,name varchar(20))";
            // 执行sql 语句
            s.execute(sql);
            // 关闭资源
            conn.close();
            System.out.println("执行完成");
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
