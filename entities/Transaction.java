package entities;

import java.lang.*;

public class Transaction extends Account 
{
    private String transactionId, transactionType, date;
    private double amount;

    public Transaction() 
	{
		super();
	}

    public Transaction(String transactionId, String accNo, String transactionType, String date, double amount, String status) 
	{
        super(accNo, null, status, 0.0);
        this.transactionId=transactionId;
        this.transactionType=transactionType;
        this.date=date;
        this.amount=amount;
    }

    public void setTransactionId(String transactionId) 
	{
        this.transactionId=transactionId;
    }

    public void setTransactionType(String transactionType) 
	{
        this.transactionType=transactionType;
    }

    public void setDate(String date) 
	{
        this.date=date;
    }

    public void setAmount(double amount) 
	{
        this.amount=amount;
    }

    public String getTransactionId() 
	{
        return this.transactionId;
    }

    public String getTransactionType() 
	{
        return this.transactionType;
    }

    public String getDate() 
	{
        return this.date;
    }

    public double getAmount() 
	{
        return this.amount;
    }

    public String toStringTransaction() 
	{
        String str=this.transactionId + "," + this.accNo + "," + this.transactionType + "," + this.date + "," + this.amount + "," + this.status + "\n";
		return str;
    }

    public static Transaction formTransaction(String str) 
	{
        String[] info=str.split(",");
        Transaction t=new Transaction();
        t.setTransactionId(info[0]);
        t.setAccNo(info[1]);
        t.setTransactionType(info[2]);
        t.setDate(info[3]);
        t.setAmount(Double.parseDouble(info[4]));
        t.setStatus(info[5]);
        return t;
    }
}
