package me.coding.gavinhill.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.coding.gavinhill.dao.ShareFileDao;
import me.coding.gavinhill.domain.Cloudfile;

/**
 * Servlet implementation class getShareFileServlet
 */

public class GetShareFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetShareFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 控制台输出
		System.out.println("GetShareFileServlet doGet 调用");
		
		//取到选择类型select：0为我的分享，1为分享给我
		String Str = request.getParameter("select");		
		
		// 用于得到已封装好的List
		List<String> sfilelist = new ArrayList<String>();
		List<Cloudfile> filelist = new ArrayList<Cloudfile>();		
		
		try {
			sfilelist = ShareFileDao.getSharefileID(Str);
			for(int i = 0 ; i < sfilelist.size() ; i++) {
				filelist.add(ShareFileDao.getShareFileByID(sfilelist.get(i)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("filelist", filelist);
		request.getRequestDispatcher("/share.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
