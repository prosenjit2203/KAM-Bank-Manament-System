package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AllAccount extends JFrame implements ActionListener
{
	
	private JButton backBtn;
	private JTable accountTable;
	private JScrollPane accountTableSP;
	private JPanel panel;
	private User u;
	
	
	
	public AllAccount(User u)
	{
		super(" All Account");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(50,50,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		AccountRepo arp=new AccountRepo();
		Account[] accountList=arp.getAllAccount();
		String accountData1[][]=new String[accountList.length][4];
		for(int i=0;i<accountList.length;i++)
		{
		
			if(accountList[i]!=null)
			{
				accountData1[i][0]=accountList[i].getAccNo();
				accountData1[i][1]=accountList[i].getUserId();
				accountData1[i][2]=accountList[i].getStatus();
				accountData1[i][3]=String.valueOf(accountList[i].getBalance());
			}
		
		}
		
		String head1[]={"AccNo","User Id","Status","Balance"};
		this.accountTable=new JTable(accountData1,head1);
		this.accountTableSP=new JScrollPane(accountTable);
		this.accountTableSP.setBounds(50,110,700,450);
		this.accountTable.setEnabled(false);
		this.panel.add(accountTableSP);
		
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