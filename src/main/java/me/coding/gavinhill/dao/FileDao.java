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

	public static boolean upload(String userid, String fileuuid, String filename, String filepath, String parentid,
			String filetype, Date uploaddate, String isshare) throws SQLException {

		// 设置SQL语句
		String sql = "INSERT INTO file(user_id, file_uuid, file_name, file_path, parent_id, file_type, upload_date, isshare) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();

		// 获得语句执行平台并设置占位符(?)
		PreparedStatement cloudfileStatement = con.prepareStatement(sql);
		cloudfileStatement.setString(1, userid);
		cloudfileStatement.setString(2, fileuuid);
		cloudfileStatement.setString(3, filename);
		cloudfileStatement.setString(4, filepath);
		cloudfileStatement.setString(5, parentid);
		cloudfileStatement.setString(6, filetype);
		cloudfileStatement.setDate(7, uploaddate);
		cloudfileStatement.setString(8, isshare);
		int rs = cloudfileStatement.executeUpdate();
		if (rs == 1) {
			con.close();
			cloudfileStatement.close();
			return true;
		} else {
			con.close();
			cloudfileStatement.close();
			return false;
		}

	}

	public static List<Cloudfile> getFileData(String parentid, String filename) throws SQLException {
		// 定义一个List用于封装数据
		List<Cloudfile> filelist = new ArrayList<Cloudfile>();
		ResultSet rs = null;

		if (filename == null) {
			System.out.println("进入父ID查询");
			
			// 设置SQL语句
			String sql = "SELECT * FROM file WHERE user_id=? AND parent_id=?";

			// 获取数据连接池连接
			Connection con = DataSourceUtils.getConn();

			// 获得语句执行平台并设置占位符(?)
			PreparedStatement getFileDataStatement = con.prepareStatement(sql);
			getFileDataStatement.setString(1, UserDao.user.getUserid());
			getFileDataStatement.setString(2, parentid);
			rs = getFileDataStatement.executeQuery();
		} else {
			System.out.println("进入名字查询");
			
			// 设置SQL语句
			String sql = "SELECT * FROM file WHERE user_id=? AND file_name=?";
			
			// 获取数据连接池连接
			Connection con = DataSourceUtils.getConn();

			// 获得语句执行平台并设置占位符(?)
			PreparedStatement getFileDataStatement = con.prepareStatement(sql);
			getFileDataStatement.setString(1, UserDao.user.getUserid());
			getFileDataStatement.setString(2, filename);
			rs = getFileDataStatement.executeQuery();
		}

		while (rs.next()) {
			// 封装数据
			Cloudfile cloudfile = new Cloudfile();

			cloudfile.setFileid(rs.getString("file_id"));
			cloudfile.setFileuuid(rs.getString("file_uuid"));
			cloudfile.setFilename(rs.getString("file_name"));
			cloudfile.setFilepath(rs.getString("file_path"));
			cloudfile.setParentid(rs.getString("parent_id"));
			cloudfile.setFiletype(rs.getString("file_type"));
			cloudfile.setUploaddate(rs.getDate("upload_date"));
			cloudfile.setIsshare(rs.getString("isshare"));
			filelist.add(cloudfile);
		}
		return filelist;
	}

	// 新建文件夹操作
	public static boolean addNewFolder(String userid, String fileuuid, String filename, String filepath,
			String parentid, String filetype, Date createdate, String isshare) throws SQLException {
		String sql = "INSERT INTO file(user_id, file_uuid, file_name, file_path, parent_id, file_type, upload_date, isshare) VALUES(?, ?, ?,? ,?, ?, ?, ?)";

		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();

		PreparedStatement cloudfileStatement = con.prepareStatement(sql);
		cloudfileStatement.setString(1, userid);
		cloudfileStatement.setString(2, fileuuid);
		cloudfileStatement.setString(3, filename);
		cloudfileStatement.setString(4, filepath);
		cloudfileStatement.setString(5, parentid);
		cloudfileStatement.setString(6, filetype);
		cloudfileStatement.setDate(7, createdate);
		cloudfileStatement.setString(8, isshare);
		int rs = cloudfileStatement.executeUpdate();
		if (rs == 1) {
			con.close();
			cloudfileStatement.close();
			return true;
		} else {
			con.close();
			cloudfileStatement.close();
			return false;
		}
	}

	public static boolean deleteFile(String fileid) throws SQLException {
		String sql = "DELETE FROM file WHERE file_id=?";

		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();
		PreparedStatement DeletefileStatement = con.prepareStatement(sql);
		DeletefileStatement.setString(1, fileid);
		int rs = DeletefileStatement.executeUpdate();
		if (rs == 1) {
			con.close();
			DeletefileStatement.close();
			return true;
		} else {
			con.close();
			DeletefileStatement.close();
			return false;
		}
	}
}
