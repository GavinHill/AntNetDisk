package me.coding.gavinhill.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.coding.gavinhill.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 控制台输出
		System.out.println("LoginServlet doGet 调用");
		
		// 从JSP页面中读取输入的用户名和密码
		String useraccount = request.getParameter("inputAccount");
		String userpsword = request.getParameter("inputPassword");
		// 设置读取的编码格式
		response.setContentType("text/html;charset=utf-8");
		
		// 用账号和密码进行用户查询,如果查到则返回用户名
		String username = null;
		try {
			username = UserDao.search(useraccount, userpsword);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		// 封装已读取数据
		UserDao.user.setUseraccount(useraccount);
		UserDao.user.setUserpsword(userpsword);
		UserDao.user.setUsername(username);
		
		// 重定向JSP页面
		if (UserDao.user.getUsername() == "error") {
			response.sendRedirect(request.getContextPath() + "/login.jsp");// 匹配失败重新加载页面	
		} else {
			request.setAttribute("username",UserDao.user.getUsername());
			request.getRequestDispatcher("/user.jsp").forward(request, response);// 匹配成功跳转欢迎界面
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		doGet(request, response);
	}

}
