

import java.sql.Date;
import java.util.Objects;

public class ReservationsVO {
	private String no;
	private String name;
	private String telNum;
	private String add;
	private String service;
	private Date date;
	private int area;
	private int cost;

	public ReservationsVO(String no, String name, String telNum, String add, String service, Date date, int area,
			int cost) {
		this.no=no;
		this.name=name;
		this.telNum=telNum;
		this.add=add;
		this.service=service;
		this.date=date;
		this.area=area;
		this.cost=cost;
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public int hashCode() {
		return Objects.hash(add, area, cost, date, name, no, service, telNum);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ReservationsVO)) {
			return false;
		}
		ReservationsVO other = (ReservationsVO) obj;
		return Objects.equals(add, other.add) && area == other.area && cost == other.cost
				&& Objects.equals(date, other.date) && Objects.equals(name, other.name) && Objects.equals(no, other.no)
				&& Objects.equals(service, other.service) && Objects.equals(telNum, other.telNum);
	}
	
	@Override
	public String toString() {
		return String.format("\n예약번호: %s\n고객명: %s\n연락처: %s\n주소: %s\n희망서비스: %s\n작업일자: %s\n평수: %s평\n요금: %s원\n", no, name, telNum, add, service, date, area, cost);
	}
	
}
