package me.coding.gavinhill.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.coding.gavinhill.dao.UserDao;
import me.coding.gavinhill.domain.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 从JSP页面中读取输入的账号、密码、姓名、手机
		String useraccount = request.getParameter("inputAccount");
		String userpsword =request.getParameter("inputPassword");
		String username =request.getParameter("inputName");
		String usertel =request.getParameter("inputTel");
		// 设置读取的编码格式
		response.setContentType("text/html;charset=utf-8");
		
		// 封装已读取数据
		User user = new User();
		user.setUseraccount(useraccount);
		user.setUserpsword(userpsword);
		user.setUsername(username);
		user.setUsertel(usertel);
		
		// 用账号查询
		boolean isExist = false;// 判断是否匹配成功
		boolean isReg = false;//判断是否注册成功
		try {
			isExist = UserDao.search(user.getUseraccount());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 重定向JSP页面
		if (isExist) {
			// 匹配成功说明账号已有进行提示并重新注册
			request.setAttribute("isRegisterSuccess", "fail");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} else{
			//匹配失败进行注册操作
			try {
				isReg = UserDao.register(user.getUseraccount(), user.getUserpsword(),user.getUsername(),user.getUsertel());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(isReg) {
			System.out.println("注册成功");
		    // 提示注册成功
			}
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
