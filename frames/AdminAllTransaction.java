package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AdminAllTransaction extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable transactionTable;
	private JScrollPane transactionTableSP;
	private JPanel panel;
	private User u;
	
	
	
	public AdminAllTransaction(User u)
	{
		super(" All Transaction History!!");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		TransactionRepo trp=new TransactionRepo();
		Transaction[] transactionList=trp.getAllTransaction();
		String transactionData1[][]=new String[transactionList.length][6];
		for(int i=0;i<transactionList.length;i++)
		{
		
			if(transactionList[i]!=null)
			{
				transactionData1[i][0]=transactionList[i].getTransactionId();
				transactionData1[i][1]=transactionList[i].getAccNo();
				transactionData1[i][2]=transactionList[i].getTransactionType();
				transactionData1[i][3]=transactionList[i].getDate();
				transactionData1[i][4]=String.valueOf(transactionList[i].getAmount());
				transactionData1[i][5]=transactionList[i].getStatus();
				
			}
			
			
			
		}
		String head1[]={"Transaction id","Account Number","User Id","Paid Amount","Date"};
		this.transactionTable=new JTable(transactionData1,head1);
		this.transactionTableSP=new JScrollPane(transactionTable);
		this.transactionTableSP.setBounds(50,110,700,450);
		this.transactionTable.setEnabled(false);
		this.panel.add(transactionTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
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