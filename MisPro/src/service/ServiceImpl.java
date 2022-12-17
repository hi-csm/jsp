package service;

import java.util.ArrayList;
import java.util.List;

import dao.impl.Dao;
import domain.Order;
import domain.PageBean;
import domain.Product;

public class ServiceImpl implements ProductService{
	Dao dao = new Dao();
	@Override
	public PageBean<Product> findProductBypage(String _currentPage, String _rows,String pro_name) {
		int currentPage = Integer.parseInt(_currentPage);
		int rows = Integer.parseInt(_rows);
		//����PageBean����
		PageBean<Product> pb = new PageBean<Product>();
		//���ò���
		pb.setCurrentPage(currentPage);
		pb.setRows(rows);
		//����dao��ѯ�ܼ�¼��
		int totalCount = dao.findTotalCount(pro_name);
		pb.setTotalCount(totalCount);
		//����dao��ѯlist����
		int start = (currentPage -1 ) * rows;
		List<Product> list = dao.findByPage(start, rows,pro_name);
		pb.setList(list);
		//������ҳ��
		int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount / rows) +1;
		pb.setTotalPage(totalPage);
		return pb;
	}
	@Override
	public ArrayList<Product> findProductByinfo(String _pro_id) {
		// TODO Auto-generated method stub
		int pro_id = Integer.parseInt(_pro_id);
		ArrayList<Product> list = dao.findByInfo(pro_id);
		return list;
	}
	@Override
	public PageBean<Order> findorderBypage(String _currentPage, String _rows, String username) {
		// TODO Auto-generated method stub
		int currentPage = Integer.parseInt(_currentPage);
		int rows = Integer.parseInt(_rows);
		//����PageBean����
		PageBean<Order> pb = new PageBean<Order>();
		//���ò���
		pb.setCurrentPage(currentPage);
		pb.setRows(rows);
		//����dao��ѯ�ܼ�¼��
		int totalCount = dao.findTotalCountOrder(username);
		pb.setTotalCount(totalCount);
		//����dao��ѯlist����
		int start = (currentPage -1 ) * rows;
		List<Order> list = dao.findOrderByPage(start, rows, username);
		pb.setList(list);
		//������ҳ��
		int totalPage = (totalCount % rows) == 0 ? totalCount/rows : (totalCount / rows) +1;
		pb.setTotalPage(totalPage);
		return pb;
	}
}
