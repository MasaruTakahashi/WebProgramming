package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	public User findByLoginInfo(String login_id, String password) {
		Connection conn = null;
		try {

			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String loginidDate = rs.getString("login_id");
			String nameDate = rs.getString("name");
			return new User(loginidDate, nameDate);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}

	}

	public List<User> findAll() {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {

			conn = DBManager.getConnection();

			String sql = "SELECT id , login_id , name, birth_date, password, create_date, update_date FROM user";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public void insert(
			String login_id, String name, String birth_date,
			String password) {

		Connection conn = null;
		try {

			conn = DBManager.getConnection();
			String sql = "insert into user(login_id , name, birth_date, password, create_date, update_date)"
					+ "values(?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, login_id);
			pStmt.setString(2, name);
			pStmt.setString(3, birth_date);
			pStmt.setString(4, password);

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}

	public User findByloginid(String login_id) {
		Connection conn = null;
		try {

			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);

			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String loginidDate = rs.getString("login_id");
			return new User(loginidDate);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}

	}

	public User findByReference(int id) {
		Connection conn = null;
		User user = null;
		try {

			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");

				 user = new User(loginId,name,birthDate,createDate,updateDate);


			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return user;
	}

	 public void update(String password, String name, String birth_date){

	        Connection conn = null;
	        try {
	        	conn = DBManager.getConnection();
	        	String sql = "update into user(password,name,birth_date, update_date) w"
		        		+ "values(?,?,?,CURRENT_TIMESTAMP)";
	        	PreparedStatement pStmt = conn.prepareStatement(sql);

	        	pStmt.setString(1, password);
	        	pStmt.setString(2, name);
	        	pStmt.setString(3, birth_date);

	        	pStmt.executeUpdate();

	 } catch (SQLException e) {
			e.printStackTrace();

		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}
}
