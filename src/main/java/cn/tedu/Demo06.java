package cn.tedu;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Demo06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String pwd = sc.nextLine();
        try(Connection conn = DBUtils.getConn()) {
//            Statement state = conn.createStatement();
//            String sql = "select id from user where username='"+name+"' and psaaword ='"+pwd+"'";
//            ResultSet rs = state.executeQuery(sql);
            //通过preparedstatement解决注入问题
            String sql = "select id from user where username=? and password =?";
            // 创建preparedStatement对象时 对sql语句进行编译 此时锁死sql语句的业务逻辑 不受用户输入的内容影响
            PreparedStatement ps = conn.prepareStatement(sql);
            // 替换掉语句中的? 参数位置从1开始
            ps.setString(1,name);
            ps.setString(2,pwd);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                System.out.println("登录成功");
            }else {
                System.out.println("用户名或密码错误!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
