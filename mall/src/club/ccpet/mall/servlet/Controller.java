package club.ccpet.mall.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String urlString  = req.getRequestURI();
		int begin = urlString.lastIndexOf("/");
		int end = urlString.lastIndexOf(".do");
		String method = urlString.substring(begin+1,end);
		System.out.println(method);
		switch (method) {
		case "parent":
			req.getRequestDispatcher("/GCPage").forward(req, resp);
			break;
		case "sub":
			req.getRequestDispatcher("/GSCServlet").forward(req, resp);
			break;
		case "GoodsAdd":
			req.getRequestDispatcher("/GoodsAdd").forward(req, resp);
			break;
		case "GoodsDetails":
			req.getRequestDispatcher("/GoodsDetails").forward(req, resp);
			break;
		default:
			break;
		}
	}

}
