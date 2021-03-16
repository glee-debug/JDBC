package cn.tedu;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Demo13 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入球队名");
        String teamname = sc.nextLine();
        System.out.println("请输入球员名");
        String playername = sc.nextLine();
        try(Connection conn = DBUtils.getConn()) {
            /*
             * 1. 查询球队表中是否有用户输入的球队, 如果有查询出球队id
             * 如果没有则把球队名添加到表中 同时还要获取出自增的id
             * 2. 把球员名添加到球员表中,用到上面得到的id
             */
            String sql = "select id from team where name=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,teamname);
            ResultSet rs = ps.executeQuery();
            int team_id;
            if (rs.next()){
                team_id = rs.getInt(1);
                System.out.println(teamname+"已存在,id为:"+team_id);
            }else {
                String insSql = "insert into team values(null,?)";
                PreparedStatement pps = conn.prepareStatement(insSql,Statement.RETURN_GENERATED_KEYS);
                pps.setString(1,teamname);
                pps.executeUpdate();
                ResultSet idRs = pps.getGeneratedKeys();
                idRs.next();
                team_id = idRs.getInt(1);
            }
            String playerSql = "insert into player values(null,?,?)";
            ps = conn.prepareStatement(playerSql);
            ps.setString(1,playername);
            ps.setInt(2,team_id);
            ps.executeUpdate();
            System.out.println("插入球员完毕");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {

        }
    }
}
