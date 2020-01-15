package club.ccpet.mall.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.ccpet.mall.domain.goods_img.Img;
import club.ccpet.mall.domain.goods_spu_sku.Sku;
import club.ccpet.mall.domain.goods_spu_sku.Spu;
import club.ccpet.mall.domain.goods_spu_sku.SpuSpecification;
import club.ccpet.mall.facade.impl.SpuSkuFacadeImpl;
import club.ccpet.mall.util.ioc.BeanFactory;
import club.ccpet.mall.util.ioc.XmlBeanFactory;

/**
 * Servlet implementation class GoodsDetailsServlet
 */
@WebServlet("/GoodsDetails")
public class GoodsDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spu_noStr = request.getParameter("spu_no");
		long spu_no = Long.parseLong(spu_noStr);
		
		
		BeanFactory bf = XmlBeanFactory.getFactory();
		SpuSkuFacadeImpl ccpf =(SpuSkuFacadeImpl)bf.getBean("SpuSkuFacadeImpl");
		Map<String,?> goosMap=null;
		try {
			goosMap = ccpf.getSkusOfSpu(spu_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("skuArr",(List<Sku>) goosMap.get("skuArr"));
		request.setAttribute("spu", (Spu)goosMap.get("spu"));
		request.setAttribute("sub_full_name", goosMap.get("sub_full_name"));
		request.setAttribute("parent_full_name", goosMap.get("parent_full_name"));
		request.setAttribute("spec_valueArr", (List<String>)goosMap.get("spec_valueArr"));
		request.setAttribute("imgArr", (List<Img>)goosMap.get("imgArr"));
		request.getRequestDispatcher("jsp/goods.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
