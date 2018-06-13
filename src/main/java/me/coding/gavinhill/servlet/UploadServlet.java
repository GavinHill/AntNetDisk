package me.coding.gavinhill.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import me.coding.gavinhill.dao.FileDao;
import me.coding.gavinhill.dao.UserDao;
import me.coding.gavinhill.domain.Cloudfile;
import me.coding.gavinhill.utils.IOUtils;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
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
		System.out.println("UploadServlet doGet 调用");
		
		// 定义一个Map用于存储文件信息
		Map<String, String> map = new HashMap<String, String>();
		boolean isUpload = false; 

		try {
			// 设置文件上传的路径和临时路径
			String uploadPath = this.getServletContext().getRealPath("WEB-INF/upload");
			String tempPath = this.getServletContext().getRealPath("WEB-INF/temp");

			// 1.获取文件上传的工厂类
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置内存的缓存，如果缓存满了就放到临时文件夹中
			factory.setSizeThreshold(1024 * 100);
			// 设置临时目录
			factory.setRepository(new File(tempPath));

			// 2.通过工厂类得到文件上传的核心类
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			// 防止文件中文名乱码
			fileupload.setHeaderEncoding("utf-8");
			// 设置单个文件最大值
			fileupload.setFileSizeMax(1024 * 1024 * 100);
			// 设置总文件最大值
			fileupload.setSizeMax(1024 * 1024 * 200);

			// 3.判断表单的类型
			if (!ServletFileUpload.isMultipartContent(request)) {
				throw new RuntimeException("请使用正确的表单类型");
			}

			// 解析request
			List<FileItem> list = fileupload.parseRequest(request);
			// 遍历list
			for (FileItem item : list) {
				if (item.isFormField()) {
					// 普通字段
					String name = item.getFieldName(); // 返回表单标签的name属性的值
					String value = item.getString("utf-8"); // 将数据流以一个字符串返回
					map.put(name, value);
				} else {
					// 文件上传字段
					String filename = item.getName(); // 获得文件上传字段中的文件名
					map.put("filename", filename);
					String fileuuid = UUID.randomUUID() + "_" + filename;
					map.put("fileuuid", fileuuid);
					String str = Integer.toHexString(fileuuid.hashCode());

					for (char c : str.toCharArray()) {
						uploadPath += "/" + c;
					}
					map.put("filepath", uploadPath);
					
					// 创建文件夹
					new File(uploadPath).mkdirs();
					InputStream in = item.getInputStream();
					OutputStream out = new FileOutputStream(new File(uploadPath, fileuuid));
					IOUtils.In2Out(in, out);
					IOUtils.closeIO(in, out);
					item.delete();// 删除临时文件	
					
					//设置UserID
					map.put("userid", UserDao.user.getUserid());
				}
			}
			
			//测试用，遍历map
			/*
			for (Entry<String, String> entry : map.entrySet()) {
				String key = entry.getKey().toString();
				String value = entry.getValue().toString();
				System.out.println("key=" + key + " value=" + value);
			}*/

			// 封装数据
			Cloudfile uploadcloudfile = new Cloudfile();
			BeanUtils.populate(uploadcloudfile, map);
			
			//使用Date获取当前时间
			Date date = new java.sql.Date(new java.util.Date().getTime());
			uploadcloudfile.setUploaddate(date);
			
			//parentid=0代表根目录，filetype=file代表非文件夹，isshare=0代表未分享
			isUpload = FileDao.upload(uploadcloudfile.getUserid(), uploadcloudfile.getFileuuid(), uploadcloudfile.getFilename(), uploadcloudfile.getFilepath(), "0", "File" , uploadcloudfile.getUploaddate(), "0");
		    } catch (Exception e) {
			    e.printStackTrace();
		    }
			
			// 4.重定向回主页
			if(isUpload) {
				request.setAttribute("parentid", "0");
				request.getRequestDispatcher("GetFileDataServlet").forward(request, response);				
			} else {
				System.out.println("失败");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 测试doGet是否被调用
		System.out.println("Upload doPost被调用");

		doGet(request, response);
	}

}
