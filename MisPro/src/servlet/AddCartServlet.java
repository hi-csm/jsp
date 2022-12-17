package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import domain.Cart;

@WebServlet("/addCartServlet")
public class AddCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String pro_name = req.getParameter("pro_name");
		int pro_count = Integer.parseInt(req.getParameter("pro_count"));
		Cart cart = new Cart(id,pro_name,pro_count);
		int count = 0;
		CartDao carts = new CartDaoImpl();
		List<Cart> ca = null;
		count = carts.addCart(cart);
		ca = carts.findCart();
		req.setAttribute("ca", ca);
		if(count > 0){
			req.getRequestDispatcher("/shopping_buy.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("/shopping_buy.jsp").forward(req, resp);
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}
}
