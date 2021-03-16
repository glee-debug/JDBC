package cn.tedu;

import java.io.IOException;
import java.sql.*;

/**
 * 元数据
 */
public class Demo12 {
    public static void main(String[] args) {
        try(Connection conn = DBUtils.getConn()) {
            //获取数据库元数据对象
            DatabaseMetaData dmd = conn.getMetaData();
            System.out.println("数据库驱动名:"+dmd.getDriverName());
            System.out.println("数据库名:"+dmd.getDatabaseProductName());
            System.out.println("数据库连接地址名:"+dmd.getURL());
            System.out.println("数据库驱动版本:"+dmd.getDriverVersion());
            String sql = "select * from emp";
            Statement stete = conn.createStatement();
            ResultSet rs = stete.executeQuery(sql);
            // 获取表元数据对象
            ResultSetMetaData rmd = rs.getMetaData();
            //获取表字段数量
            int count = rmd.getColumnCount();
            for (int i = 1; i <= count; i++) {
                //获取字段名
                String name = rmd.getColumnName(i);
                // 获取字段类型
                String type = rmd.getColumnTypeName(i);
                System.out.println(name+":"+type);
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
