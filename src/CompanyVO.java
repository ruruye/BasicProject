

public class CompanyVO extends CustomerVO  {
	private String repName;
	
	public CompanyVO() {
	}

	public CompanyVO(String id, String pw) {
		super(id, pw);
	}
	
	public CompanyVO(String id, String pw, String name, String telNo, String email, String add, String repName ) {
		super(id, pw, name, telNo, email, add);
		this.repName = repName;
	}

	@Override
	public String toString() {
		return String.format("%s,\t%s", super.toString(), repName);
	}
	
}
