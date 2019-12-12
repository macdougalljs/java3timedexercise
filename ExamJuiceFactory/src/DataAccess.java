

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ca.sheridancollege.model.Student;

public class DataAccess {

	/* This class will retrieve the Student Object from the database */

	@SuppressWarnings("finally")

	/* This method will insert a new row into the table */

	public boolean insertRow(Connection conn, int oq, int aq, int gq, double totalCost) {
		boolean success = false;

		// declare JDBC objects
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "INSERT INTO orders (orangeQ, appleQ,  grapeQ, totalCost) VALUES(?, ?, ?, ?);";

			// initially set the main student information

			ps = conn.prepareStatement(sql);
			ps.setInt(1, oq);
			ps.setInt(2, aq);
			ps.setInt(3, gq);
			ps.setDouble(4, totalCost);
			
			int count = ps.executeUpdate();
			if (count > 0) {
				success = true;
			}
		} catch (SQLException e) {
		} finally {
			DBConnect.closeJDBCObjects(conn, ps, rs);
			return success;
		}
	}


}
