package info.iniko.bank_kata;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class WithdrawalAccount {
	private String lastname;
	private String firstname;
	private List<Transaction> transactionsList;
	private BigDecimal initialBalance;
	private BigDecimal balance;
	public WithdrawalAccount(String firstname,String lastname,float initialBalance) throws NegativeTransException {
		if(initialBalance<0) {
			throw new NegativeTransException();
		}
		this.initialBalance = new BigDecimal(initialBalance);
		balance = this.initialBalance ;
		transactionsList = new LinkedList<Transaction>();
		this.firstname = firstname;
		this.lastname  = lastname;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void withdraw(float amount) throws NegativeTransException, FormatTransException, UnsufficientTransException {
		BigDecimal a = new BigDecimal (amount);
		try {
			if(a.compareTo(BigDecimal.ZERO) < 0 ){
				throw new NegativeTransException();
			}
			if(balance.compareTo(a)<0){
				throw new UnsufficientTransException();
			}
			transactionsList.add(new Transaction(amount));
			balance = initialBalance;

			for(Transaction elt : transactionsList){
				balance = balance.subtract(elt.getAmount());
			}

		}catch (NumberFormatException nfe) {
			throw new FormatTransException();
		}
		
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public String toString() {
		return "your account, "+ firstname + " ," + lastname + " has balance: "+getBalance();
	}
}
