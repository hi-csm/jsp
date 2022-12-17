package dao;

import java.util.List;

import domain.Order;
import domain.Product;
import domain.Review;

public interface ProductDao {
	public int adminLogin(String user, String password);
	public int adminRegister(String user, String password);
	public int findAdd(String pro_batch, String pro_name, String pro_hard, String pro_soft, String pro_time,
			int pro_count, String pro_mac_min, String pro_mac_max, String pro_mac_format, String pro_sn_min,
			String pro_sn_max, String pro_sn_format, int pro_code_count, String pro_remark);
	public int findChange(int pro_id, String pro_batch, String pro_name, String pro_hard, String pro_soft, String pro_time,
			int pro_count, String pro_mac_min, String pro_mac_max, String pro_mac_format, String pro_sn_min,
			String pro_sn_max, String pro_sn_format, int pro_code_count, String pro_remark);
	public int findTotalCount(String pro_name);
	public int findTotalCountOrder(String username);
	public List<Product> findByPage(int start,int rows,String pro_name);
	public List<Product> findByInfo(int pro_id);
	public int findDelete(int pro_id);
	public int addOrder(Order order);
	public List<Review> findreview();
	public List<Review> queryreview(String id);
	public void DelReview(String true_id);
	public void AddReview(int id,String username,String main);
	public List<Order> findOrderByPage(int start,int rows,String username);
}
