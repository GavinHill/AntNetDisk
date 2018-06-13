package me.coding.gavinhill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.coding.gavinhill.utils.IOUtils;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadServlet() {
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
		System.out.println("DownloadServlet doGet 调用");

		// 判断是否是文件夹
		String filetype = request.getParameter("filetype");
		String fileid = request.getParameter("fileid");
		
		if (filetype.equals("Folder")) {
			request.setAttribute("parentid", fileid);
			request.getRequestDispatcher("/GetFileDataServlet").forward(request, response);
		} else {
			// 非文件夹，进行下载操作
			// 获取要下载的文件的名称和路径
			String fileuuid = request.getParameter("fileuuid");
			String filepath = request.getParameter("filepath");

			// 解决获得中文参数的乱码
			fileuuid = new String(fileuuid.getBytes("ISO8859-1"), "UTF-8");

			// 获得请求头中的User-Agent
			String agent = request.getHeader("User-Agent");
			// 根据不同浏览器进行不同的编码
			String filenameEncoder = "";
			if (agent.contains("MSIE")) {
				// IE浏览器
				filenameEncoder = URLEncoder.encode(fileuuid, "utf-8");
				filenameEncoder = filenameEncoder.replace("+", " ");
			} else {
				// 其它浏览器
				filenameEncoder = URLEncoder.encode(fileuuid, "utf-8");
			}

			// 要下载的这个文件类型
			response.setContentType(this.getServletContext().getMimeType(fileuuid));
			// 告诉客户端该文件以附件形式打开
			response.setHeader("Content-Disposition", "attachment;filename=" + fileuuid);

			// 获取文件的绝对路径
			String downloadpath = filepath + "/" + fileuuid;
			// 获取文件的输入流
			InputStream in = new FileInputStream(downloadpath);
			// 获取文件的输出流
			OutputStream out = response.getOutputStream();

			IOUtils.In2Out(in, out);
			IOUtils.closeIO(in, out);
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
