package me.coding.gavinhill.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.coding.gavinhill.dao.FileDao;
import me.coding.gavinhill.dao.ShareFileDao;
import me.coding.gavinhill.dao.UserDao;

/**
 * Servlet implementation class FileManageServlet
 */
public class FileManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileManageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 控制台输出
		System.out.println("FileManageServlet doGet 调用");

		// 根据传递的结果执行不同的方法
		String foldername = request.getParameter("foldername");
		String managedorder = request.getParameter("managedorder");
		String delid = request.getParameter("delid");
		String fileid = request.getParameter("fileid");
		
		System.out.println(managedorder);
		if (managedorder.equals("newfolder")) {
			// 取到了foldername说明是新建文件夹
			String folderuuid = UUID.randomUUID() + "_" + foldername;
			Date createdate = new java.sql.Date(new java.util.Date().getTime());
			String folderpath = this.getServletContext().getRealPath("WEB-INF/upload");
			boolean isNewFolder = false;
			try {
				isNewFolder = FileDao.addNewFolder(UserDao.user.getUserid(), folderuuid, foldername, folderpath, "0",
						"Folder", createdate, "0");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (isNewFolder) {
				request.setAttribute("parentid", "0");
				request.getRequestDispatcher("/GetFileDataServlet").forward(request, response);
				System.out.println("添加文件夹成功");
			} else {
				System.out.println("添加文件夹失败");
			}
		} else if (managedorder.equals("delete")) {
			// 删除操作
			boolean isDelFile = false;
			try {
				isDelFile = FileDao.deleteFile(delid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (isDelFile) {
				request.setAttribute("parentid", "0");
				request.getRequestDispatcher("/GetFileDataServlet").forward(request, response);
				System.out.println("删除文件夹成功");
			} else {
				System.out.println("删除文件夹失败");
			}
		} else if (managedorder.equals("share")) {
			// 分享操作
			boolean isshare = false;
			try {
				isshare = ShareFileDao.addSharefile(fileid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (isshare) {
				request.setAttribute("parentid", "0");
				request.getRequestDispatcher("/GetFileDataServlet").forward(request, response);
				System.out.println("分享文件成功");
			} else {
				System.out.println("分享文件失败");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FileManageServlet doPost调用");
		doGet(request, response);
	}

}
