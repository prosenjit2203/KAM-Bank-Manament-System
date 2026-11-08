package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;

public class EmployeesRepo implements IEmployeesRepo
{
	public void addEmployees(Employees e)
	{
		Employees[] employeesList=this.getAllEmployees();
		for(int i=0;i<employeesList.length;i++)
		{
			if(employeesList[i]==null)
			{
				employeesList[i]=e;
				break;
			}
		}
		this.write(employeesList);
	}
	public void removeEmployees(String key)
	{
		Employees[] employeesList=this.getAllEmployees();
		for(int i=0;i<employeesList.length;i++)
		{
			if(employeesList[i]!=null)
			{
				if(employeesList[i].getUserId().equals(key))
				{
					employeesList[i]=null;
					break;
				}
				
			}
		}
		this.write(employeesList);
	}
	public void updateEmployees(Employees e)
	{
		Employees[] employeesList=this.getAllEmployees();
		for(int i=0;i<employeesList.length;i++)
		{
			if(employeesList[i]!=null)
			{
				if(employeesList[i].getUserId().equals(e.getUserId()))
				{
					employeesList[i]=e;
					break;
				}
			}
		}
		this.write(employeesList);
	}
	public Employees searchEmployeesByUserId(String id)
	{
		Employees[] employeesList=this.getAllEmployees();
		for(int i=0;i<employeesList.length;i++)
		{
			if(employeesList[i]!=null)
			{
				if(employeesList[i].getUserId().equals(id))
				{
					return employeesList[i];
				}
			}
		}
		return null;
	}
	public Employees[] getAllEmployees()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/employees.txt");
		Employees e=new Employees();
		Employees[] employeesList=new Employees[50];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				employeesList[i]=e.formEmployees(str);
				
			}
			
			i++;
		}
		
		return employeesList;
	}
	public void write(Employees[] employeesList)
	{
		String[] data=new String[50];
		for(int i=0;i<50;i++)
		{
			if(employeesList[i]!=null)
			{
				data[i]=employeesList[i].toStringEmployees();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/employees.txt");
	}
	
	
}