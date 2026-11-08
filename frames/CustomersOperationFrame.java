package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class CustomersOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, genderLabel, bloodGroupLabel,ageLabel, nidLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, creditScoreLabel;
	private JTextField userIdTF, nameTF, ageTF,nidTF, addressTF, securityAnsTF, creditScoreTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox bloodGroupCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable customersTable;
	private JScrollPane customersTableSP;
	private JPanel panel;
	private User u;
	
	
	
	public CustomersOperationFrame(User u)
	{
		super("Customers Operation");
		this.setSize(1300,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(120,50,100,30);
		this.panel.add(userIdTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.panel.add(nameTF);
		
		this.creditScoreLabel=new JLabel("Credit Score:");
		this.creditScoreLabel.setBounds(280,200,100,30); 
		this.panel.add(creditScoreLabel);
		
		this.creditScoreTF=new JTextField();
		this.creditScoreTF.setBounds(120,150,100,30);
		this.panel.add(creditScoreTF);
		
		this.nidLabel=new JLabel("NID:");
		this.nidLabel.setBounds(50,200,60,30);
		this.panel.add(nidLabel);
		
		this.nidTF=new JTextField();
		this.nidTF.setBounds(120,200,100,30);
		this.panel.add(nidTF);
		
		
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,250,60,30);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(120,250,60,30);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(190,250,80,30);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(280,50,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(350,50,100,30);
		this.panel.add(addressTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your Date Of Birth?:");
		this.securityQuesLabel.setBounds(280,100,300,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(280,150,100,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(390,150,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(50,150,60,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(390,200,100,30);
		this.panel.add(passPF);
		
		this.bloodGroupLabel=new JLabel("Blood Group:");
		this.bloodGroupLabel.setBounds(280,250,100,30);
		this.panel.add(bloodGroupLabel);
		
		String[] item={"A+","B+","AB+","O+","A-","B-","AB-","O-"};
		this.bloodGroupCMB=new JComboBox(item);
		this.bloodGroupCMB.setBounds(390,250,200,30);
		this.panel.add(bloodGroupCMB);
		
		this.addBtn=new JButton("Add Customers");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update Customers");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove Customers");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search Customers");
		this.searchBtn.setBounds(420,350,120,30);
		this.searchBtn.addActionListener(this);
		this.panel.add(searchBtn);
		
		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(550,350,100,30);
		this.resetBtn.addActionListener(this);
		this.panel.add(resetBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(660,350,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		CustomersRepo crp=new CustomersRepo();
		Customers[] customersList=crp.getAllCustomers();
		String customersData1[][]=new String[customersList.length][8];
		for(int i=0;i<customersList.length;i++)
		{
		
			if(customersList[i]!=null)
			{
				System.out.println(customersList[i].toStringCustomers());
				customersData1[i][0]=customersList[i].getUserId();
				customersData1[i][1]=customersList[i].getName();
				customersData1[i][2]=customersList[i].getGender();
				customersData1[i][3]=customersList[i].getBloodGroup();
				customersData1[i][4]=String.valueOf(customersList[i].getAge());
				customersData1[i][5]=customersList[i].getNid();
				customersData1[i][6]=customersList[i].getAddress();
				customersData1[i][7]=String.valueOf(customersList[i].getCreditScore());
				
				
			}
			
			
			
		}
		String head1[]={"Id","Name","Gender","BloodGroup","Age","Adress","Credit Score"};
		this.customersTable=new JTable(customersData1,head1);
		this.customersTableSP=new JScrollPane(customersTable);
		this.customersTableSP.setBounds(50,380,700,200);
		this.customersTable.setEnabled(false);
		this.panel.add(customersTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(addBtn.getText()))
		{
			String userId,name,gender,address,securityAns,pass,bloodGroup,nid;
			int age;
			double creditScore;
			if((!userIdTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!creditScoreTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				userId=userIdTF.getText();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(userId);
				if(user==null)
				{
					try
					{
						name=nameTF.getText();
						nid=nidTF.getText();
						
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}
					
						age=Integer.parseInt(ageTF.getText());
						creditScore=Double.parseDouble(creditScoreTF.getText());
						address=addressTF.getText();
						int role=3;
						securityAns=securityAnsTF.getText();
						pass=passPF.getText();
						bloodGroup=bloodGroupCMB.getSelectedItem().toString();
						Customers c=new Customers(userId,name,gender,bloodGroup,age,nid,address,role,securityAns,pass,creditScore);
						urp.addUser(c);
						CustomersRepo crp=new CustomersRepo();
						crp.addCustomers(c);
						JOptionPane.showMessageDialog(this,"Customers Added Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide Valid Age or Salary");
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
		
		if(command.equals(updateBtn.getText()))
		{
			
			String userId,name,gender,bloodGroup,nid,address;
			
			int age;
			double creditScore;
			if((!userIdTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!creditScoreTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				userId=userIdTF.getText();
				CustomersRepo crp=new CustomersRepo();
				Customers c=crp.searchCustomersByUserId(userId);
				if(c!=null)
				{
					try
					{
						name=nameTF.getText();
						
						nid=nidTF.getText();
						
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}
				
						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}
				
						else
						{
							gender=maleRB.getText();
						}
						age=Integer.parseInt(ageTF.getText());
						creditScore=Double.parseDouble(creditScoreTF.getText());
						address=addressTF.getText();
						bloodGroup=bloodGroupCMB.getSelectedItem().toString();
					
						c.setName(name);
						c.setCreditScore(creditScore);
						c.setBloodGroup(bloodGroup);
						c.setGender(gender);
						c.setAge(age);
						c.setAddress(address);
						c.setNid(nid);
						crp.updateCustomers(c);
						JOptionPane.showMessageDialog(this,"Customers Updated Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide Valid Age or CreditScore");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid User ID");
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
				CustomersRepo crp=new CustomersRepo();
				Customers c=crp.searchCustomersByUserId(userId);
				if(c!=null)
				{
					UserRepo urp=new UserRepo();
					urp.removeUser(userId);
					crp.removeCustomers(userId);
					JOptionPane.showMessageDialog(this,"Customers Removed Successfully");
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
				CustomersRepo crp=new CustomersRepo();
				Customers c=crp.searchCustomersByUserId(userId);
				if(c!=null)
				{
					userIdTF.setEditable(false);
					nameTF.setText(c.getName());
					nidTF.setText(c.getNid());
					if(c.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}
					if(c.getBloodGroup().equals("A+"))
					{
						bloodGroupCMB.setSelectedItem("A+");
					}
					else if(c.getBloodGroup().equals("B+"))
					{
						bloodGroupCMB.setSelectedItem("B+");
					}
					else if(c.getBloodGroup().equals("AB+"))
					{
						bloodGroupCMB.setSelectedItem("AB+");
					}
					else if(c.getBloodGroup().equals("O+"))
					{
						bloodGroupCMB.setSelectedItem("O+");
					}
					else if(c.getBloodGroup().equals("A-"))
					{
						bloodGroupCMB.setSelectedItem("A-");
					}
					else if(c.getBloodGroup().equals("B-"))
					{
						bloodGroupCMB.setSelectedItem("B-");
					}
					else if(c.getBloodGroup().equals("AB-"))
					{
						bloodGroupCMB.setSelectedItem("AB-");
					}
					else
					{
						bloodGroupCMB.setSelectedItem("O-");
					}
					ageTF.setText(String.valueOf(c.getAge()));
					creditScoreTF.setText(String.valueOf(c.getCreditScore()));
					addressTF.setText(c.getAddress());
					JOptionPane.showMessageDialog(this,"Customers Found.");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Customers Not Found!!");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Please Provide UserId To Search Admin.");
			}
			
		}
		
		if(command.equals(resetBtn.getText()))
		{
			userIdTF.setEditable(true);
			userIdTF.setText("");
			nameTF .setText("");
			nidTF.setText("");
			ageTF.setText("");
			creditScoreTF.setText("");
			addressTF.setText("");
			securityAnsTF.setText("");
			passPF.setText("");
			JOptionPane.showMessageDialog(this,"Reset Successfully");
		}
		
		if(command.equals(backBtn.getText()))
		{
			EmployeesHomeFrame ehf=new EmployeesHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
			
		}
	}
	
}