package cn.tedu;

import org.junit.Test;

import java.sql.*;

public class Demo03 {

    public String url = "jdbc:mysql://localhost:3306/newdb3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
    public String user = "root";
    public String pwd = "root";

    @Test
    public void test01(){
        System.out.println("test01");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement s = conn.createStatement();
            String sql = "insert into emp(empno,ename) values(101,'灭霸')";
            s.executeUpdate(sql);
            conn.close();
            System.out.println("插入完毕!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02(){
        System.out.println("test02");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement s = conn.createStatement();
            String sql = "update emp set ename='超人' where ename='灭霸'";
            s.executeUpdate(sql);
            conn.close();
            System.out.println("修改完毕!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test03(){
        System.out.println("test03");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement s = conn.createStatement();
            String sql = "delete from emp where ename = '超人'";
            s.execute(sql);
            conn.close();
            System.out.println("删除完毕!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test04(){
        System.out.println("test04");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement s = conn.createStatement();
            String sql = "select * from emp";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("ename");
                double salary = rs.getDouble("sal");
                System.out.println("name:"+name +",sal:"+salary);
            }
            conn.close();
            System.out.println("查询完毕!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
