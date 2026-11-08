package repositories;

import java.lang.*;
import entities.*;
import interfaces.*;
import java.io.*;
import java.util.*;

public class TransactionRepo implements ITransactionRepo 
{
    public void withdraw(Transaction t) 
	{
        Transaction[] transactionList = this.getAllTransaction();
        

        if (t.getBalance() >= t.getAmount()) 
		{
            for (int i = 0; i < transactionList.length; i++) 
			{
                if (transactionList[i] != null && transactionList[i].getAccNo().equals(t.getAccNo())) 
				{
                    transactionList[i].setBalance(transactionList[i].getBalance() - t.getAmount());
					
                    break;
                }
            }
            this.write(transactionList);
            
        } 
		else 
		{
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public void deposit(Transaction t) 
	{
        Transaction[] transactionList = this.getAllTransaction();
        boolean found = false;

        for (int i = 0; i < transactionList.length; i++) 
		{
            if (transactionList[i] != null && transactionList[i].getAccNo().equals(t.getAccNo())) 
			{
                transactionList[i].setBalance(transactionList[i].getBalance() + t.getAmount());
                found = true;
                break;
            }
        }

        if (!found) 
		{
            for (int i = 0; i < transactionList.length; i++) 
			{
                if (transactionList[i] == null) 
				{
                    transactionList[i] = t;
                    break;
                }
            }
        }

        this.write(transactionList);
        
    }

    public Transaction searchByTransactionId(String id) 
	{
        Transaction[] transactionList = this.getAllTransaction();

        for (Transaction t : transactionList) 
		{
            if (t != null && t.getTransactionId().equals(id)) 
			{
                return t;
            }
        }
        return null;
    }

   public Transaction[] searchByAccNo(String accNo)
	{
		Transaction[] transactionList=this.getAllTransaction();
		Transaction[] foundTransaction=new Transaction[50];
		
		for(int i=0;i<transactionList.length;i++)
		{
			if(transactionList[i]!=null)
			{
				if(transactionList[i].getAccNo().equals(accNo))
				{
					foundTransaction[i]=transactionList[i];
				}
			}
			
		}

		return foundTransaction;
	}

    public Transaction[] getAllTransaction() {
        FileIO fio = new FileIO();
        String[] data = fio.readFile("repositories/data/transaction.txt");

        Transaction t = new Transaction();
        Transaction[] transactionList = new Transaction[50];
        int i = 0;
        for (String str : data) {
            if (str != null) {
                transactionList[i] = t.formTransaction(str);
                i++;
            }
        }

        return transactionList;
    }

    /*private double getBalance(Transaction[] transactionList) {
        double balance = 0.0;
        for (Transaction transaction : transactionList) {
            if (transaction != null) {
                balance += transaction.getAmount();
            }
        }
        return balance;
    }*/

    public void write(Transaction[] transactionList) {
        String[] data = new String[50];
        for (int i = 0; i < 50; i++) {
            if (transactionList[i] != null) {
                data[i] = transactionList[i].toStringTransaction();
            }
        }
        FileIO fio = new FileIO();
        fio.writeFile(data, "repositories/data/transaction.txt");
    }
}
