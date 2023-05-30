

import java.sql.Date;
import java.util.Objects;

public class ReservationVO {
	private String no;
	private  String service;
	private  Date date;
	private  int area;
	private  int cost;
	private  String cstId;
	private String comName;
	private CustomerVO vo;
	
	public ReservationVO() {
		
	}
	
	public ReservationVO (String no, String service, Date date, int area, int cost, String comName) {
		this.no = no;
		this.service = service;
		this.date = date;
		this.area = area;
		this.cost = cost;
//		this.cstId = cstId;
		this.comName=comName;
	}
	public ReservationVO (String no, String service, Date date, int area,  int cost) {
		this.no = no;
		this.service = service;
		this.date = date;
		this.area = area;
		this.cost = cost;
	}


	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public  String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public  Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public  int getArea() {
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
	public String getcstId() {
		return cstId;
	}
	public void setcstId(String cstId) {
		this.cstId = cstId;
	}
	
	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, comName, cost, date, no, service);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationVO other = (ReservationVO) obj;
		return Objects.equals(area, other.area) && Objects.equals(comName, other.comName)
				&& Objects.equals(cost, other.cost) && Objects.equals(date, other.date) && no == other.no
				&& Objects.equals(service, other.service);
	}
	
	@Override
	public String toString() {
		return String.format("\n예약번호: %s\n청소서비스: %s\n청소일자: %s\n작업평수: %s평\n요금: %s원\n청소업체: %s\n", no, service, date, area, cost, comName);
	}
	

}
