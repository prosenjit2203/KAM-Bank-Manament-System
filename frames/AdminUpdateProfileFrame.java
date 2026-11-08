package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AdminUpdateProfileFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, genderLabel, bloodGroupLabel, ageLabel, nidLable,addressLabel,cspLabel;//csp=CopmpanyShareParcentage
	private JTextField userTF, nameTF, genderTF, bloodGroupTF,ageTF,nidTF, addressTF, cspTF;
	private JButton addBtn, removeBtn, updateBtn, backBtn;
	private JPanel panel;
	private User u;
	private Admin admin;
	
	
	
	public AdminUpdateProfileFrame(User u)
	{
		super("Admin Update Profile");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		AdminRepo arp=new AdminRepo();
		this.admin=arp.searchAdminByUserId(u.getUserId());
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(170,50,100,30);
		this.userTF.setText(admin.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(170,100,100,30);
		this.nameTF.setText(admin.getName());
		this.nameTF.setEditable(false);
		this.panel.add(nameTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,150,60,30);
		this.panel.add(genderLabel);
		
		this.genderTF=new JTextField();
		this.genderTF.setBounds(170,150,100,30);
		this.genderTF.setText(admin.getGender());
		this.panel.add(genderTF);
		
		this.bloodGroupLabel=new JLabel("Blood Group:");
		this.bloodGroupLabel.setBounds(50,200,90,30);
		this.panel.add(bloodGroupLabel);
		
		this.bloodGroupTF=new JTextField();
		this.bloodGroupTF.setBounds(170,200,100,30);
		this.bloodGroupTF.setText(admin.getBloodGroup());
		this.panel.add(bloodGroupTF);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,250,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(170,250,100,30);
		this.ageTF.setText(String.valueOf(admin.getAge()));
		this.ageTF.setEditable(false);
		this.panel.add(ageTF);
		
		
		
		this.nidLable=new JLabel("NID:");
		this.nidLable.setBounds(50,300,60,30);
		this.panel.add(nidLable);
		
		this.nidTF=new JTextField();
		this.nidTF.setBounds(170,300,100,30);
		this.nidTF.setText(String.valueOf(admin.getNid()));
		this.nidTF.setEditable(false);
		this.panel.add(nidTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(50,350,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(170,350,100,30);
		this.addressTF.setText(admin.getAddress());
		this.panel.add(addressTF);
		
		
		this.cspLabel=new JLabel("Company Share:");
		this.cspLabel.setBounds(50,400,110,30);
		this.panel.add(cspLabel);
		
		this.cspTF=new JTextField();
		this.cspTF.setBounds(170,400,100,30);
		this.cspTF.setText(admin.getCompanyShareParcentage());
		this.cspTF.setEditable(false);
		this.panel.add(cspTF);
		
		
		this.updateBtn=new JButton("Update");
		this.updateBtn.setBounds(50,450,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		
		
		this.backBtn=new JButton("Back");
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
				admin.setBloodGroup(bloodGroupTF.getText());
				admin.setNid(nidTF.getText());
				admin.setAddress(addressTF.getText());
				AdminRepo arp=new AdminRepo();
				arp.updateAdmin(admin);
				JOptionPane.showMessageDialog(this,"Admin Updated Successfully");
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Properly");
			}
		}
		
		
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame adf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			adf.setVisible(true);
		}
	}
	
}