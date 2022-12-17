package dao;

import java.util.ArrayList;

import domain.Order;
import domain.User;

public interface UserDao {
	//�û���¼
	public int userLogin(String username, String pwd);
	//�û�ע��
	public int userRegister(String username, String pwd);
	public User queryMoeny(String username, String pwd);
	public int updateUser(float moeny, int id);
	public ArrayList<User> findUser();
	public ArrayList<User> queryUserByname(String username);
	public User querybyname(String username);
	public void Updateuser(String username,String address,String phone);
	public void addUser (User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public ArrayList<Order> findorder();
	public void deleteorder(int id);
}
