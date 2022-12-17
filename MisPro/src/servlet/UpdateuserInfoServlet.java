package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;

/**
 * Servlet implementation class UpdateuserInfoServlet
 */
@WebServlet("/UpdateuserInfoServlet")
public class UpdateuserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateuserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		UserDao dao = new UserDaoImpl();
		User user = dao.querybyname(username);
		request.setAttribute("username", user.getUsername());
		request.setAttribute("address", user.getAddress());
		request.setAttribute("phone", user.getPhone());
		String username1 = request.getParameter("username");
		String address1 = request.getParameter("address");
		String phone1 = request.getParameter("phone");
		dao.Updateuser(username1, address1, phone1);
		request.getRequestDispatcher("Updateuser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
