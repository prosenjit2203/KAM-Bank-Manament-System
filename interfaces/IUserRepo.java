package interfaces;
import java.lang.*;
import entities.*;


public interface IUserRepo
{
	void addUser(User u);
	void removeUser(String key);
	void updateUser(User u);
	User searchUserByUserId(String id);
	User[] getAllUser();
	
}