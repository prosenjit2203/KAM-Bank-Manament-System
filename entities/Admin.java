package entities;
import java.lang.*;

public class Admin extends User
{
	private String companyShareParcentage;
	
	public Admin()
	{
		super();
	}
	public Admin(String userId, String name, String gender,String bloodGroup,int age,String nid, String address, int role,String securityAns, String password, String companyShareParcentage)
	{
		super(userId,name,gender,bloodGroup,age,nid,address,role, securityAns,password);
		this.companyShareParcentage=companyShareParcentage;
	}
	public void setCompanyShareParcentage(String companyShareParcentag)
	{
		this.companyShareParcentage=companyShareParcentage;
	}
	public String getCompanyShareParcentage()
	{
		return this.companyShareParcentage;
	}
	public String toStringAdmin()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.bloodGroup+","+this.age+","+this.nid+","+this.address+","+this.companyShareParcentage+"\n";
		return str;
	}
	
	public Admin formAdmin(String str)
	{
		String[] info=str.split(",");
		Admin a=new Admin();
		a.setUserId(info[0]);
		a.setName(info[1]);
		a.setGender(info[2]);
		a.setBloodGroup(info[3]);
		a.setAge(Integer.parseInt(info[4]));
		a.setNid(info[5]);
		a.setAddress(info[6]);
		a.setCompanyShareParcentage(info[7]);
		
		return a;
	}
	
	
}