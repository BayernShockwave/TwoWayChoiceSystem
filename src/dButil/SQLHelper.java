package dButil;
import java.sql.*;
public class SQLHelper {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/FinalText";
	private static String user = "root", pwd = "root";
	private static Connection con = null;
	static {
		try {
			Class.forName(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static int executeUpdate(String sql) {
		int r = 0;
		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			Statement cmd = con.createStatement();
			r = cmd.executeUpdate(sql);
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}

	public static ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			Statement cmd = con.createStatement();
			rs = cmd.executeQuery(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static void closeConnect() {
		try {
			if (con != null && !con.isClosed()) {
               con.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}