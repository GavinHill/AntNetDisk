package me.coding.gavinhill.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.coding.gavinhill.domain.Cloudfile;
import me.coding.gavinhill.utils.DataSourceUtils;

public class FileDao {

	public static boolean upload(String userid, String fileuuid, String filename, String filepath, Date uploaddate)
			throws SQLException {

		// 设置SQL语句
		String sql = "insert into file values(?,?,?,?,?,?,?,?,?)";

		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();

		// 获得语句执行平台并设置占位符(?)
		PreparedStatement CloudfileStatement = con.prepareStatement(sql);
		CloudfileStatement.setString(1, getNextID());
		CloudfileStatement.setString(2, userid);
		CloudfileStatement.setString(3, fileuuid);
		CloudfileStatement.setString(4, filename);
		CloudfileStatement.setString(5, filepath);
		CloudfileStatement.setString(6, "0");
		CloudfileStatement.setString(7, "1");
		CloudfileStatement.setDate(8, uploaddate);
		CloudfileStatement.setString(9, "0");
		int rs = CloudfileStatement.executeUpdate();
		if (rs == 1) {
			con.close();
			CloudfileStatement.close();
			return true;
		} else {
			con.close();
			CloudfileStatement.close();
			return false;
		}

	}

	public static String getNextID() {
		String fileID = null;

		String sql = "SELECT COUNT(1) FROM file";// 以固定值的方法来查询一共多少行

		// 计算用户量并分配新的ID
		try {
			Connection con = DataSourceUtils.getConn();
			PreparedStatement preUploadStatement = con.prepareStatement(sql);
			ResultSet preRs = preUploadStatement.executeQuery();
			preRs.next();
			fileID = preRs.getInt(1) + 1 + "";
			DataSourceUtils.close(con, preUploadStatement, preRs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileID;
	}

	public static List<Cloudfile> getFileData() throws SQLException {
		//定义一个List用于封装数据
		List<Cloudfile> filelist = new ArrayList<Cloudfile>();
		
		// 设置SQL语句
		String sql = "SELECT * FROM file WHERE user_id=? AND parent_id=?";
		
		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();

		// 获得语句执行平台并设置占位符(?)
		PreparedStatement getFileDataStatement = con.prepareStatement(sql);
		getFileDataStatement.setString(1, UserDao.user.getUserid());
		getFileDataStatement.setString(2, "0");
		ResultSet rs = getFileDataStatement.executeQuery();
		while (rs.next()) {
			//封装数据
			Cloudfile cloudfile = new Cloudfile();
			
			cloudfile.setFilename(rs.getString("file_name"));
			cloudfile.setFileuuid(rs.getString("file_uuid"));
			cloudfile.setFilepath(rs.getString("file_path"));
			cloudfile.setFiletype(rs.getString("file_type"));
			cloudfile.setUploaddate(rs.getDate("upload_date"));
			filelist.add(cloudfile);
		}
		return filelist;
	}
}
