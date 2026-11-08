package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AllMoneyTransfer extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable moneyTransferTable;
	private JScrollPane moneyTransferTableSP;
	private JPanel panel;
	private User u;
	
	
	
	
	public AllMoneyTransfer(User u)
	{
		super(" All Money Transfer");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		MoneyTransferRepo mtrp=new MoneyTransferRepo();
		MoneyTransfer[] moneyTransferList=mtrp.getAllMoneyTransfer();
		String moneyTransferData1[][]=new String[moneyTransferList.length][4];
		for(int i=0;i<moneyTransferList.length;i++)
		{
		
			if(moneyTransferList[i]!=null)
			{
				moneyTransferData1[i][0]=moneyTransferList[i].getMoneyTransferId();
				moneyTransferData1[i][1]=moneyTransferList[i].getSenderAccNo();
				moneyTransferData1[i][2]=moneyTransferList[i].getReceiverAccNo();
				moneyTransferData1[i][3]=String.valueOf(moneyTransferList[i].getAmount());
				
			}
			
			
			
		}
		
		String head1[]={"TransferId","SenderAccNo","ReceiverAccNo","Amount"};
		this.moneyTransferTable=new JTable(moneyTransferData1,head1);
		this.moneyTransferTableSP=new JScrollPane(moneyTransferTable);
		this.moneyTransferTableSP.setBounds(50,110,700,450);
		this.moneyTransferTable.setEnabled(false);
		this.panel.add(moneyTransferTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;
		;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		if(command.equals(backBtn.getText()))
		{
			
			EmployeesHomeFrame ehf=new EmployeesHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
			
		}
	}
	
} 