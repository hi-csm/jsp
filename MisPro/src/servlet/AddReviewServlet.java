package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.impl.Dao;
import domain.PageBean;
import domain.Product;
import domain.Review;
import service.ServiceImpl;

/**
 * Servlet implementation class AddReviewServlet
 */
@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		ServiceImpl service = new ServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		String main = request.getParameter("main");
		Review review = new Review();
		review.setId(id);
		review.setMain(main);
		review.setUsername(username);
		ProductDao dao = new Dao();
		dao.AddReview(id, username, main);
		PageBean<Product> product = service.findProductBypage("1", "8",null);
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("shopping_mall.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
