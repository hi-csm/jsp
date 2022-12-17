package service;

import java.util.ArrayList;

import domain.Order;
import domain.PageBean;
import domain.Product;

public interface ProductService {
	public PageBean<Product> findProductBypage(String _currentPage, String _rows,String pro_name);
	public ArrayList<Product> findProductByinfo(String _pro_id);
	public PageBean<Order> findorderBypage(String _currentPage,String _rows,String username);
	
}
