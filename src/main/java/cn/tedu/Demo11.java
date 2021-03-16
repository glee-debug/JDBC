package cn.tedu;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入球队名");
        String teamname = sc.nextLine();
        System.out.println("请输入球员名");
        String playername = sc.nextLine();
        try(Connection conn = DBUtils.getConn()) {
            //把球队名添加到team表中
            String sql = "insert into team values(null,?)";
            PreparedStatement ps  = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,teamname);
            ps.executeUpdate();
            // 获取球队自增的id值
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            System.out.println(id);
            // 把球员名添加到player表中, 用到上面得到的球队id
            String playerSql = "insert into player values(null,?,?)";
            ps=conn.prepareStatement(playerSql);
            ps.setString(1,playername);
            ps.setInt(2,id);
            ps.executeUpdate();
            System.out.println("执行完成!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
        }
    }
}
