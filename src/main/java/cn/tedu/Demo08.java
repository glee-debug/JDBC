package cn.tedu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo08 {
    public static void main(String[] args) {
        try(Connection conn = DBUtils.getConn()) {
            String sql = "insert into user values(null,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 1; i <= 100 ; i++) {
                ps.setString(1,"名字"+i);
                ps.setString(2,"密码"+i);
                ps.addBatch();
                if(i%20==0){
                    ps.executeBatch();
                }
            }
            System.out.println("执行完成!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
