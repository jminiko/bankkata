package info.iniko.bank_kata;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	
	private BigDecimal amount;
	private Date stampDate;

	public Transaction(double amount) {
		BigDecimal a = new BigDecimal(amount);
		this.amount = a;
		stampDate = new Date();
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Date getStampDate() {
		return stampDate;
	}

	public void setStampDate(Date stampDate) {
		this.stampDate = stampDate;
	}
}
