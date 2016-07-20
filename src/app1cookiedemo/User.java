package app1cookiedemo;

public class User {

	private String name;
	private String psd;

	public User(String name, String psd) {
		super();
		this.name = name;
		this.psd = psd;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", psd=" + psd + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

}
