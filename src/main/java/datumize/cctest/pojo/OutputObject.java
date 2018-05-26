package datumize.cctest.pojo;

public class OutputObject {
	private String zone;
	private Integer incomes;
	private String cliente;
	
	public OutputObject(String zone, Integer incomes, String cliente) {
		super();
		this.zone = zone;
		this.incomes = incomes;
		this.cliente = cliente;
	}
	
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public Integer getIncomes() {
		return incomes;
	}
	public void setIncomes(Integer incomes) {
		this.incomes = incomes;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}	
	
	
}
