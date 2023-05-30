

import java.sql.Date;
import java.util.Objects;

public class EmployeeVO {
	private String name;
	private String ihidNum;
	private String telNo;
	private String email;
	private String add;
	private Date hireDate;
	private String comId;

	public EmployeeVO() {
	}

	public EmployeeVO( String name, String ihidNum, String telNo, String email, String add, Date hireDate,
			String comId) {
		this.name = name;
		this.ihidNum = ihidNum;
		this.telNo = telNo;
		this.email = email;
		this.add = add;
		this.hireDate = hireDate;
		this.comId = comId;
	}

	public EmployeeVO(String name, String ihidNum, String telNo, String email, String add, Date hireDate) {
		this.name = name;
		this.ihidNum = ihidNum;
		this.telNo = telNo;
		this.email = email;
		this.add = add;
		this.hireDate = hireDate;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIhidNum() {
		return ihidNum;
	}

	public void setIhidNum(String ihidNum) {
		this.ihidNum = ihidNum;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
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

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getcomId() {
		return comId;
	}

	public void setcomId(String comId) {
		this.comId = comId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, ihidNum, telNo, email, add, hireDate, comId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EmployeeVO)) {
			return false;
		}
		EmployeeVO other = (EmployeeVO) obj;
		return Objects.equals(add, other.add) && Objects.equals(comId, other.comId)
				&& Objects.equals(email, other.email) && Objects.equals(hireDate, other.hireDate)
				&& Objects.equals(name, other.name) && Objects.equals(telNo, other.telNo);
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s", name, ihidNum, telNo, email, add, hireDate, comId);
	}
	
}
