package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AccountOperationFrame extends JFrame implements ActionListener
{
	private JLabel accNoLabel,userIdLabel,statusLabel,balanceLabel;
	private JTextField accNoTF,userIdTF,statusTF,balanceTF;
	private JButton addBtn,removeBtn,backBtn,searchBtn,checkBalanceBtn;
	private Jpanel panel;
	private Account ac;
	private User u;
	
	
	
	public AccountOperationFrame(Account ac,User u)
	{
		super("Account Operation");
		this.setSize(1300,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.accNoLabel=new JLabel("AccNo:");
		this.accNoLabel.setBounds(50,50,60,30);
		this.panel.add(accNoLabel);
		
		this.accNoTF=new JTextField();
		this.accNoTF.setBounds(120,50,100,30);
		this.panel.add(accNoTF);
		
		this.userIdLabel=new JLabel("UserId:");
		this.userIdLabel.setBounds(50,100,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,100,100,30);
		this.userTF.setText(ac.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.statusLabel=new JLabel("Status:");
		this.statusLabel.setBounds(50,150,60,30);
		this.panel.add(statusLabel);
		
		this.statusTF=new JTextField();
		this.statusTF.setBounds(120,150,100,30);
		this.panel.add(statusTF);
		
		this.balanceLabel=new JLabel("Balance:");
		this.balanceLabel.setBounds(50,200,60,30);
		this.panel.add(balanceLabel);
		
		this.balanceTF=new JTextField();
		this.balanceTF.setBounds(120,200,100,30);
		this.panel.add(balanceTF);
		
		this.addBtn=new JButton("Creat Account");
		this.addBtn.setBounds(120,250,60,30);
		this.panel.add(addBtn);
		
		
		this.removeBtn=new JButton("Delete Account");
		this.removeBtn.setBounds(200,300,60,30);
		this.panel.add(removeBtn);
		
		
		this.searchBtn=new JButton("SearchByUserID");
		this.searchBtn.setBounds(400,400,100,30);
		this.panel.add(searchBtn);
		
		this.checkBalanceBtn=new JButton("Balance Check");
		this.checkBalanceBtn.setBounds(400,400,100,30);
		this.panel.add(checkBalanceBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(660,350,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		
		
		AccountRepo arp=new AccountRepo();
		Account[] accountList=arp.getAllAccount();
		String accountData1[][]=new String[accountList.length][4];
		for(int i=0;i<accountList.length;i++)
		{
		
			if(accountList[i]!=null)
			{
				System.out.println(accountList[i].toStringAccount());
				accountData1[i][0]=accountList[i].getAccNo();
				accountData1[i][1]=accountList[i].getUserId();
				accountData1[i][2]=accountList[i].getStatus();
				accountData1[i][3]=String.valueOf(accountList[i].getBalance());
				
				
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
		this.ac=ac;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			
			String accNo, userId, status, balance;
			
			if((!userIdTF.getText().isEmpty()) && (!accNoTF.getText().isEmpty()) && (!statusTF.getText().isEmpty()) && (!balanceTF.getText().isEmpty()) )
			{
				userId=userIdTF.getText();
				AccountRepo arp=new AccountRepo();
				Account ac=arp.searchAccountByUserId(userId);
				if(ac==null)
				{
					try
					{
						accNo=accNoTF.getText();
						status=statusTF.getText();
						
						
						balance=Double.parseDouble(balanceTF.getText());
					
						Account ac=new Account(accNo,userId,status,balance);
						arp.addUser(ac);
						AccountRepo crp=new AccountRepo();
						arp.creatAccount(ac);
						JOptionPane.showMessageDialog(this,"Account Created Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide Balance");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"User Id Already Exists.");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Properly");
			}
			
		}
		
		if(command.equals(removeBtn.getText()))
		{
			String userId;
			if(!userIdTF.getText().isEmpty()) 
			{
				userId=userIdTF.getText();
				AccountRepo arp=new AccountRepo();
				Account ac=arp.searchCustomersByUserId(userId);
				if(ac!=null)
				{
					UserRepo urp=new UserRepo();
					urp.removeUser(userId);
					arp.removeAccount(userId);
					JOptionPane.showMessageDialog(this,"Account Removed Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid User ID");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Provide a Valid UserId");
			}
		}
		
		if(command.equals(searchBtn.getText()))
		{
			String userId;
			if(!userIdTF.getText().isEmpty())
			{
				userId=userIdTF.getText();
				AccountRepo arp=new AccountRepo();
				Account ac=arp.searchAccountByUserId(userId);
				if(ac!=null)
				{
					userIdTF.setEditable(false);
					accNoTF.setText(ac.getAccNo());
					statusTF.setText(ac.getStatus());
					
					balanceTF.setText(String.valueOf(ac.getBalance()));
					JOptionPane.showMessageDialog(this,"Account found");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Account not found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide userId to Search Account.");
			}
			
		}
		if(command.equals(checkBalanceBtn.getText()))
		{
			
				AccountRepo arp=new AccountRepo();
				double balance = arp.checkBalance(userId);
				JOptionPane.showMessageDialog(this,"Balance for userId " + userId + ": " + balance);
		}
		
		if(command.equals(backBtn.getText()))
		{

			EmployeesHomeFrame ehf=new EmployeesHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
		}
	}
			
	
}