package entities;
import java.lang.*;

public class Account 
{
    protected String accNo, userId, status;
    protected double balance;

    public Account() 
	{
		
	}

    public Account(String accNo, String userId, String status, double balance) 
	{
        this.accNo=accNo;
        this.userId=userId;
        this.status=status;
        this.balance=balance;
    }

    public void setAccNo(String accNo) 
	{
        this.accNo=accNo;
    }

    public void setUserId(String userId) 
	{
        this.userId=userId;
    }

    public void setStatus(String status) 
	{
        this.status=status;
    }

    public void setBalance(double balance) 
	{
        this.balance=balance;
    }

    public String getAccNo() 
	{
        return this.accNo;
    }

    public String getUserId() 
	{
        return this.userId;
    }

    public String getStatus() 
	{
        return this.status;
    }

    public double getBalance() 
	{
        return this.balance;
    }

    public String toStringAccount() 
	{
        String str=this.accNo + "," + this.userId + "," + this.status + "," + this.balance + "\n";
		return str;
    }

    public static Account formAccount(String str) 
	{
        String[] info=str.split(",");
        Account ac=new Account();
        ac.setAccNo(info[0]);
        ac.setUserId(info[1]);
        ac.setStatus(info[2]);
        ac.setBalance(Double.parseDouble(info[3]));
        return ac;
    }
}
