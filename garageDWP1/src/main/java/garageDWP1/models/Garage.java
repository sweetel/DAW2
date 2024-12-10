package garageDWP1.models;

public class Garage {
	private Integer id;
	private String name;
	private String postal_code;
	
	public Garage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Garage(Integer id, String name, String postal_code) {
		super();
		this.id = id;
		this.name = name;
		this.postal_code = postal_code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	

	
}
