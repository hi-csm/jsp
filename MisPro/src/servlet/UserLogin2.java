package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.Product;
import domain.User;
import service.ProductService;
import service.ServiceImpl;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/UserLogin2")
public class UserLogin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User users = (User) session.getValue("username");
		UserDao dao = new UserDaoImpl();
		User user = (User) dao.queryMoeny(users.getUsername(), users.getPwd());
		session.setAttribute("username", user);
		ProductService service = new ServiceImpl();
		PageBean<Product> product = service.findProductBypage("1", "8",null);
		request.setAttribute("product", product);
		request.getRequestDispatcher("shopping_mall.jsp").forward(request, response); 
		response.sendRedirect("shopping_mall.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
