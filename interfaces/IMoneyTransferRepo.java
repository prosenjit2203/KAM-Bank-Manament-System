package interfaces;
import java.lang.*;
import entities.*;

public interface IMoneyTransferRepo
{
	void transfer(MoneyTransfer mt);
	MoneyTransfer searchByMoneyTransferId(String id);
	MoneyTransfer[] searchByAccNo(String accNo);
	MoneyTransfer[] getAllMoneyTransfer();
}