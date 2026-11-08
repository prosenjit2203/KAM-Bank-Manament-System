package entities;
import java.lang.*;

public class Employees extends User 
{
	private String employeesPost;
	private double salary;
	
	public Employees()
	{
		super();
	}
	public Employees(String userId, String name, String gender,String bloodGroup,int age,String nid, String address, int role,String securityAns, String password,String employeesPost,double salary)
	{
		super(userId,name,gender,bloodGroup,age,nid,address,role, securityAns,password);
		this.employeesPost=employeesPost;
		this.salary=salary;
	}
	public void setEmployeesPost(String employeesPost)
	{
		this.employeesPost=employeesPost;
	}
	public void setSalary(double salary)
	{
		this.salary=salary;
	}
	public String getEmployeesPost()
	{
		return this.employeesPost;
	}
	public double getSalary()
	{
		return this.salary;
	}
	public String toStringEmployees()
	{
		String str=this.userId+","+this.name+","+this.gender+","+this.bloodGroup+","+this.age+","+this.nid+","+this.address+","+this.employeesPost+","+this.salary+"\n";
		return str;
	}
	
	public Employees formEmployees(String str)
	{
		String[] info=str.split(",");
		Employees e=new Employees();
		e.setUserId(info[0]);
		e.setName(info[1]);
		e.setGender(info[2]);
		e.setBloodGroup(info[3]);
		e.setAge(Integer.parseInt(info[4]));
		e.setNid(info[5]);
		e.setAddress(info[6]);
		e.setEmployeesPost(info[7]);
		e.setSalary(Double.parseDouble(info[8]));
		
		return e;
	}
	
	
	
}