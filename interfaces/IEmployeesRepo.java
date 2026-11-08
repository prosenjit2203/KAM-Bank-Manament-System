package interfaces;
import java.lang.*;
import entities.*;


public interface IEmployeesRepo
{
	void addEmployees(Employees e);
	void removeEmployees(String key);
	void updateEmployees(Employees e);
	Employees searchEmployeesByUserId(String id);
	Employees[] getAllEmployees();
	
}