package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CartDao;
import domain.Cart;
import domain.User;
import util.DBManager;

public class CartDaoImpl implements CartDao {

	DBManager db = new DBManager();
	
	@Override
	public int addCart(Cart cart) {
		String sql = "insert into cart values(?,?,?)";
		PreparedStatement pstmt = db.prepare(sql, 3);
		int count = 0;
		try {
			pstmt.setInt(1, cart.getId());
			pstmt.setString(2, cart.getPro_name());
			pstmt.setInt(3, cart.getPro_count());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			try {
				db.Release();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		}
		return count;
	}

	@Override
	public int deleteCart(int id) {
		int deleteCount = 0;
		String sql = "delete from cart where id = ?";
		PreparedStatement pstmt = db.prepare(sql, 1);
		try {
			pstmt.setInt(1, id);
			deleteCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteCount;
		

	}

	@Override
	public List<Cart> findCart() {
		String sql = "select * from cart";
		PreparedStatement pstmt = db.prepare(sql, 0);
		ResultSet rs = null;
		ArrayList<Cart> cart = new ArrayList<>();
		try {
			rs = pstmt.executeQuery();
			while(rs.next()){
				cart.add(new Cart(rs.getInt("id"), rs.getString("pro_name"),rs.getInt("pro_count")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				db.Release();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cart;
	}

	@Override
	public List<Cart> findByCart(int id) {
		String sql = "select * from cart where id=?";
		PreparedStatement pstmt = db.prepare(sql, 1);
		ResultSet rs = null;
		ArrayList<Cart> cart = new ArrayList<>();
		try {
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				cart.add(new Cart(rs.getInt("id"), rs.getString("pro_name"),rs.getInt("pro_count")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return cart;
	}



}
