package spring;

public class Client {
	private String id;
	private String fullName;

	public Client(String sId, String sName) {
		id=sId;
		fullName=sName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
