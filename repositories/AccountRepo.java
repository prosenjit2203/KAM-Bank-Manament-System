package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;

public class AccountRepo implements IAccountRepo
{
	public void createAccount(Account ac)
	{
		Account[] accountList=this.getAllAccount();
		for(int i=0;i<accountList.length;i++)
		{
			if(accountList[i]==null)
			{
				accountList[i]=ac;
				break;
			}
		}
		this.write(accountList);
	}
	public void removeAccount(String key)
	{
		Account[] accountList=this.getAllAccount();
		for(int i=0;i<accountList.length;i++)
		{
			if(accountList[i]!=null && accountList[i].getUserId().equals(key))
			{
				accountList[i]=null;
				break;
			}
		}
		this.write(accountList);
	}
	public void updateAccount(Account ac)
	{
		Account[] accountList=this.getAllAccount();
		for(int i=0;i<accountList.length;i++)
		{
			if(accountList[i]!=null)
			{
				if(accountList[i].getUserId().equals(ac.getUserId()))
				{
					accountList[i]=ac;
					break;
				}
			}
		}
		this.write(accountList);
	}
	
	
	public Account searchAccountByUserId(String id)
	{
		Account[] accountList=this.getAllAccount();
		
		for(int i=0;i<accountList.length;i++)
		{
			if(accountList[i]!=null)
			{
				if(accountList[i].getUserId().equals(id))
				{
					return accountList[i];
				}
			}
			
		}

		return null;
	}
	public double checkBalance(String userId) 
	{
        Account account = this.searchAccountByUserId(userId);
        if (account != null) 
		{
            return account.getBalance(); 
        } else 
		{
            System.out.println("Account not found for userId: " + userId);
            return 0.0;
        }
	}
           
		   public Account[] getAllAccount() 
		   {
				Account ac = new Account();

				FileIO fio = new FileIO();
				String[] data = fio.readFile("repositories/data/account.txt");
				Account[] accountList = new Account[50];
				int i = 0;
				for (String str : data) 
				{
					if (str != null) 
					{
						System.out.println(str);
						accountList[i] = ac.formAccount(str); 
						i++;
					}
       
				}
				return accountList;
			}
			public void write(Account[] accountList)
			{
				String[] data=new String[50];
				for(int i=0;i<50;i++)
				{
					if(accountList[i]!=null)
					{
						data[i]=accountList[i].toStringAccount();
					}
				}
				FileIO fio=new FileIO();
				fio.writeFile(data, "repositories/data/account.txt");
			}
	
	
}