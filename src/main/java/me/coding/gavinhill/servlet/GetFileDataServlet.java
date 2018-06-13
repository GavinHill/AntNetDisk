package me.coding.gavinhill.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.coding.gavinhill.dao.FileDao;
import me.coding.gavinhill.domain.Cloudfile;

/**
 * Servlet implementation class GetFileDataServlet
 */

public class GetFileDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetFileDataServlet() {
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
		System.out.println("GetFileDataServlet doGet 调用");

		// 用于得到已封装好的List
		List<Cloudfile> filelist = new ArrayList<>();

		// 判断一下传入的参数
		String requeststr = request.getParameter("parentid");

		if (requeststr != null) {
			try {
				filelist = FileDao.getFileData(requeststr, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 未取到Parameter parentid则取Parameter filename
		if (requeststr == null) {
			requeststr = request.getParameter("filename");

			try {
				filelist = FileDao.getFileData(null, requeststr);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 未取到Parameter filename则取Attribute parentid
		if (requeststr == null) {
			requeststr = request.getAttribute("parentid").toString();
			try {
				filelist = FileDao.getFileData(requeststr, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 发送给前台JSP
		request.setAttribute("filelist", filelist);
		request.getRequestDispatcher("/file.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
