package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import service.ServiceImpl;


@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PayServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pro_id = request.getParameter("pro_id");
		String moeny = request.getParameter("moeny");
		ServiceImpl service = new ServiceImpl();
		ArrayList<Product> ap = service.findProductByinfo(pro_id);
		
		request.setAttribute("ap", ap);
		request.setAttribute("moeny", moeny);
		
		request.getRequestDispatcher("shopping_pay.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
