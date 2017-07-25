package info.iniko.bank_kata;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NegativeTransException, FormatTransException, UnsufficientTransException
    {
    	WithdrawalAccount account1;
    	account1 = new WithdrawalAccount("pierre-jean","",100);
    	System.out.println(account1);
		account1.withdraw((float) 10.0);
		assert account1.getBalance().equals(new BigDecimal(90.0));
    }
}
