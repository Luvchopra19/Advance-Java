package PrepeardStatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class UserModel {
	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String username = rb.getString("username");
	String password = rb.getString("password");

	// <----- nextPk() ------>
	public int nextPk() throws Exception {

		int pk = 0;

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url, username, password);

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;
	}

	// <----- add method ----->
	public void add(UserBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, username, password);

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?)");

			pstmt.setInt(1, nextPk());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getFirstName());
			pstmt.setString(4, bean.getlogin());
			pstmt.setString(5, bean.getPassward());
			pstmt.setDate(6, new java.sql.Date(bean.getdob().getTime()));

			int i = pstmt.executeUpdate();

			System.out.println(i + " row affected(records inserted...)");

			conn.commit();

			conn.close();
			pstmt.close();

		} catch (Exception e) {
			conn.rollback();
		}

	}

}
