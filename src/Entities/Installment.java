package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date duoDate;
	private Double amount;

	public Installment() {

	}

	public Installment(Date duoDate, Double amount) {
		this.duoDate = duoDate;
		this.amount = amount;
	}

	public Date getDuoDate() {
		return duoDate;
	}

	public void setDuoDate(Date duoDate) {
		this.duoDate = duoDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return sdf.format(duoDate)+" - " + String.format("%.2f", amount);
	}

}
