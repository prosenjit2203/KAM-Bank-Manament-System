package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;

public class CustomersRepo implements ICustomersRepo
{
	public void addCustomers(Customers c)
	{
		Customers[] customersList=this.getAllCustomers();
		for(int i=0;i<customersList.length;i++)
		{
			if(customersList[i]==null)
			{
				customersList[i]=c;
				break;
			}
		}
		this.write(customersList);
	}
	public void removeCustomers(String key)
	{
		Customers[] customersList=this.getAllCustomers();
		for(int i=0;i<customersList.length;i++)
		{
			if(customersList[i]!=null)
			{
				customersList[i]=null;
				break;
			}
		}
		this.write(customersList);
	}
	public void updateCustomers(Customers c)
	{
		Customers[] customersList=this.getAllCustomers();
		for(int i=0;i<customersList.length;i++)
		{
			if(customersList[i]!=null)
			{
				if(customersList[i].getUserId().equals(c.getUserId()))
				{
					customersList[i]=c;
						break;
				}
			}
		}
		this.write(customersList);
	}
	public Customers searchCustomersByUserId(String id)
	{
		Customers[] customersList=this.getAllCustomers();
		for(int i=0;i<customersList.length;i++)
		{
			if(customersList[i]!=null)
			{
				if(customersList[i].getUserId().equals(id))
				{
					return customersList[i];
				}
			}
		}
		return null;
	}
	public Customers[] getAllCustomers()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/customers.txt");
		Customers c=new Customers();
		Customers[] customersList=new Customers[50];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				customersList[i]=c.formCustomers(str);
				
			}
			
			i++;
		}
		
		return customersList;
	}
	public void write(Customers[] customersList)
	{
		String[] data=new String[50];
		for(int i=0;i<50;i++)
		{
			if(customersList[i]!=null)
			{
				data[i]=customersList[i].toStringCustomers();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/customers.txt");
	}
	
	
}