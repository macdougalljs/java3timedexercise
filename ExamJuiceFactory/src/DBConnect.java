

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnect {

	/*
	 * private String connUrl = "jdbc:mysql://localhost/grades"; private String
	 * username = "root"; private String password = "root"; private String driver =
	 * "com.mysql.jdbc.Driver";
	 */
	private String url;
	private String username;
	private String password;
	static Statement stmt = null;
	static ResultSet rs = null;
	static Connection conn = null;

	/**
	 * No default constructor.
	 */
	public DBConnect(String driver, String connUrl, String username, String password) {
		try {
			Class.forName(driver);
			try {
				conn = DriverManager.getConnection(connUrl, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.url = connUrl;
		this.username = username;
		this.password = password;

	}

	@SuppressWarnings("finally")
	public Connection getConnect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("The following error occurred: Exception creating Connection object.");
		} finally {
			return conn;
		}

	}

	public static void closeJDBCObjects(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException ignored) {
		}

	}

}
