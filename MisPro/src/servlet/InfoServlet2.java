package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.impl.Dao;
import domain.Product;
import service.ServiceImpl;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet2")
public class InfoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pro_id = request.getParameter("pro_id");
		ServiceImpl service = new ServiceImpl();
		ArrayList<Product> ap = service.findProductByinfo(pro_id);
		request.setAttribute("ap", ap);
		ProductDao dao = new Dao();
		List<?> list = dao.queryreview(pro_id);
		if(list.size()==0){
			request.setAttribute("msg", "暂无评论");
		}
		request.setAttribute("review", list);
		request.getRequestDispatcher("shopping_buy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
