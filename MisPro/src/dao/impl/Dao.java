package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import domain.Order;
import domain.Product;
import domain.Review;
import util.DBManager;

public class Dao implements ProductDao{
	//创建数据库连接工具对象
	DBManager db = new DBManager();
	
	@Override
	public int adminLogin(String user, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from admin where user = ? and password = ?";
		PreparedStatement pstmt = db.prepare(sql, 2);
		ResultSet rs = null;
		try {
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				db.Release();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
	@Override
	public int adminRegister(String user, String password) {
		// TODO Auto-generated method stub
		String sql = "insert into admin values(null,?,?)";
		PreparedStatement pstmt = db.prepare(sql, 2);
		int count = 0;
		try {
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				db.Release();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return count;
	}
	@Override
	public int findAdd(String pro_batch, String pro_name, String pro_hard, String pro_soft, String pro_time,
			int pro_count, String pro_mac_min, String pro_mac_max, String pro_mac_format, String pro_sn_min,
			String pro_sn_max, String pro_sn_format, int pro_code_count, String pro_remark) {
		// TODO Auto-generated method stub
		String sql = "insert into product values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int count = 0;
		PreparedStatement pstmt = db.prepare(sql, 14);
		try {
			pstmt.setString(1,pro_batch);
			pstmt.setString(2,pro_name);
			pstmt.setString(3,pro_hard);
			pstmt.setString(4,pro_soft);
			pstmt.setString(5,pro_time);
			pstmt.setInt(6,pro_count);
			pstmt.setString(7,pro_mac_min);
			pstmt.setString(8,pro_mac_max);
			pstmt.setString(9,pro_mac_format);
			pstmt.setString(10,pro_sn_min);
			pstmt.setString(11,pro_sn_max);
			pstmt.setString(12,pro_sn_format);
			pstmt.setInt(13,pro_code_count);
			pstmt.setString(14,pro_remark);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				db.Release();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	
	@Override
	public int findChange(int pro_id, String pro_batch, String pro_name, String pro_hard, String pro_soft, String pro_time,
			int pro_count, String pro_mac_min, String pro_mac_max, String pro_mac_format, String pro_sn_min,
			String pro_sn_max, String pro_sn_format, int pro_code_count, String pro_remark) {
		// TODO Auto-generated method stub
		String sql = "update product set pro_batch = ?, pro_name = ?, pro_hard = ?, pro_soft = ?, pro_time = ?,"
				+ " pro_count = ?, pro_mac_min = ?, pro_mac_max = ?, pro_mac_format = ?, pro_sn_min = ?, pro_sn_max = ?,"
				+ " pro_sn_format = ?, pro_code_count = ?, pro_remark = ? where pro_id = ?";
		int count = 0;
		PreparedStatement pstmt = db.prepare(sql, 14);
		try {
			pstmt.setString(1,pro_batch);
			pstmt.setString(2,pro_name);
			pstmt.setString(3,pro_hard);
			pstmt.setString(4,pro_soft);
			pstmt.setString(5,pro_time);
			pstmt.setInt(6,pro_count);
			pstmt.setString(7,pro_mac_min);
			pstmt.setString(8,pro_mac_max);
			pstmt.setString(9,pro_mac_format);
			pstmt.setString(10,pro_sn_min);
			pstmt.setString(11,pro_sn_max);
			pstmt.setString(12,pro_sn_format);
			pstmt.setInt(13,pro_code_count);
			pstmt.setString(14,pro_remark);
			pstmt.setInt(15,pro_id);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				db.Release();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	
	@Override
	public int findTotalCount(String pro_name) {
		// TODO Auto-generated method stub
		String sql = "select count(1) from product where 1 = 1 ";
		if(pro_name!=null)
		{
			sql += " and pro_name = "+"'"+pro_name+"'";
		}
		ResultSet rs = db.getResult(sql);
		int totalCount = 0;
		try {
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				db.Release();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return totalCount;
	}

	@Override
	public List<Product> findByPage(int start, int rows,String pro_name) {
		// TODO Auto-generated method stub
		String sql = "select * from product limit ? , ?";
		if(pro_name != null){
			sql = "select * from product WHERE pro_name = ? LIMIT ? , ?";
			PreparedStatement pstmt = db.prepare(sql, 3);
			ResultSet rs = null;
			Product product = null;
			ArrayList<Product> list = new ArrayList<Product>();
			try {
				pstmt.setString(1, pro_name);
				pstmt.setInt(2, start);
				pstmt.setInt(3, rows);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					product = new Product();
					product.setPro_id(rs.getInt("pro_id"));
					product.setPro_batch(rs.getString("pro_batch"));
					product.setPro_name(rs.getString("pro_name"));
					product.setPro_hard(rs.getString("pro_hard"));
					product.setPro_soft(rs.getString("pro_soft"));
					product.setPro_time(rs.getDate("pro_time"));
					product.setPro_count(rs.getInt("pro_count"));
					product.setPro_mac_min(rs.getString("pro_mac_min"));
					product.setPro_mac_max(rs.getString("pro_mac_max"));
					product.setPro_mac_format(rs.getString("pro_mac_format"));
					product.setPro_sn_min(rs.getString("pro_sn_min"));
					product.setPro_sn_max(rs.getString("pro_sn_max"));
					product.setPro_sn_format(rs.getString("pro_sn_format"));
					product.setPro_code_count(rs.getInt("pro_code_count"));
					product.setPro_remark(rs.getString("pro_remark"));
					list.add(product);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			return list;
		}
		else{
			PreparedStatement pstmt = db.prepare(sql, 2);
			ResultSet rs = null;
			Product product = null;
			ArrayList<Product> list = new ArrayList<Product>();
			try {
				pstmt.setInt(1, start);
				pstmt.setInt(2, rows);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					product = new Product();
					product.setPro_id(rs.getInt("pro_id"));
					product.setPro_batch(rs.getString("pro_batch"));
					product.setPro_name(rs.getString("pro_name"));
					product.setPro_hard(rs.getString("pro_hard"));
					product.setPro_soft(rs.getString("pro_soft"));
					product.setPro_time(rs.getDate("pro_time"));
					product.setPro_count(rs.getInt("pro_count"));
					product.setPro_mac_min(rs.getString("pro_mac_min"));
					product.setPro_mac_max(rs.getString("pro_mac_max"));
					product.setPro_mac_format(rs.getString("pro_mac_format"));
					product.setPro_sn_min(rs.getString("pro_sn_min"));
					product.setPro_sn_max(rs.getString("pro_sn_max"));
					product.setPro_sn_format(rs.getString("pro_sn_format"));
					product.setPro_code_count(rs.getInt("pro_code_count"));
					product.setPro_remark(rs.getString("pro_remark"));
					list.add(product);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			return list;
		}
		
	}

	@Override
	public ArrayList<Product> findByInfo(int pro_id) {
		// TODO Auto-generated method stub
		String sql = "select * from product where pro_id = ?";
		PreparedStatement pstmt = db.prepare(sql, 1);
		ResultSet rs = null;
		Product product = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			pstmt.setInt(1, pro_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				product = new Product();
				product.setPro_id(rs.getInt("pro_id"));
				product.setPro_batch(rs.getString("pro_batch"));
				product.setPro_name(rs.getString("pro_name"));
				product.setPro_hard(rs.getString("pro_hard"));
				product.setPro_soft(rs.getString("pro_soft"));
				product.setPro_time(rs.getDate("pro_time"));
				product.setPro_count(rs.getInt("pro_count"));
				product.setPro_mac_min(rs.getString("pro_mac_min"));
				product.setPro_mac_max(rs.getString("pro_mac_max"));
				product.setPro_mac_format(rs.getString("pro_mac_format"));
				product.setPro_sn_min(rs.getString("pro_sn_min"));
				product.setPro_sn_max(rs.getString("pro_sn_max"));
				product.setPro_sn_format(rs.getString("pro_sn_format"));
				product.setPro_code_count(rs.getInt("pro_code_count"));
				product.setPro_remark(rs.getString("pro_remark"));
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public int findDelete(int pro_id) {
		// TODO Auto-generated method stub
		int deleteCount = 0;
		String sql = "delete from product where pro_id = ?";
		PreparedStatement pstmt = db.prepare(sql, 1);
		try {
			pstmt.setInt(1, pro_id);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteCount;
	}
	@Override
	public int addOrder(Order order) {
		String sql = "insert into order_msg values(null,?,?,?,?)";
		PreparedStatement pstmt = db.prepare(sql,4);
		int count = 0;
		try {
			pstmt.setString(1, order.getUsername());
			pstmt.setString(2, order.getPro_name());
			pstmt.setString(3, order.getNumber());
			pstmt.setFloat(4, order.getMoeny());
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				db.Release();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return count;
	}
	@Override
	public List<Review> findreview() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		String sql = "select * from review";
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = db.prepare(sql,0);
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Review(rs.getInt("id"), rs.getString("username"),rs.getString("main"),rs.getInt("true_id")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return list;
	}
	@Override
	public List<Review> queryreview(String id) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		String sql = "select * from review where id = ?";
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = db.prepare(sql,1);
		try {
			pstmt.setInt(1, Integer.parseInt(id));
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Review(rs.getInt("id"), rs.getString("username"),rs.getString("main"),rs.getInt("true_id")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return list;
	}
	@Override
	public void DelReview(String true_id) {
		// TODO Auto-generated method stub
		int count=0;
		String sql = "delete from review where true_id = ? ";
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = db.prepare(sql,1);
		try {
			pstmt.setInt(1, Integer.parseInt(true_id));
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	
}
	@Override
	public void AddReview(int id,String username,String main) {
		// TODO Auto-generated method stub
		String sql = "insert into review values(?,?,?,null)";
		PreparedStatement pstmt = db.prepare(sql, 3);
		System.out.println("成功");
		int count=0;
		try {
			pstmt.setInt(1, id);
			pstmt.setString(2, username);
			pstmt.setString(3,main);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				db.Release();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	@Override
	public List<Order> findOrderByPage(int start, int rows, String username) {
		// TODO Auto-generated method stub
		String sql = "select * from order_msg limit ? , ?";
		if(username != null){
			sql = "select * from order_msg WHERE username = ? LIMIT ? , ?";
			PreparedStatement pstmt = db.prepare(sql, 3);
			ResultSet rs = null;
			Order order = null;
			ArrayList<Order> list = new ArrayList<Order>();
			try {
				pstmt.setString(1, username);
				pstmt.setInt(2, start);
				pstmt.setInt(3, rows);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					order = new Order();
					order.setId(rs.getInt("id"));
					order.setMoeny(rs.getFloat("moeny"));
					order.setNumber(rs.getString("number"));
					order.setPro_name(rs.getString("pro_name"));
					order.setUsername(rs.getString("username"));
					list.add(order);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			return list;
		}
		else{
			PreparedStatement pstmt = db.prepare(sql, 2);
			ResultSet rs = null;
			Order order = null;
			ArrayList<Order> list = new ArrayList<Order>();
			try {
				pstmt.setInt(1, start);
				pstmt.setInt(2, rows);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					order = new Order();
					order.setId(rs.getInt("id"));
					order.setMoeny(rs.getFloat("moeny"));
					order.setNumber(rs.getString("number"));
					order.setPro_name(rs.getString("pro_name"));
					order.setUsername(rs.getString("username"));
					list.add(order);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			return list;
		}
	}
	@Override
	public int findTotalCountOrder(String username) {
		// TODO Auto-generated method stub
		String sql = "select count(1) from order_msg where 1 = 1 ";
		if(username!=null)
		{
			sql += " and username = "+"'"+username+"'";
		}
		ResultSet rs = db.getResult(sql);
		int totalCount = 0;
		try {
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				db.Release();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return totalCount;
	}
}

