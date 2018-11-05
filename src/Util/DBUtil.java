package Util;

import Util.XmlUtil;
import oracle.jdbc.driver.OracleDriver;
import java.sql.*;
import java.util.Properties;
/**
 * Created by 10412 on 2016/12/27.
 * JDBC的六大步骤
 * JAVA连接Oracle的三种方式
 */
public class DBUtil {
    private static String DataBaseName = XmlUtil.getDataBaseName();
    private static String UserName = XmlUtil.getUserName();
    private static String PassWord = XmlUtil.getPassWord();

    public Connection getConnection() throws SQLException {
        Driver driver = new OracleDriver();
        DriverManager.deregisterDriver(driver);
        Properties pro = new Properties();
        pro.put("user", UserName);
        pro.put("password", PassWord);
        return driver.connect("JDBC:oracle:thin:@localhost:1521/" + DataBaseName, pro);
    }
}