package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.UserDao;
import domain.Order;
import domain.User;
import util.DBManager;

public class UserDaoImpl implements UserDao {

	//�������ݿ����ӹ��߶���
		DBManager db = new DBManager();
		
		@Override
		public int userLogin(String username, String pwd) {
			// TODO Auto-generated method stub
			String sql = "select * from user where username = ? and pwd = ?";
			PreparedStatement pstmt = db.prepare(sql, 2);
			ResultSet rs = null;
			try {
				pstmt.setString(1, username);
				pstmt.setString(2, pwd);
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
		public int userRegister(String username, String pwd) {
			// TODO Auto-generated method stub
			String sql = "insert into user values(null,?,?,null,null,null)";
			PreparedStatement pstmt = db.prepare(sql, 2);
			int count = 0;
			try {
				pstmt.setString(1, username);
				pstmt.setString(2, pwd);
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
		public User queryMoeny(String username, String pwd) {
			// TODO Auto-generated method stub
			String sql = "select * from user where username = ? and pwd = ?";
			PreparedStatement pstmt = db.prepare(sql, 2);
			ResultSet rs = null;
			try {
				pstmt.setString(1, username);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
				if(rs.next()){
					return new User(rs.getInt("id"), rs.getString("username"),rs.getString("pwd"),rs.getFloat("moeny"),
							rs.getString("address"),rs.getString("phone"));
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
			return null;
		}
		@Override
		public int updateUser(float balance, int id) {
			String sql = "UPDATE user SET moeny=? where id=?";
			int count = 0;
			PreparedStatement pstmt = db.prepare(sql, 2);
			try {
				pstmt.setFloat(1,balance);
				pstmt.setInt(2,id);
				count = pstmt.executeUpdate();
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				try {
					db.Release();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return count;
		}
		@Override
		public ArrayList<User> findUser() {
			String sql = "select * from user";
			PreparedStatement pstmt = db.prepare(sql, 0);
			ResultSet rs = null;
			ArrayList<User> list = new ArrayList<User>();
			try {
				rs = pstmt.executeQuery();
				while(rs.next()){
					list.add(new User(rs.getInt("id"), rs.getString("username"),rs.getString("pwd"),rs.getFloat("moeny"),
							rs.getString("address"),rs.getString("phone")));
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
			return list;
		}
		@Override
		public void addUser(User user) {
			// TODO Auto-generated method stub
			String sql = "insert into user values(null,?,?,?,?,?)";
			PreparedStatement pstmt = db.prepare(sql, 5);
			int count = 0;
			try {
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPwd());
				pstmt.setFloat(3, user.getMoeny());
				pstmt.setString(4, user.getAddress());
				pstmt.setString(5, user.getPhone());
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
		}
		@Override
		public void updateUser(User user) {
			// TODO Auto-generated method stub
			String sql = "UPDATE user SET pwd=?,moeny=?,address=?,phone=? where id=?";
			int count = 0;
			PreparedStatement pstmt = db.prepare(sql, 5);
			try {
				pstmt.setString(1, user.getPwd());
				pstmt.setFloat(2, user.getMoeny());
				pstmt.setString(3, user.getAddress());
				pstmt.setString(4, user.getPhone());
				pstmt.setInt(5,user.getId());
				count = pstmt.executeUpdate();
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				try {
					db.Release();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		@Override
		public void deleteUser(int id) {
			// TODO Auto-generated method stub
			String sql = "DELETE FROM user where id = ?";
			int count = 0;
			PreparedStatement pstmt = db.prepare(sql, 1);
			try {
				pstmt.setInt(1, id);
				count = pstmt.executeUpdate();
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				try {
					db.Release();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		@Override
		public User querybyname(String username) {
			// TODO Auto-generated method stub
			String sql = "select * from user where username = ?";
			PreparedStatement pstmt = db.prepare(sql, 1);
			ResultSet rs = null;
			try {
				pstmt.setString(1, username);
				rs = pstmt.executeQuery();
				if(rs.next()){
					return new User(rs.getInt("id"), rs.getString("username"),rs.getString("pwd"),rs.getFloat("moeny"),
							rs.getString("address"),rs.getString("phone"));
				}
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
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return null;
		}
		@Override
		public void Updateuser(String username, String address, String phone) {
			// TODO Auto-generated method stub
			String sql = "UPDATE user set address=?,phone=? where username = ?";
			PreparedStatement pstmt = db.prepare(sql, 2);
			int count=0;
			try {
				pstmt.setString(3, username);
				pstmt.setString(1, address);
				pstmt.setString(2,phone);
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
		public ArrayList<Order> findorder() {
			// TODO Auto-generated method stub
			String sql = "select * from order_msg";
			PreparedStatement pstmt = db.prepare(sql, 0);
			ResultSet rs = null;
			ArrayList<Order> list = new ArrayList<Order>();
			try {
				rs = pstmt.executeQuery();
				while(rs.next()){
					list.add(new Order(rs.getInt("id"),rs.getString("username"),rs.getString("pro_name"),rs.getString("number"),rs.getFloat("moeny")));
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
			return list;
		}
		@Override
		public void deleteorder(int id) {
			// TODO Auto-generated method stub
			String sql = "DELETE FROM order_msg where id = ?";
			int count = 0;
			PreparedStatement pstmt = db.prepare(sql, 1);
			try {
				pstmt.setInt(1, id);
				count = pstmt.executeUpdate();
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				try {
					db.Release();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		@Override
		public ArrayList<User> queryUserByname(String username) {
			// TODO Auto-generated method stub
			String sql = "select * from user where username = ?";
			PreparedStatement pstmt = db.prepare(sql, 1);
			ResultSet rs = null;
			ArrayList<User> list = new ArrayList<User>();
			try {
				pstmt.setString(1, username);
				rs = pstmt.executeQuery();
				while(rs.next()){
					list.add(new User(rs.getInt("id"), rs.getString("username"),rs.getString("pwd"),rs.getFloat("moeny"),
							rs.getString("address"),rs.getString("phone")));
				}
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
				if(rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return list;
		}
}
