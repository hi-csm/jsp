package domain;

public class Cart {
	private int id;
	private String pro_name;
	private int pro_count;
	
	
	public Cart() {
		super();
	}


	public Cart(int id, String pro_name, int pro_count) {
		super();
		this.id = id;
		this.pro_name = pro_name;
		this.pro_count = pro_count;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPro_name() {
		return pro_name;
	}


	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}


	public int getPro_count() {
		return pro_count;
	}


	public void setPro_count(int pro_count) {
		this.pro_count = pro_count;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", pro_name=" + pro_name + ", pro_count=" + pro_count + "]";
	}
	
	
	
}
