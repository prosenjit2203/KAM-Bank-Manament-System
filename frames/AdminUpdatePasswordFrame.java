package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AdminUpdatePasswordFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel,currentPassLabel, newPassLabel;
	private JTextField userIdTF;
	private JPasswordField currentPassPF,newPassPF;
	private JButton confirmBtn, backBtn;
	private JPanel panel;
	private User u;
	
	
	
	public AdminUpdatePasswordFrame(User u)
	{
		super("Admin Update Password ");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(120,50,100,30);
		this.userIdTF.setText(u.getUserId());
		this.userIdTF.setEditable(false);
		this.panel.add(userIdTF);
		
		this.currentPassLabel=new JLabel("Current Password:");
		this.currentPassLabel.setBounds(50,120,200,30);
		this.panel.add(currentPassLabel);
		
		this.currentPassPF=new JPasswordField();
		this.currentPassPF.setBounds(500,120,100,30);
		this.panel.add(currentPassPF);
		
		this.newPassLabel=new JLabel("New Password:");
		this.newPassLabel.setBounds(50,150,150,30);
		this.panel.add(newPassLabel);
		
		this.newPassPF=new JPasswordField();
		this.newPassPF.setBounds(180,150,100,30);
		this.panel.add(newPassPF);
		
		
		
		
		this.confirmBtn=new JButton("Confirm");
		this.confirmBtn.setBounds(50,200,120,30);
		this.confirmBtn.addActionListener(this);
		this.panel.add(confirmBtn);
		
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(190,200,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		
		this.add(panel);
		
		this.u=u;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		
		if(command.equals(confirmBtn.getText()))
		{
			if((!currentPassPF.getText().isEmpty()) && (!newPassPF.getText().isEmpty()))
			{
				
				if(currentPassPF.getText().equals(u.getPassword()))
				{
					
					u.setPassword(newPassPF.getText());
					UserRepo urp=new UserRepo();
					urp.updateUser(u);
					JOptionPane.showMessageDialog(this,"Password Updated Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Password Dosen't Match!!!");
				}
		
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