package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class EmployeesOperationFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, genderLabel, bloodGroupLabel,ageLabel, nidLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, employeesPostLabel,salaryLabel;
	private JTextField userIdTF, nameTF, ageTF,nidTF, addressTF, securityAnsTF, employeesPostTF,salaryTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox bloodGroupCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable employeesTable;
	private JScrollPane employeesTableSP;
	private JPanel panel;
	private User u;
	
	
	
	public EmployeesOperationFrame(User u)
	{
		super("Employees Operation");
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
		
		this.employeesPostLabel=new JLabel("Employees Post");
		this.employeesPostLabel.setBounds(50,150,90,30);
		this.panel.add(employeesPostLabel);
		
		this.employeesPostTF=new JTextField();
		this.employeesPostTF.setBounds(150,150,100,30);
		this.panel.add(employeesPostTF);
		
		this.nidLabel=new JLabel("NID:");
		this.nidLabel.setBounds(280,300,60,30);
		this.panel.add(nidLabel);
		
		this.nidTF=new JTextField();
		this.nidTF.setBounds(350,300,100,30);
		this.panel.add(nidTF);
		
		this.salaryLabel=new JLabel("Salary:");
		this.salaryLabel.setBounds(50,200,60,30);
		this.panel.add(salaryLabel);
		
		this.salaryTF=new JTextField();
		this.salaryTF.setBounds(120,200,100,30);
		this.panel.add(salaryTF);
		
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
		this.passLabel.setBounds(280,200,100,30);
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
		
		this.addBtn=new JButton("Add Employees");
		this.addBtn.setBounds(50,350,100,30);
		this.addBtn.addActionListener(this);
		this.panel.add(addBtn);
		
		this.updateBtn=new JButton("Update Employees");
		this.updateBtn.setBounds(160,350,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		this.removeBtn=new JButton("Remove Employees");
		this.removeBtn.setBounds(290,350,120,30);
		this.removeBtn.addActionListener(this);
		this.panel.add(removeBtn);
		
		this.searchBtn=new JButton("Search Employees");
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
		EmployeesRepo erp=new EmployeesRepo();
		Employees[] employeesList=erp.getAllEmployees();
		String employeesData1[][]=new String[employeesList.length][9];
		for(int i=0;i<employeesList.length;i++)
		{
		
			if(employeesList[i]!=null)
			{
				System.out.println(employeesList[i].toStringEmployees());
				employeesData1[i][0]=employeesList[i].getUserId();
				employeesData1[i][1]=employeesList[i].getName();
				employeesData1[i][2]=employeesList[i].getGender();
				employeesData1[i][3]=employeesList[i].getBloodGroup();
				employeesData1[i][4]=String.valueOf(employeesList[i].getAge());
				employeesData1[i][5]=employeesList[i].getNid();
				employeesData1[i][6]=employeesList[i].getAddress();
				employeesData1[i][7]=employeesList[i].getEmployeesPost();
				employeesData1[i][8]=String.valueOf(employeesList[i].getSalary());
				
			}
			
			
			
		}
		String head1[]={"Id","Name","Gender","BloodGroup","Age","Adress","EmployeePost","Salary"};
		this.employeesTable=new JTable(employeesData1,head1);
		this.employeesTableSP=new JScrollPane(employeesTable);
		this.employeesTableSP.setBounds(50,380,700,200);
		this.employeesTable.setEnabled(false);
		this.panel.add(employeesTableSP);
		
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
			String userId,name,employeesPost,gender,address,securityAns,pass,bloodGroup,nid;
			int age;
			double salary;
			if((!userIdTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!employeesPostTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty())&& (!salaryTF.getText().isEmpty()) )
			{
				userId=userIdTF.getText();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(userId);
				if(user==null)
				{
					try
					{
						name=nameTF.getText();
						employeesPost=employeesPostTF.getText();
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
						salary=Double.parseDouble(salaryTF.getText());
						address=addressTF.getText();
						int role=2;
						securityAns=securityAnsTF.getText();
						pass=passPF.getText();
						bloodGroup=bloodGroupCMB.getSelectedItem().toString();
						Employees e=new Employees(userId,name,gender,bloodGroup,age,nid,address,role,securityAns,pass,employeesPost,salary);
						urp.addUser(e);
						EmployeesRepo erp=new EmployeesRepo();
						erp.addEmployees(e);
						JOptionPane.showMessageDialog(this,"Employees added Successfully");
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide Valid Age or Salary");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"User Id already exists.");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Properly");
			}
			
		}
		
		if(command.equals(updateBtn.getText()))
		{
			
			String userId,name,gender,bloodGroup,nid,address,employeesPost;
			
			int age;
			double salary;
			if((!userIdTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!employeesPostTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!salaryTF.getText().isEmpty()))
			{
				userId=userIdTF.getText();
				EmployeesRepo erp=new EmployeesRepo();
				Employees e=erp.searchEmployeesByUserId(userId);
				if(e!=null)
				{
					
					try
					{
						name=nameTF.getText();
						employeesPost=employeesPostTF.getText();
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
						salary=Double.parseDouble(salaryTF.getText());
						address=addressTF.getText();
						bloodGroup=bloodGroupCMB.getSelectedItem().toString();
					
						e.setName(name);
						e.setEmployeesPost(employeesPost);
						e.setSalary(salary);
						e.setBloodGroup(bloodGroup);
						e.setGender(gender);
						e.setAge(age);
						e.setAddress(address);
						e.setNid(nid);
						erp.updateEmployees(e);
						JOptionPane.showMessageDialog(this,"Employees Updated Successfully");
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(this,"Provide Valid Age or Salary");
						return;
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
				EmployeesRepo erp=new EmployeesRepo();
				Employees e=erp.searchEmployeesByUserId(userId);
				if(e!=null)
				{
					UserRepo urp=new UserRepo();
					urp.removeUser(userId);
					erp.removeEmployees(userId);
					JOptionPane.showMessageDialog(this,"Employees Removed Successfully");
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
				EmployeesRepo erp=new EmployeesRepo();
				Employees e=erp.searchEmployeesByUserId(userId);
				if(e!=null)
				{
					userIdTF.setEditable(false);
					nameTF.setText(e.getName());
					employeesPostTF.setText(e.getEmployeesPost());
					nidTF.setText(e.getNid());
					if(e.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}
					
					else
					{
						femaleRB.setSelected(true);
					}
					if(e.getBloodGroup().equals("A+"))
					{
						bloodGroupCMB.setSelectedItem("A+");
					}
					else if(e.getBloodGroup().equals("B+"))
					{
						bloodGroupCMB.setSelectedItem("B+");
					}
					else if(e.getBloodGroup().equals("AB+"))
					{
						bloodGroupCMB.setSelectedItem("AB+");
					}
					else if(e.getBloodGroup().equals("O+"))
					{
						bloodGroupCMB.setSelectedItem("O+");
					}
					else if(e.getBloodGroup().equals("A-"))
					{
						bloodGroupCMB.setSelectedItem("A-");
					}
					else if(e.getBloodGroup().equals("B-"))
					{
						bloodGroupCMB.setSelectedItem("B-");
					}
					else if(e.getBloodGroup().equals("AB-"))
					{
						bloodGroupCMB.setSelectedItem("AB-");
					}
					else
					{
						bloodGroupCMB.setSelectedItem("O-");
					}
					ageTF.setText(String.valueOf(e.getAge()));
					salaryTF.setText(String.valueOf(e.getSalary()));
					addressTF.setText(e.getAddress());
					JOptionPane.showMessageDialog(this,"Employees Found.");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Emplopyees Not Found!!");
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
			nameTF.setText("");
			nidTF.setText("");
			ageTF.setText("");
			employeesPostTF.setText("");
			salaryTF.setText("");
			addressTF.setText("");
			securityAnsTF.setText("");
			passPF.setText("");
			JOptionPane.showMessageDialog(this,"Reset Successfully");
		}
		
			if(command.equals(backBtn.getText()))
			{
				
				AdminHomeFrame adf=new AdminHomeFrame(this.u);
				this.setVisible(false);
				adf.setVisible(true);
				
			}
	}
	
}