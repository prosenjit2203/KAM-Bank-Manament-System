package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class ForgetPassFrame extends JFrame implements ActionListener
{
	private JLabel userIdLabel, securityQuesLabel, securityAnsLabel, passLabel;
	private JTextField userTF, securityAnsTF;
	private JPasswordField passPF;
	private JButton submitBtn, exitBtn, backBtn;
	private JPanel panel;
	
	public ForgetPassFrame()
	{
		super("Forget Password Frame");
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,20);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(120,45,100,30);
		this.panel.add(userTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your pet name?:");
		this.securityQuesLabel.setBounds(50,90,300,20);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(50,120,100,20);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(160,120,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("new Password:");
		this.passLabel.setBounds(50,160,100,20);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(160,160,100,30);
		this.panel.add(passPF);
		
		this.submitBtn=new JButton("Submit");
		this.submitBtn.setBounds(50,200,100,30);
		this.submitBtn.addActionListener(this);
		this.panel.add(submitBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(160,200,100,30);
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(270,200,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			if((!userTF.getText().isEmpty())&&(!securityAnsTF.getText().isEmpty())&&(!passPF.getText().isEmpty()))
			{
				String userId, securityAns, newPass;
				userId=userTF.getText();
				securityAns=securityAnsTF.getText();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(userId);
				if(user!=null)
				{
					if((user.getUserId().equals(userId))&&(user.getSecurityAns().equals(securityAns)))
					{
						user.setPassword(passPF.getText());
						urp.updateUser(user);
						JOptionPane.showMessageDialog(this,"Password changed successfully");
					}
					
					else
					{
						JOptionPane.showMessageDialog(this,"Wrong security Ans");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"User not Found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Fillup all the field");
			}
		}
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	}
	
}
