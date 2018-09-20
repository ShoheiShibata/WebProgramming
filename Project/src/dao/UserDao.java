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

	            String login_idData = rs.getString("login_id");
	            String nameData = rs.getString("name");
	            return new User(login_idData, nameData);

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

	            // TODO: 未実装：管理者以外を取得するようSQLを変更する
	            String sql = "SELECT * FROM user";

	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String login_id = rs.getString("login_id");
	                String name = rs.getString("name");
	                Date birth_date = rs.getDate("birth_date");
	                String password = rs.getString("password");
	                String create_date = rs.getString("create_date");
	                String update_date = rs.getString("update_date");
	                User user = new User(id, login_id, name, birth_date, password, create_date, update_date);

	                userList.add(user);
	            }
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
	        return userList;
	    }


	    public void findByUserCreateInfo(String login_id, String name, String birth_date, String password) throws SQLException{
	        Connection conn = null;
	        try {
	            conn = DBManager.getConnection();

	            String sql = "INSERT INTO user(login_id,name,birth_date,password,create_date,update_date) VALUES(?,?,?,?,now(),now())";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, login_id);
	            pStmt.setString(2, name);
	            pStmt.setString(3, birth_date);
	            pStmt.setString(4, password);
	            pStmt.executeUpdate();


	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
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


	    public User findByUserDetailInfo(String id) {
	        Connection conn = null;
	        try {
	            conn = DBManager.getConnection();

	            String sql = "SELECT * FROM user WHERE id = ?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, id);
	            ResultSet rs = pStmt.executeQuery();

	            if (!rs.next()) {
	            	return null;
	            }
	            int idData = rs.getInt("id");
	            String login_idData = rs.getString("login_id");
	            String nameData = rs.getString("name");
	            Date birth_dateData = rs.getDate("birth_date");
	            String passwordData = rs.getString("password");
	            String create_dateData = rs.getString("create_date");
	            String update_dateData = rs.getString("update_date");
	            return new User(idData,login_idData,nameData, birth_dateData,passwordData,create_dateData,update_dateData);

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

	    public void findByUserUpdateInfo(String id, String name, String birth_date, String password) throws SQLException{
	        Connection conn = null;
	        try {
	            conn = DBManager.getConnection();

	            String sql = "UPDATE user SET name = ?,birth_date = ?,password = ?,update_date = now() WHERE id = ?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);

	            pStmt.setString(1, name);
	            pStmt.setString(2, birth_date);
	            pStmt.setString(3, password);
	            pStmt.setString(4, id);
	            pStmt.executeUpdate();


	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
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


	    public void findByUserDeleteInfo(String id) throws SQLException{
	        Connection conn = null;
	        try {
	            conn = DBManager.getConnection();

	            String sql = "DELETE FROM user WHERE id = ?";

	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, id);
	            pStmt.executeUpdate();


	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
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

