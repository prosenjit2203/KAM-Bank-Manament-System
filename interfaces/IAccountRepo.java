package interfaces;
import java.lang.*;
import entities.*;

public interface IAccountRepo
{
	
	void createAccount(Account ac);
	void removeAccount(String key);
	Account searchAccountByUserId(String id);
	double checkBalance(String userId);
	Account[] getAllAccount();
	
}