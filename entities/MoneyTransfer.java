package entities;
import java.lang.*;

public class MoneyTransfer extends Account
{
	private String moneyTransferId, senderAccNo, receiverAccNo;
	private double  amount;
	
	public MoneyTransfer()
	{
		super();
	}
	public MoneyTransfer(String moneyTransferId,String senderAccNo,String receiverAccNo, double amount)
	{
		//super(accNo,userId,status,balance);
		this.moneyTransferId=moneyTransferId;
		this.senderAccNo=senderAccNo;
		this.receiverAccNo=receiverAccNo;
		this.amount=amount;
	}
	public void setMoneyTransferId(String moneyTransferId)
	{
		this.moneyTransferId=moneyTransferId;
	}
	public void setSenderAccNo(String senderAccNo)
	{
		this.senderAccNo=senderAccNo;
	}
	public void setReceiverAccNo(String receiverAccNo)
	{
		this.receiverAccNo=receiverAccNo;
	}
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	public String getMoneyTransferId()
	{
		return this.moneyTransferId;
	}
	public String getSenderAccNo()
	{
		return this.senderAccNo;
	}
	public String getReceiverAccNo()
	{
		return this.receiverAccNo;
	}
	public double getAmount()
	{
		return this.amount;
	}
	public String toStringMoneyTransfer()
	{
		String str=this.moneyTransferId+","+this.senderAccNo+","+this.receiverAccNo+","+this.amount+"\n";
		return str;
	}
	public MoneyTransfer formMoneyTransfer(String str)
	{
		String [] info=str.split(",");
		MoneyTransfer mt= new MoneyTransfer();
		mt.setMoneyTransferId(info[0]);
		mt.setSenderAccNo(info[1]);
		mt.setReceiverAccNo(info[2]);
		mt.setAmount(Double.parseDouble(info[3]));
		return mt;
	}
	
}