package cn.tedu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo07 {
    public static void main(String[] args) {
        //获取连接
        try (Connection conn = DBUtils.getConn()){
            String sql1 = "insert into user values(null,'aaa','aaa')";
            String sql2 = "insert into user values(null,'bbb','bbb')";
            String sql3 = "update user set username='ccc' where username='aaa'";
            Statement s = conn.createStatement();
            //添加到批量操作
            s.addBatch(sql1);
            s.addBatch(sql2);
            s.addBatch(sql3);
            //此时进行数据传输
            s.executeBatch();
            System.out.println("执行完成");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
