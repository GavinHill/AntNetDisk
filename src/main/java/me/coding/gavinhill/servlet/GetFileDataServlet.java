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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用于得到已封装好的List
		List<Cloudfile> filelist = new ArrayList<>();
		try {
			filelist = FileDao.getFileData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//发送给前台JSP
		request.setAttribute("filelist", filelist);
		request.getRequestDispatcher("/file.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
