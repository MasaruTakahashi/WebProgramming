package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.User;

public class UserDao {

	public User findByLoginInfo(String login_id, String password)  {
		Connection conn = null;
		try {

			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			String pass = md5(password);

			pStmt.setString(1, login_id);
			pStmt.setString(2, pass);

			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()){
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

			String sql = "SELECT id , login_id , name, birth_date, password, create_date, update_date FROM user where login_id <> 'admin'";

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

	public List<User> findSearch(String loginIdP, String nameP, String birth_dateSP, String birth_dateEP) {
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {

			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user where login_id <> 'admin'";

			if(!loginIdP.equals("")) {
				sql += " AND login_id = '" + loginIdP + "'";
			}
			if(!nameP.equals("")) {
				sql += "and name LIKE '%" + nameP +"%'";
			}
			if(!birth_dateSP.equals("")) {
				sql += "and birth_date >= '" + birth_dateSP +"'";
			}
			if(!birth_dateEP.equals("")) {
				sql += "and birth_date <= '" + birth_dateEP +"'";
			}




			System.out.println(sql);

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
			String password)  {

		Connection conn = null;
		try {

			conn = DBManager.getConnection();
			String sql = "insert into user(login_id , name, birth_date, password, create_date, update_date)"
					+ "values(?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			String pass = md5(password);

			pStmt.setString(1, login_id);
			pStmt.setString(2, name);
			pStmt.setString(3, birth_date);
			pStmt.setString(4, pass);

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
				int Id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String password = rs.getString("password");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");

				 user = new User(Id, loginId, password,name,birthDate,createDate,updateDate);


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

	 public void update(int id, String password, String name, String birth_date){

	        Connection conn = null;
	        try {
	        	conn = DBManager.getConnection();
	        	String sql = "update user set password = ?,name = ?,birth_date = ?, update_date=CURRENT_TIMESTAMP where id = ?";
	        	PreparedStatement pStmt = conn.prepareStatement(sql);

	        	String pass = md5(password);

	        	pStmt.setString(1, pass);
	        	pStmt.setString(2, name);
	        	pStmt.setString(3, birth_date);
	        	pStmt.setInt(4, id);

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
	 public void updateNopass(int id, String name, String birth_date){

	        Connection conn = null;
	        try {
	        	conn = DBManager.getConnection();
	        	String sql = "update user set name = ?,birth_date = ?, update_date = CURRENT_TIMESTAMP where id = ?";

	        	PreparedStatement pStmt = conn.prepareStatement(sql);


	        	pStmt.setString(1, name);
	        	pStmt.setString(2, birth_date);
	        	pStmt.setInt(3, id);

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
	 public void delete(int id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql = "delete from user where id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1,id);

			pStmt.executeUpdate();

		}catch (SQLException e) {
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
	 public static String md5(String password){
	//ハッシュを生成したい元の文字列
	 String source = password;
	 //ハッシュ生成前にバイト配列に置き換える際のCharset
	 Charset charset = StandardCharsets.UTF_8;
	 //ハッシュアルゴリズム
	 String algorithm = "MD5";

	 //ハッシュ生成処理
	 byte[] bytes = null;
	try {
		bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
	} catch (NoSuchAlgorithmException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
	 String result = DatatypeConverter.printHexBinary(bytes);
	 //標準出力
	 System.out.println(result);
	return result;
	 }
}
