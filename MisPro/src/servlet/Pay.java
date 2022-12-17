package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.Dao;
import dao.impl.UserDaoImpl;
import domain.Order;
import domain.User;
import java.io.IOException;

@WebServlet("/pay")
public class Pay extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Pay() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String Pro_name = request.getParameter("Pro_name");
		String number = request.getParameter("number");
		float moeny = Float.parseFloat(request.getParameter("moeny"));
		String zf = request.getParameter("zf");
		
		if(zf.equals("a")){
			User user = (User) request.getSession().getAttribute("username");
			float moeny1 = user.getMoeny();
			if(moeny1 >= moeny){
				@SuppressWarnings("unused")
				int count = 0;
				int i = 0;
				count = new Dao().addOrder(new Order(0,user.getUsername(),Pro_name,number,moeny));
				float Balance = moeny1 -moeny;
				i = new UserDaoImpl().updateUser(Balance, user.getId());
				if(i > 0){
					request.setAttribute("Pro_name1", Pro_name);
					request.setAttribute("number", number);
					request.setAttribute("moeny1", moeny);
					request.getRequestDispatcher("shopping_order.jsp").forward(request, response);
				}
				
			}else{
				request.setAttribute("error1","���㣡��");
				request.getRequestDispatcher("shopping_pay.jsp").forward(request, response);
			}
		}else{
			response.sendRedirect("https://www.ispay.cn/");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
