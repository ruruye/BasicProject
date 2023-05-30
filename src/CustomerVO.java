
public class CustomerVO {
	private String id;
	private String pw;
	private String name;
	private String telno;
	private String email;
	private String add;

	public CustomerVO() {
	}

	public CustomerVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public CustomerVO(String id, String pw, String name, String telno, String email, String add) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.telno = telno;
		this.email = email;
		this.add = add;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s", id, pw, name, telno, email, add);
	}

}
