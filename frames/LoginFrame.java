package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class LoginFrame extends JFrame implements ActionListener
{
	private JLabel welcomeLabel, userIdLabel, passLabel;
	private JTextField userIdTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn, createAccountBtn, forgetPassBtn;
	private JPanel panel;
	private Account ac;
	private User u;
	
	public LoginFrame()
	{
		super("Welcome To KAM Bank PLC.");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.CYAN);;
		
		this.welcomeLabel = new JLabel("Welcome to KAM Bank PLC");
		Font welcomeFont = new Font("Arial", Font.BOLD, 30); 
		this.welcomeLabel.setFont(welcomeFont);
		this.welcomeLabel.setBounds(275, 100, 500, 60); 
		this.panel.add(welcomeLabel);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(350,210,60,20);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(350,240,250,30);
		this.panel.add(userIdTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(350,280,80,20);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(350,310,250,30);
		this.panel.add(passPF);
		
		this.loginBtn=new JButton("Login");
		this.loginBtn.setBounds(425,350,100,30);
		this.loginBtn.addActionListener(this);
		this.loginBtn.setBackground(new Color(135, 206, 235));
		this.panel.add(loginBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(20,20,80,30);
		this.exitBtn.addActionListener(this);
		this.exitBtn.setBackground(new Color(255,102,102));
		this.panel.add(exitBtn);
		
		this.createAccountBtn=new JButton("Create Account");
		this.createAccountBtn.setBounds(340,390,130,30);
		this.createAccountBtn.addActionListener(this);
		this.createAccountBtn.setBackground(Color.ORANGE);
		this.panel.add(createAccountBtn);
		
		this.forgetPassBtn=new JButton("Forget Password");
		this.forgetPassBtn.setBounds(480,390,130,30);
		this.forgetPassBtn.addActionListener(this);
		this.forgetPassBtn.setBackground(Color.ORANGE);
		this.panel.add(forgetPassBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			String uId=userIdTF.getText();
			String pass=passPF.getText();
			UserRepo urp=new UserRepo();
			User user=urp.searchUserByUserId(uId);
			if(user!=null)
			{
				if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==1)
				{
					AdminHomeFrame ahf=new AdminHomeFrame(user);
					this.setVisible(false);
					ahf.setVisible(true);
				}
				
				else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==2)
				{
					EmployeesHomeFrame ehf=new EmployeesHomeFrame(user);
					this.setVisible(false);
					ehf.setVisible(true);
				}
				
				else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==3)
				{
					CustomersHomeFrame chf=new CustomersHomeFrame(user);
					this.setVisible(false);
					chf.setVisible(true);
				}
				
				
				
				else
				{
					JOptionPane.showMessageDialog(this, "Wrong user Id or Password!", "WARNING!!!", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Wrong user Id or Password!", "WARNING!!!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(command.equals(createAccountBtn.getText()))
		{
			CreateAccountFrame caf=new CreateAccountFrame(this.u);
			this.setVisible(false);
			caf.setVisible(true);
		}
		
		if(command.equals(forgetPassBtn.getText()))
		{
			ForgetPassFrame fpf=new ForgetPassFrame();
			this.setVisible(false);
			fpf.setVisible(true);
		}
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	}
	
}
