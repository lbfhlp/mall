package club.ccpet.mall.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import club.ccpet.mall.facade.GoodsAddFacade;
import club.ccpet.mall.facade.impl.GoodsAddFacadeImpl;
import club.ccpet.mall.myException.ImgException;
import club.ccpet.mall.util.ioc.BeanFactory;
import club.ccpet.mall.util.ioc.XmlBeanFactory;

/**
 * Servlet implementation class GoodsAddServlet
 */
public class GoodsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getMethod() == "post") {
			this.doPost(request, response);
		}
		response.sendRedirect(request.getContextPath() + "/jsp/addGoods.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String msg=null;
		
		
		if (request.getMethod() == "get") {
			this.doGet(request, response);
		}
        // 上传时生成的临时文件保存目录
       // String tempPath = request.getServletContext().getRealPath("/WEB-INF/temp");
//        File tmpFile = new File(tempPath);
//        if (!tmpFile.exists()) {
//            // 创建临时目录
//            tmpFile.mkdir();
//        }
       
		System.out.println( request.getRequestURI());
		System.out.println( );
      //tomcat项目根目录
		String basePath=getServletContext().getRealPath("/");//D:\eJavaProject\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\mall\
		System.out.println(basePath);
		FileItemFactory factory = new DiskFileItemFactory();
		// 创建文件上传处理器
		ServletFileUpload upload = new ServletFileUpload(factory);
		//限制每个文件大小3m,单位为kb,1024kb=1k,1024k=1m
		//factory.setSizeThreshold(1024 * 100);// 设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
	    upload.setFileSizeMax(1024*1024);//单个文件大小
		upload.setSizeMax(1024*1024*5);//总大小不超过5m;
		// 开始解析请求信息
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		  BeanFactory bf = XmlBeanFactory.getFactory();
		  GoodsAddFacade ga =(GoodsAddFacade)bf.getBean("GoodsAdd");
		  
		  try {
			  //
			  ga.addGoods(items,basePath);
			  return;
		  }catch (ImgException e) {
			  e.printStackTrace();
			  msg = e.getMessage();
		}catch (Exception e) {
			 e.printStackTrace();
			 msg=e.getCause().getMessage();
		  }
		  request.setAttribute("msg", msg);
		  request.getRequestDispatcher("/common/error.jsp").forward(request, response);
	}

}
