package domain;

public class Review {
	private int id;
	private String username;
	private String main;
	private int true_id;
	
	
	public Review() {
		super();
	}
	public Review(int id, String username, String main,int true_id) {
		super();
		this.id = id;
		this.username = username;
		this.main = main;
		this.true_id = true_id;
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
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	
	public int getTrue_id() {
		return true_id;
	}
	public void setTrue_id(int true_id) {
		this.true_id = true_id;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", username=" + username + ", main=" + main + ", true_id=" + true_id + "]";
	}

	

}
