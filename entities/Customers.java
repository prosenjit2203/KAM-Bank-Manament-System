package entities;
import java.lang.*;

public class Customers extends User
{
	private double creditScore;
	
	public Customers()
	{
		super();
	}
	public Customers(String userId, String name, String gender,String bloodGroup,int age,String nid, String address, int role,String securityAns, String password,double creditScore)
	{
		super(userId,name,gender,bloodGroup,age,nid,address,role, securityAns,password);
		this.creditScore=creditScore;
	}
	public void setCreditScore(double creditScore)
	{
		this.creditScore=creditScore;
	}
	public double getCreditScore()
	{
		return this.creditScore;
	}
	public String toStringCustomers()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.bloodGroup+","+this.age+","+this.nid+","+this.address+","+this.creditScore+"\n";
		return str;
	}
	
	public Customers formCustomers(String str)
	{
		String[] info=str.split(",");
		Customers c=new Customers();
		c.setUserId(info[0]);
		c.setName(info[1]);
		c.setGender(info[2]);
		c.setBloodGroup(info[3]);
		c.setAge(Integer.parseInt(info[4]));
		c.setNid(info[5]);
		c.setAddress(info[6]);
		c.setCreditScore(Double.parseDouble(info[7]));
		
		
		return c;
	}
}