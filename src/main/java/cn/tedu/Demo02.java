package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
            String user = "root";
            String pwd = "root";
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement s = conn.createStatement();
            String sql = "drop table jdbct1";
            s.execute(sql);
            conn.close();
            System.out.println("删除完毕!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
