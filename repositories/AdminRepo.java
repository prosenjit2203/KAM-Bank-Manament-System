package repositories;
import java.lang.*;
import java.util.*;
import entities.*;
import interfaces.*;


public class AdminRepo implements IAdminRepo
{
	public void addAdmin(Admin a)
	{
		Admin[] adminList=this.getAllAdmin();
		
		for(int i=0;i<adminList.length;i++)
		{
			if(adminList[i]==null)
			{
				adminList[i]=a;
				break;
			}
		}
		
		this.write(adminList);
	}
	public void removeAdmin(String key)
	{
		Admin[] adminList=this.getAllAdmin();
		
		for(int i=0;i<adminList.length;i++)
		{
			if(adminList[i]!=null)
			{
				if(adminList[i].getUserId().equals(key))
				{
					adminList[i]=null;
					break;
				}
			}
			
		}
		
		this.write(adminList);
	}
	public void updateAdmin(Admin a)
	{
		Admin[] adminList=this.getAllAdmin();
		
		for(int i=0;i<adminList.length;i++)
		{
			if(adminList[i]!=null)
			{
				if(adminList[i].getUserId().equals(a.getUserId()))
				{
					adminList[i]=a;
					break;
				}
			}
			
		}
		
		this.write(adminList);
		
	}
	public Admin searchAdminByUserId(String id)
	{
		Admin[] adminList=this.getAllAdmin();
		
		for(int i=0;i<adminList.length;i++)
		{
			if(adminList[i]!=null)
			{
				if(adminList[i].getUserId().equals(id))
				{
					return adminList[i];
				}
			}
			
		}

		return null;
		
		
	}
	public Admin[] getAllAdmin()
	{
		FileIO fio=new FileIO();
		String[] data= fio.readFile("repositories/data/admin.txt");
		
		
		Admin a=new Admin();
		Admin[] adminList=new Admin[100];
		int i=0;
		for(String str:data)
		{
			
			if(str!=null)
			{
				System.out.println(str);
				adminList[i]=a.formAdmin(str);
			}
			
			i++;
		}
		
		return adminList;
	}
	
	public void write(Admin[] adminList)
	{
		String[] data=new String[100];
		for(int i=0;i<100;i++)
		{
			if(adminList[i]!=null)
			{
				data[i]=adminList[i].toStringAdmin();
			}
			
		}
		FileIO fio=new FileIO();
		fio.writeFile(data, "repositories/data/admin.txt");
	}
	
}