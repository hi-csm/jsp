package domain;

public class User {
	private int id;
	private String username;
	private String pwd;
	private float moeny;
	private String address;
	private String phone;
	
	public User() {
		super();
	}
	public User(int id, String username, String pwd, float moeny, String address, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.pwd = pwd;
		this.moeny = moeny;
		this.address = address;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public float getMoeny() {
		return moeny;
	}
	public void setMoeny(float moeny) {
		this.moeny = moeny;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", moeny=" + moeny + ", address="
				+ address + ", phone=" + phone + "]";
	}
	
	

}
