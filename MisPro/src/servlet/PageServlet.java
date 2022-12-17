package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PageBean;
import domain.Product;
import service.ServiceImpl;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet({ "/PageServlet", "/servlet/PageServlet" })
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentPage = request.getParameter("currentPage"); //褰撳墠椤电爜
		String rows = request.getParameter("rows"); //姣忛〉鏄剧ず鐨勬潯鏁�
		String pro_name = request.getParameter("pro_name");
		if(currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if(rows == null || "".equals(rows)) {
			rows = "8";
		}
		ServiceImpl service = new ServiceImpl();
		PageBean<Product> pb = service.findProductBypage(currentPage,rows,pro_name);
		request.setAttribute("pb", pb);
		if(request.getAttribute("deleteCount") == null || "".equals(request.getAttribute("deleteCount"))) { //鍒犻櫎鍟嗗搧浠ｇ爜杞彂锛屼笌鍒嗛〉鏃犲叧銆�
			request.setAttribute("deleteCount",request.getAttribute("deleteCount")); 
		}
		
		request.getRequestDispatcher("product_list.jsp").forward(request, response);         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);           
	}

}
