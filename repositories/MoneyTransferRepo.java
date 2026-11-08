package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;
public class MoneyTransferRepo implements IMoneyTransferRepo
{
	public void transfer(MoneyTransfer mt) 
	{
		Account ac=new Account();
        MoneyTransfer[] moneyTransferList = this.getAllMoneyTransfer();
        MoneyTransfer[] fromAccount = this.searchByAccNo(mt.getSenderAccNo());
        MoneyTransfer[] toAccount = this.searchByAccNo(mt.getReceiverAccNo());

        if(fromAccount!=null && toAccount!=null)
		{
			
			if (ac.getBalance() >= mt.getAmount()) 
			{
				ac.setBalance(ac.getBalance() - mt.getAmount());
				ac.setBalance(ac.getBalance() + mt.getAmount());

				//this.write();
			} 
			 
			else if (ac.getBalance() <= mt.getAmount())
			{
				System.out.println("Insufficient funds for transfer.");
			}
			 else 
			{
				System.out.println("One or both accounts not found.");
			}
		}
    }
	public MoneyTransfer searchByMoneyTransferId(String id)
	{
		MoneyTransfer[] moneyTransferList=this.getAllMoneyTransfer();
		
		for(int i=0;i<moneyTransferList.length;i++)
		{
			if(moneyTransferList[i]!=null)
			{
				if(moneyTransferList[i].getMoneyTransferId().equals(id))
				{
					return moneyTransferList[i];
				}
			}
			
		}

		return null;
	}
	
	public MoneyTransfer[] searchByAccNo(String accNo)
	{
		MoneyTransfer[] moneyTransferList=this.getAllMoneyTransfer();
		MoneyTransfer[] foundTransaction=new MoneyTransfer[50];
		
		for(int i=0;i<moneyTransferList.length;i++)
		{
			if(moneyTransferList[i]!=null)
			{
				if(moneyTransferList[i].getSenderAccNo().equals(accNo))
				{
					foundTransaction[i]=moneyTransferList[i];
				}
				else if(moneyTransferList[i].getReceiverAccNo().equals(accNo))
				{
					foundTransaction[i]=moneyTransferList[i];
				}
			}
			
		}

		return foundTransaction;
	}
	public MoneyTransfer[] getAllMoneyTransfer() 
	{
        FileIO fio = new FileIO();
        String[] data = fio.readFile("repositories/data/moneytransfer.txt");
		MoneyTransfer mt=new MoneyTransfer();
        MoneyTransfer[] moneyTransferList = new MoneyTransfer[50];
        int i = 0;
        for (String str : data) 
		{
            if (str != null) 
			{
				System.out.println(str);
               moneyTransferList[i]=mt.formMoneyTransfer(str);
            }
			i++;
        }

        return moneyTransferList;
    }
	public void write(MoneyTransfer[] moneyTransferList) 
	{
        String[] data = new String[50];
        for (int i = 0; i < 50; i++) 
		{
            if (moneyTransferList[i] != null) 
			{
                data[i] = moneyTransferList[i].toStringMoneyTransfer();
            }
        }
        FileIO fio = new FileIO();
        fio.writeFile(data, "repositories/data/moneytransfer.txt");
    }
} 