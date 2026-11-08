package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class AdminHomeFrame extends JFrame implements ActionListener
{
	private JLabel adminHomeLabel,operationLabel,viewLabel, updateLabel;
	private JButton adminBtn,backBtn, employeesBtn, transactionBtn,moneyTransferBtn, accountBtn, profileBtn, passBtn;
	private JPanel panel;
	private User u;
	
	public AdminHomeFrame(User u)
	{
		
		super("Admin Home Frame");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.CYAN);
		
		this.adminHomeLabel = new JLabel("Admin Home");
		Font adminHomeFont = new Font("Arial", Font.BOLD, 30); 
		this.adminHomeLabel.setFont(adminHomeFont);
		this.adminHomeLabel.setBounds(380, 30, 500, 60); 
		this.panel.add(adminHomeLabel);
		
		this.operationLabel = new JLabel("Operations");
		Font operationFont = new Font("Arial", Font.BOLD, 20); 
		this.operationLabel.setFont(operationFont);
		this.operationLabel.setBounds(150, 150, 150, 40); 
		this.panel.add(operationLabel);
		
		this.adminBtn=new JButton("Admin Operation");
		this.adminBtn.setBounds(150,200,200,30);
		this.adminBtn.addActionListener(this);
		this.adminBtn.setBackground(Color.ORANGE);
		this.panel.add(adminBtn);
		
		
		this.employeesBtn=new JButton("Employees Operation");
		this.employeesBtn.setBounds(150,240,200,30);
		this.employeesBtn.addActionListener(this);
		this.employeesBtn.setBackground(Color.WHITE);
		this.panel.add(employeesBtn);
		
		
		
		this.viewLabel = new JLabel("View");
		Font viewFont = new Font("Arial", Font.BOLD, 20); 
		this.viewLabel.setFont(viewFont);
		this.viewLabel.setBounds(440, 150, 80, 40); 
		this.panel.add(viewLabel);
		
		this.transactionBtn=new JButton("View All Transaction");
		this.transactionBtn.setBounds(440,200,200,30);
		this.transactionBtn.addActionListener(this);
		this.transactionBtn.setBackground(Color.ORANGE);;
		this.panel.add(transactionBtn);
		
		this.moneyTransferBtn=new JButton("View All MoneyTransfer");
		this.moneyTransferBtn.setBounds(440,240,200,30);
		this.moneyTransferBtn.addActionListener(this);
		this.moneyTransferBtn.setBackground(Color.WHITE);
		this.panel.add(moneyTransferBtn);
		
		this.accountBtn=new JButton("View All Accounts");
		this.accountBtn.setBounds(440,280,200,30);
		this.accountBtn.addActionListener(this);
		this.accountBtn.setBackground(Color.ORANGE);
		this.panel.add(accountBtn);
	
		
		this.updateLabel = new JLabel("Update");
		Font updateFont = new Font("Arial", Font.BOLD, 20); 
		this.updateLabel.setFont(updateFont);
		this.updateLabel.setBounds(700, 150, 100, 40); 
		this.panel.add(updateLabel);
		
		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(700,200,200,30);
		this.profileBtn.addActionListener(this);
		this.profileBtn.setBackground(Color.ORANGE);
		this.panel.add(profileBtn);
		
		this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(700,240,200,30);
		this.passBtn.addActionListener(this);
		this.passBtn.setBackground(Color.WHITE);
		this.panel.add(passBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(800,450,100,30);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(255,102,102));
		this.panel.add(backBtn);
		
		this.add(panel);
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(adminBtn.getText()))
		{
			AdminOperationFrame aof=new AdminOperationFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		if(command.equals(employeesBtn.getText()))
		{
			EmployeesOperationFrame eof=new EmployeesOperationFrame(this.u);
			this.setVisible(false);
			eof.setVisible(true);
		}
		
		if(command.equals(transactionBtn.getText()))
		{
			AdminAllTransaction aat=new AdminAllTransaction(this.u);
			this.setVisible(false);
			aat.setVisible(true);
		}
		if(command.equals(moneyTransferBtn.getText()))
		{
			AllMoneyTransfer amt=new AllMoneyTransfer(this.u);
			this.setVisible(false);
			amt.setVisible(true);
		}
		if(command.equals(accountBtn.getText()))
		{
			AllAccount ac =new AllAccount(this.u);
			this.setVisible(false);
			ac.setVisible(true);
		}
		
		if(command.equals(profileBtn.getText()))
		{
			AdminUpdateProfileFrame aof=new AdminUpdateProfileFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		if(command.equals(passBtn.getText()))
		{
			AdminUpdatePasswordFrame aof=new AdminUpdatePasswordFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		
		
		
	}
	
}
