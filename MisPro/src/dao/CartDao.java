package dao;

import java.util.List;

import domain.Cart;

public interface CartDao {
	
	public int addCart(Cart cart);
	public int deleteCart(int id);
	public List<Cart> findCart();
	public List<Cart> findByCart(int id);
}
