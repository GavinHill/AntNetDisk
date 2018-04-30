package me.coding.gavinhill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.coding.gavinhill.domain.User;
import me.coding.gavinhill.utils.DataSourceUtils;

public class UserDao {
	
	public static User user = new User();
	
	/**
	 * 通过用户名和密码进行用户查询
	 * 
	 * @param username
	 * @param userpsword
	 * @return
	 */

	// 实现用户查询
	public static String search(String useraccount, String userpsword) throws SQLException {

		// 设置SQL语句
		String sql = "SELECT * FROM user WHERE user_account=? and user_psword=?;";

		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();

		// 获得语句执行平台并设置占位符(?)
		PreparedStatement LoginStatement = con.prepareStatement(sql);
		LoginStatement.setString(1, useraccount);
		LoginStatement.setString(2, userpsword);
		ResultSet rs = LoginStatement.executeQuery();

		// 逻辑判断
		if (rs.next()) {
			String username = rs.getString("user_name");
			//封装userID
			user.setUserid(rs.getString("user_id"));
			DataSourceUtils.close(con, LoginStatement, rs);
			return username;
		} else {
			String errorReturn = "error";
			DataSourceUtils.close(con, LoginStatement, rs);
			return errorReturn;
		}
	}

	// 实现注册前的是否有重复账号的查询
	public static boolean search(String useraccount) throws SQLException {

		// 设置SQL语句
		String sql = "SELECT * FROM user WHERE user_account=?";

		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();

		// 获得语句执行平台并设置占位符(?)
		PreparedStatement RegisterStatement = con.prepareStatement(sql);
		RegisterStatement.setString(1, useraccount);
		ResultSet rs = RegisterStatement.executeQuery();

		// 逻辑判断
		if (rs.next()) {
			DataSourceUtils.close(con, RegisterStatement, rs);
			return true;
		} else {
			DataSourceUtils.close(con, RegisterStatement, rs);
			return false;
		}
	}

	// 实现注册用户功能
	public static boolean register(String useraccount, String userpsword, String username, String usertel)
			throws SQLException {

		// 设置SQL语句和用户ID参数
		String userID = getNextID();
		String sql = "INSERT INTO user (user_id,user_account,user_psword,user_name,user_tel) VALUES (?,?,?,?,?)";

		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();

		// 进行注册操作
		PreparedStatement RegisterStatement = con.prepareStatement(sql);
		RegisterStatement.setString(1, userID);
		RegisterStatement.setString(2, useraccount);
		RegisterStatement.setString(3, userpsword);
		RegisterStatement.setString(4, username);
		RegisterStatement.setString(5, usertel);
		int rs = RegisterStatement.executeUpdate();
		if (rs == 1) {
			con.close();
			RegisterStatement.close();
			return true;
		} else {
			con.close();
			RegisterStatement.close();
			return false;
		}
	}

	public static String getNextID() throws SQLException {
		String userID = null;

		String sql = "SELECT COUNT(1) FROM user";// 以固定值的方法来查询一共多少行

		// 计算用户量并分配新的ID
		Connection con = DataSourceUtils.getConn();
		PreparedStatement preRegisterStatement = con.prepareStatement(sql);
		ResultSet rs = preRegisterStatement.executeQuery();
		rs.next();
		userID = rs.getInt(1) + 1 + "";
		DataSourceUtils.close(con, preRegisterStatement, rs);
		return userID;
	}
}