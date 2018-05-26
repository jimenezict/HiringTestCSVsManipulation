package datumize.cctest.pojo;

import java.util.Date;

public class InputObject {

	private Integer id;
	private String client;
	private Date date;
	private Integer incomes;
	private String zone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String cliente) {
		this.client = cliente;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getIncomes() {
		return incomes;
	}
	public void setIncomes(Integer incomes) {
		this.incomes = incomes;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
		
}
