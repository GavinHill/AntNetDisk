package me.coding.gavinhill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.coding.gavinhill.domain.Cloudfile;
import me.coding.gavinhill.utils.DataSourceUtils;

public class ShareFileDao {
	public static List<String> getSharefileID(String select) throws SQLException {

		List<String> sfileidlist = new ArrayList<String>();

		// 设置SQL语句
		String sql = null;

		if (select.equals("0")) {
			sql = "SELECT file_id FROM share WHERE sou_account=?";
		} else {
			sql = "SELECT file_id FROM share WHERE dir_account=?";
		}

		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();
		// 获得语句执行平台并设置占位符(?)
		PreparedStatement sharefileStatement = con.prepareStatement(sql);
		sharefileStatement.setString(1, UserDao.user.getUseraccount());
		ResultSet rs = sharefileStatement.executeQuery();

		while (rs.next()) {
			// 封装数据
			String sfileid = rs.getString("file_id");
			sfileidlist.add(sfileid);
		}

		return sfileidlist;
	}

	public static Cloudfile getShareFileByID(String fileid) throws SQLException {
		Cloudfile cloudfile = new Cloudfile();

		String sql = "SELECT * FROM file WHERE file_id=?";

		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();

		// 获得语句执行平台并设置占位符(?)
		PreparedStatement getFileDataStatement = con.prepareStatement(sql);
		getFileDataStatement.setString(1, fileid);
		ResultSet rs = getFileDataStatement.executeQuery();
		if (rs.next()) {
			cloudfile.setFileid(rs.getString("file_id"));
			cloudfile.setFileuuid(rs.getString("file_uuid"));
			cloudfile.setFilename(rs.getString("file_name"));
			cloudfile.setFilepath(rs.getString("file_path"));
			cloudfile.setParentid(rs.getString("parent_id"));
			cloudfile.setFiletype(rs.getString("file_type"));
			cloudfile.setUploaddate(rs.getDate("upload_date"));
			cloudfile.setIsshare(rs.getString("isshare"));
		}
		return cloudfile;
	}

	public static boolean addSharefile(String fileid) throws SQLException {
		String sql = "INSERT INTO share(file_id, sou_account, dir_account) VALUES(?, ?, ?)";
		// 获取数据连接池连接
		Connection con = DataSourceUtils.getConn();

		// 获得语句执行平台并设置占位符(?)
		PreparedStatement cloudfileStatement = con.prepareStatement(sql);
		cloudfileStatement.setString(1, fileid);
		cloudfileStatement.setString(2, "1");
		cloudfileStatement.setString(3, "2");
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
}
