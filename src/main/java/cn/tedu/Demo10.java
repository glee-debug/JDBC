package cn.tedu;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

/**
 * 获取自增主键值
 */
public class Demo10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        // 自定义模板代码
        try(Connection conn = DBUtils.getConn()) {
            String sql = "insert into user values(null,?,?)";
            //sql后面添加参数 用于获取自增主键值
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeUpdate();
            //获取装着自增主键值的结果集对象
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();//让游标下移
            int id = rs.getInt(1);//取出结果集中装的自增主键值
            System.out.println("用户id:"+id);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
