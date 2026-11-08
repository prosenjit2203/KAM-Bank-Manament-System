package interfaces;
import java.lang.*;
import entities.*;


public interface IAdminRepo
{
	void addAdmin(Admin a);
	void removeAdmin(String key);
	void updateAdmin(Admin a);
	Admin searchAdminByUserId(String id);
	Admin[] getAllAdmin();
	
}