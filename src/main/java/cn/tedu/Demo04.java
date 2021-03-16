package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        //获取连接
        try (Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select ename,sal from emp where ename='孙悟空'");
            while(rs.next()){
                String name = rs.getString("ename");
                /*double sal = rs.getDouble("sal");*/
                //通过字段的位置获取数据
                double sal = rs.getDouble(2);
                System.out.println(name+","+sal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
