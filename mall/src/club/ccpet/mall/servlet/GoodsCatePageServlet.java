package club.ccpet.mall.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.ccpet.mall.domain.goods_category.Sub_category;
import club.ccpet.mall.facade.GoodsAddFacade;
import club.ccpet.mall.facade.impl.SpuSkuFacadeImpl;
import club.ccpet.mall.util.ioc.BeanFactory;
import club.ccpet.mall.util.ioc.XmlBeanFactory;



/**
 * Servlet implementation class CreatFL_jspServlet
 * 父级分类页面.
 */
@WebServlet("/GCPage")
public class GoodsCatePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		//CreateCatePageFacadeImpl ccpf = new CreateCatePageFacadeImpl();

		  BeanFactory bf = XmlBeanFactory.getFactory();
		  SpuSkuFacadeImpl ccpf =(SpuSkuFacadeImpl)bf.getBean("SpuSkuFacadeImpl");
		List<Object> list =null;
		try {
			list = ccpf.CreateParentPage(type);
		} catch (SQLException e) {
			System.out.println("获取不到信息");
		}
		
		request.setAttribute("subArr", list.get(0));
		request.setAttribute("subSpuMap", list.get(1));
		request.setAttribute("spuImgMap", list.get(2));
		request.getRequestDispatcher("/jsp/fl.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
