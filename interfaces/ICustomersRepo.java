package interfaces;
import java.lang.*;
import entities.*;


public interface ICustomersRepo
{
	void addCustomers(Customers c);
	void removeCustomers(String key);
	void updateCustomers(Customers c);
	Customers searchCustomersByUserId(String id);
	Customers[] getAllCustomers();
	
}