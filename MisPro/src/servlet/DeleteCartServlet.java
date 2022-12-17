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

@WebServlet("/deleteCartServlet")
public class DeleteCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("pro_id"));
		CartDao cartDat = new CartDaoImpl();
		int count = 0;
		count = cartDat.deleteCart(id);
		if(count > 0){
			List<Cart> ca = null;
			ca = cartDat.findCart();
			req.setAttribute("ca", ca);
			req.getRequestDispatcher("/shopping_buy.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
