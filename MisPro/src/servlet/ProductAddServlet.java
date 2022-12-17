package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.Dao;

/**
 * Servlet implementation class ProductAddServlet
 */
@WebServlet({ "/ProductAddServlet", "/servlet/ProductAddServlet" })
public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pro_batch = request.getParameter("pro_batch");
		String pro_name = request.getParameter("pro_name");
		String pro_hard = request.getParameter("pro_hard");
		String pro_soft = request.getParameter("pro_soft");
		String pro_time = request.getParameter("pro_time");
		String _pro_count = request.getParameter("pro_count");
		String pro_mac_min = request.getParameter("pro_mac_min");
		String pro_mac_max = request.getParameter("pro_mac_max");
		String pro_mac_format = request.getParameter("pro_mac_format");
		String pro_sn_min = request.getParameter("pro_sn_min");
		String pro_sn_max = request.getParameter("pro_sn_max");
		String pro_sn_format = request.getParameter("pro_sn_format");
		String _pro_code_count = request.getParameter("pro_code_count");
		String pro_remark = request.getParameter("pro_remark");
		int count = 0;
		if(!(pro_batch == null || "".equals(pro_batch)
				|| pro_name == null || "".equals(pro_name)
				|| pro_hard == null || "".equals(pro_hard)
				|| pro_soft == null || "".equals(pro_soft)
				|| pro_time == null || "".equals(pro_time)
				|| _pro_count == null || "".equals(_pro_count)
				|| pro_mac_min == null || "".equals(pro_mac_min)
				|| pro_mac_max == null || "".equals(pro_mac_max)
				|| pro_mac_format == null || "".equals(pro_mac_format)
				|| pro_sn_min == null || "".equals(pro_sn_min)
				|| pro_sn_max == null || "".equals(pro_sn_max)
				|| pro_sn_format == null || "".equals(pro_sn_format)
				|| _pro_code_count == null || "".equals(_pro_code_count))
				) {
			int pro_count = Integer.parseInt(_pro_count);
			int pro_code_count = Integer.parseInt(_pro_code_count);
			Dao dao = new Dao();
			count = dao.findAdd(pro_batch, pro_name, pro_hard, pro_soft, 
					pro_time, pro_count, pro_mac_min, pro_mac_max, pro_mac_format, 
					pro_sn_min, pro_sn_max, pro_sn_format, pro_code_count, pro_remark);
			request.setAttribute("add", count);
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
		}
		else {
			request.setAttribute("add", count);
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
		}
	}
}
