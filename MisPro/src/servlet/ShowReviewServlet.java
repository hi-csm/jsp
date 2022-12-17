package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dao.impl.Dao;

/**
 * Servlet implementation class ShowReviewServlet
 */
@WebServlet("/ShowReviewServlet")
public class ShowReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pro_id = request.getParameter("pro_id");
		String username=request.getParameter("username");
		ProductDao dao = new Dao();
		List<?> list = dao.queryreview(pro_id);
		if(list.size()==0){
			request.setAttribute("msg", "暂无评论");
		}
		request.setAttribute("review", list);
		request.setAttribute("username", username);
		request.setAttribute("pro_id", pro_id);
		request.getRequestDispatcher("showreview.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
