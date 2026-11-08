package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class CustomersHomeFrame extends JFrame implements ActionListener
{
	
	private JButton backBtn,transactionBtn,moneyTransferBtn, profileBtn, passBtn,checkBalanceBtn;
	private JPanel panel;
	private User u;
	private Transaction t;
	private MoneyTransfer mt;
	private Account ac;
	
	public CustomersHomeFrame(User u)
	{
		
		super("Customers Home Frame");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(new GridLayout(2,2));
		this.panel.setBackground(Color.GRAY);
		
		
		
		this.transactionBtn=new JButton("Transaction");
		this.transactionBtn.setBounds(210,50,150,30);
		this.transactionBtn.addActionListener(this);
		this.transactionBtn.setBackground(Color.ORANGE);
		this.panel.add(transactionBtn);
		
		this.moneyTransferBtn=new JButton("Money Transfer");
		this.moneyTransferBtn.setBounds(370,50,150,30);
		this.moneyTransferBtn.addActionListener(this);
		this.moneyTransferBtn.setBackground(Color.ORANGE);
		this.panel.add(moneyTransferBtn);
		
		this.checkBalanceBtn=new JButton("Check balance");
		this.checkBalanceBtn.setBounds(530,50,150,30);
		this.checkBalanceBtn.addActionListener(this);
		this.checkBalanceBtn.setBackground(Color.ORANGE);
		this.panel.add(checkBalanceBtn);
		
		this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(50,100,150,30);
		this.passBtn.addActionListener(this);
		this.passBtn.setBackground(Color.ORANGE);
		this.panel.add(passBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(800,450,100,30);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(255,102,102));
		this.panel.add(backBtn);
		
		AccountRepo arp=new AccountRepo();
		Account[] accountList=arp.getAllAccount();
		
		
		this.add(panel);
		this.u=u;
		this.t=t;
		this.mt=mt;
		this.ac=ac;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		if(command.equals(transactionBtn.getText()))
		{
			TransactionOperationFrame tof=new TransactionOperationFrame(this.t);
			this.setVisible(false);
			tof.setVisible(true);
		}
		if(command.equals(moneyTransferBtn.getText()))
		{
			MoneyTransferOperation mto=new MoneyTransferOperation(this.mt);
			this.setVisible(false);
			mto.setVisible(true);
		}
		
		if(command.equals(checkBalanceBtn.getText()))
		{
			CheckBalanceFrame cbf=new CheckBalanceFrame(this.ac,this.u);
			this.setVisible(false);
			cbf.setVisible(true);
		}
		
		
		if(command.equals(passBtn.getText()))
		{
			CustomersUpdatePasswordFrame cupf=new CustomersUpdatePasswordFrame(this.u);
			this.setVisible(false);
			cupf.setVisible(true);
		}
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		
		
	}
	
}
