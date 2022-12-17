package domain;

public class Order {
	private int id;
	private String username;
	private String pro_name;
	private String number;
	private float moeny;
	
	
	public Order() {
		super();
	}


	public Order(int id, String username, String pro_name, String number, float moeny) {
		super();
		this.id = id;
		this.username = username;
		this.pro_name = pro_name;
		this.number = number;
		this.moeny = moeny;
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


	public String getPro_name() {
		return pro_name;
	}


	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public float getMoeny() {
		return moeny;
	}


	public void setMoeny(float moeny) {
		this.moeny = moeny;
	}


	@Override
	public String toString() {
		return "Order [id=" + id + ", username=" + username + ", pro_name=" + pro_name + ", number=" + number
				+ ", moeny=" + moeny + "]";
	}
	
	

}
