package club.ccpet.mall.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import club.ccpet.mall.daoImpl.GoodsImgDaoImpl;

/**
 * Servlet implementation class ImgTestServlet
 */
@WebServlet("/ImgTestServlet")
public class ImgTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  List<String> list=new ArrayList<String>();
		          String filename=GoodsImgDaoImpl.getPhotoNewName();
		          ServletContext servletContext=null;
		         servletContext=request.getSession().getServletContext();
		         //数据库中存储格式:/webTest/imgs/***.jpg
		         //第一步:获取页面上上传的图片资源
		         List<FileItem> items=GoodsImgDaoImpl.getRequsetFileItems(request,servletContext);
		         boolean isLoadToSQL=false;
		          for(FileItem item:items) {
		        	  //图片格式
		             if(!item.isFormField()){
		                 //判断后缀名是否是jpg
		                 if(GoodsImgDaoImpl.isGif(item)) {
		                      isLoadToSQL=GoodsImgDaoImpl.saveFile(item,filename);
		                 }else {
		                      System.out.println("后缀格式有误，保存文件失败");
		                  }
		             }
		          }
	}  
}
