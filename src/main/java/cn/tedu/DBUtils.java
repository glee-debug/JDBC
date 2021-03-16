package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    //数据库连接池对象
    public static DruidDataSource ds;

    static {
        Properties p  = new Properties();
        InputStream ins = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            p.load(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver = p.getProperty("db.driver");
        String url = p.getProperty("db.url");
        String user = p.getProperty("db.username");
        String pwd = p.getProperty("db.password");

        //创建数据库连接池对象
        ds = new DruidDataSource();
        // 设置数据库连接信息
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(pwd);
        // 设置初始连接数量
        ds.setInitialSize(3);
        // 设置最大连接数量
        ds.setMaxActive(5);
    }

    public static Connection getConn() throws ClassNotFoundException, SQLException, IOException {
        // 获取连接对象 异常抛出
        Connection conn = ds.getConnection();
        return  conn;
    }
}
