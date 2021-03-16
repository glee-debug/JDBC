package cn.tedu;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Demo09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询的页数:");
        int page = sc.nextInt();
        System.out.println("请输入查询的条数:");
        int count  = sc.nextInt();
        try(Connection conn = DBUtils.getConn()) {
            String sql = "select * from user limit ?,?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,(page-1)*count);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                System.out.println(id+","+username+","+password);
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
