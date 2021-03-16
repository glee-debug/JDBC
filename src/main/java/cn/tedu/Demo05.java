package cn.tedu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String name = sc.nextLine();
        System.out.println("请输入密码:");
        String pwd = sc.nextLine();
        try(Connection conn = DBUtils.getConn()) {
            Statement state = conn.createStatement();
            String sql = "insert into user values(null,'"+name +"','"+pwd+"')";
            state.executeUpdate(sql);
            System.out.println("插入成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
