package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class CustomersUpdateProfileFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, genderLabel, bloodGroupLabel, ageLabel, nidLabel, addressLabel, creditScoreLabel;
	private JTextField userIdTF, nameTF, genderTF, bloodGroupTF, ageTF, nidTF, addressTF, creditScoreTF;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private User u;
	private Customers customers;
	
	
	
	public CustomersUpdateProfileFrame(User u)
	{
		super("Customers Update Profile Frame");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		CustomersRepo erp=new CustomersRepo();
		this.customers=erp.searchCustomersByUserId(u.getUserId());
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(120,50,100,30);
		this.userIdTF.setText(customers.getUserId());
		this.userIdTF.setEditable(false);
		this.panel.add(userIdTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.nameTF.setText(customers.getName());
		this.nameTF.setEditable(false);
		this.panel.add(nameTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,150,60,30);
		this.panel.add(genderLabel);
		
		this.genderTF=new JTextField();
		this.genderTF.setBounds(120,150,150,30);
		this.genderTF.setText(customers.getGender());
		this.panel.add(genderTF);
		
		this.bloodGroupLabel=new JLabel("Blood Group:");
		this.bloodGroupLabel.setBounds(50,200,60,30);
		this.panel.add(bloodGroupLabel);
		
		this.bloodGroupTF=new JTextField();
		this.bloodGroupTF.setBounds(120,200,100,30);
		this.bloodGroupTF.setText(customers.getBloodGroup());
		this.panel.add(bloodGroupTF);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,250,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,250,100,30);
		this.ageTF.setText(String.valueOf(customers.getAge()));
		this.ageTF.setEditable(false);
		this.panel.add(ageTF);
		
		
		
		this.nidLabel=new JLabel("NID:");
		this.nidLabel.setBounds(50,300,60,30);
		this.panel.add(nidLabel);
		
		this.nidTF=new JTextField();
		this.nidTF.setBounds(120,300,100,30);
		this.nidTF.setText(customers.getNID());
		this.nidTF.setEditable(false);
		this.panel.add(nidTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(50,350,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(120,350,100,30);
		this.addressTF.setText(customers.getAddress());
		this.panel.add(addressTF);
		
		this.creditScoreLabel=new JLabel("Credit Score:");
		this.creditScoreLabel.setBounds(50,400,100,30);
		this.panel.add(creditScoreLabel);
		
		this.creditScoreTF=new JTextField();
		this.creditScoreTF.setBounds(160,400,100,30);
		this.creditScoreTF.setText(String.valueOf(customers.getCreditScore()));
		this.creditScoreTF.setEditable(false);
		this.panel.add(creditScoreTF);
		
		
		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(50,450,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(190,450,100,30);
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
				customers.setBloodGroup(bloodGroupTF.getText());
				customers.setNid(nidTF.getText());
				customers.setAddress(addressTF.getText());
				
				
				CustomersRepo erp=new CustomersRepo();
				erp.updateCustomers(customers);
				
				JOptionPane.showMessageDialog(this,"Customers Updated Successfully");
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All the Field Properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			CustomersHomeFrame chf=new CustomersHomeFrame(this.u);
			this.setVisible(false);
			chf.setVisible(true);
		}
	}
	
}