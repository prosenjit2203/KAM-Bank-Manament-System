package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class EmployeesUpdateProfileFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, genderLabel, bloodGroupLabel, ageLabel, nidLabel, addressLabel, employeesPostLabel, salaryLabel;
	private JTextField userTF, nameTF, genderTF,  bloodGroupTF, ageTF, nidTF, addressTF, employeesPostTF, salaryTF;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private User u;
	private Employees employees;
	
	
	
	public EmployeesUpdateProfileFrame(User u)
	{
		super("Employees Update Profile Frame");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		EmployeesRepo erp=new EmployeesRepo();
		this.employees=erp.searchEmployeesByUserId(u.getUserId());
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(160,50,100,30);
		this.userTF.setText(employees.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(160,100,100,30);
		this.nameTF.setText(employees.getName());
		this.nameTF.setEditable(false);
		this.panel.add(nameTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,150,60,30);
		this.panel.add(genderLabel);
		
		this.genderTF=new JTextField();
		this.genderTF.setBounds(160,150,100,30);
		this.genderTF.setText(employees.getGender());
		this.panel.add(genderTF);
		
		this.bloodGroupLabel=new JLabel("Blood Group:");
		this.bloodGroupLabel.setBounds(50,200,100,30);
		this.panel.add(bloodGroupLabel);
		
		this.bloodGroupTF=new JTextField();
		this.bloodGroupTF.setBounds(160,200,100,30);
		this.bloodGroupTF.setText(employees.getBloodGroup());
		this.panel.add(bloodGroupTF);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,250,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(160,250,100,30);
		this.ageTF.setText(String.valueOf(employees.getAge()));
		this.ageTF.setEditable(false);
		this.panel.add(ageTF);
		
		
		
		this.nidLabel=new JLabel("NID:");
		this.nidLabel.setBounds(50,300,60,30);
		this.panel.add(nidLabel);
		
		this.nidTF=new JTextField();
		this.nidTF.setBounds(160,300,100,30);
		this.nidTF.setText(employees.getNid());
		this.nidTF.setEditable(false);
		this.panel.add(nidTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(50,350,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(160,350,100,30);
		this.addressTF.setText(employees.getAddress());
		this.panel.add(addressTF);
		
		this.employeesPostLabel=new JLabel("Employees Post:");
		this.employeesPostLabel.setBounds(50,400,100,30);
		this.panel.add(employeesPostLabel);
		
		this.employeesPostTF=new JTextField();
		this.employeesPostTF.setBounds(160,400,100,30);
		this.employeesPostTF.setText(employees.getEmployeesPost());
		this.employeesPostTF.setEditable(false);
		this.panel.add(employeesPostTF);				
		
		this.updateBtn=new JButton("Update");
		this.updateBtn.setBounds(70,490,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);				
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(200,490,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		if(command.equals(updateBtn.getText()))
		{
			if((!bloodGroupTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				employees.setBloodGroup(bloodGroupTF.getText());
				employees.setNid(nidTF.getText());
				employees.setAddress(addressTF.getText());
				
				EmployeesRepo erp=new EmployeesRepo();
				erp.updateEmployees(employees);
				
				JOptionPane.showMessageDialog(this,"Employees Updated Successfully");
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All the Field Properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			EmployeesHomeFrame ehf=new EmployeesHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
		}
	}
	
}