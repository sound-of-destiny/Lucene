package cn.edu.sdu.lucene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LuceneUtils {
	/*public static Connection openDb() {
        Connection conn = null;
        do {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:mysql://personal-mysql.mysql.database.azure.com:3306/supnuevo_ventas", "SqlAdmin@personal-mysql",
                        "TAuWcGN2eU#h4B#@");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException sqle) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("数据库错误");
                }
            }
        } while (conn == null);
        return conn;
    }*/

    public static Connection openDb() {
        Connection conn = null;
        do {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/supnuevo_ventas", "root",
                        "root");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException sqle) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("数据库错误");
                }
            }
        } while (conn == null);
        return conn;
    }
}
