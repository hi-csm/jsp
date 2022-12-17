package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.Dao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet({ "/AdminLogin", "/servlet/AdminLogin" })
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String   url=request.getHeader("referer");
		url = url.substring(url.lastIndexOf("/")+1);  //��ȡ�ύҳ����ļ����ơ�
		Dao dao = new Dao();
		HttpSession session = request.getSession();
		int count = 0; //����ִ�н��
		if(!(user == null || "".equals(user) || password == null || "".equals(password))) {
			if("admin_login.jsp".equals(url)) { //����ǵ�½ҳ�������е�½��
				count = dao.adminLogin(user, password);
				if(count >= 1) {
					session.setAttribute("user", user);
					response.sendRedirect("product_list.jsp");
				}
				else {
					request.setAttribute("count", count);
					request.getRequestDispatcher(url).forward(request, response);
				}
			}
			if("login.jsp".equals(url)) { //�����ע��ҳ��������ע�ᡣ
				count = dao.adminRegister(user, password);
				if(count >= 1) {
					request.setAttribute("count", count);
					request.getRequestDispatcher(url).forward(request, response);
				}
				else {
					request.setAttribute("count", count);
					request.getRequestDispatcher(url).forward(request, response);
				}
			}
		}
		else {
			request.setAttribute("count", count);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
