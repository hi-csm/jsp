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
@WebServlet({ "/UserLogin", "/servlet/UserLogin" })
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String   url = request.getHeader("referer");
		url = url.substring(url.lastIndexOf("/")+1);  //��ȡ�ύҳ����ļ����ơ�
		UserDao dao = new UserDaoImpl();
		User user =  new User();
		HttpSession session = request.getSession();
		int count = 0; //����ִ�н��
		if(!(username == null || "".equals(username) || pwd == null || "".equals(pwd))) {
			if("user_login.jsp".equals(url)) { //����ǵ�½ҳ�������е�½��
				count = dao.userLogin(username, pwd);
				if(count >= 1) {
					user = (User) dao.queryMoeny(username, pwd);
					session.setAttribute("username", user);//�û����ƴ���session
					ProductService service = new ServiceImpl();
					PageBean<Product> product = service.findProductBypage("1", "8",null);
					request.setAttribute("product", product);
					request.getRequestDispatcher("shopping_mall.jsp").forward(request, response); 
				}
				else {
					request.setAttribute("count", count);
					request.getRequestDispatcher(url).forward(request, response); //ʧ��ת����ԭ����¼ҳ��
				}
			}
			if("user_register.jsp".equals(url)) { //�����ע��ҳ��������ע�ᡣ
				count = dao.userRegister(username, pwd);
				if(count >= 1) {
					request.setAttribute("count", count);
					request.getRequestDispatcher(url).forward(request, response);//ע��ת����ԭ��ע��ҳ�棨ǰ��el���ʽ�ж�ע��ɹ���������
				}
				else {
					request.setAttribute("count", count);
					request.getRequestDispatcher(url).forward(request, response); //ʧ��ת����ԭ��ע��ҳ��
				}
			}
		}
		else {
			request.setAttribute("count", count);
			request.getRequestDispatcher(url).forward(request, response);//ʧ��ת����ԭҳ��
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
