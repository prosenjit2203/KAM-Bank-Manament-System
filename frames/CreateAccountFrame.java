package frames;

import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class CreateAccountFrame extends JFrame implements ActionListener {
    private JLabel userIdLabel, balanceLabel, accNoLabel, statusLabel;
    private JTextField userIdTF, balanceTF, accNoTF, statusTF;
    private JButton addBtn, backBtn;
    private JPanel panel;
    private Account ac;
    private User u;

    public CreateAccountFrame(User u) {
        super("Add Account");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.accNoLabel = new JLabel("AccNo:");
        this.accNoLabel.setBounds(50, 50, 100, 30);
        this.panel.add(accNoLabel);

        this.accNoTF = new JTextField();
        this.accNoTF.setBounds(150, 50, 150, 30);
        this.panel.add(accNoTF);

        this.userIdLabel = new JLabel("UserId:");
        this.userIdLabel.setBounds(50, 100, 100, 30);
        this.panel.add(userIdLabel);

        this.userIdTF = new JTextField();
        this.userIdTF.setBounds(150, 100, 150, 30);
        this.panel.add(userIdTF);

        this.statusLabel = new JLabel("Status:");
        this.statusLabel.setBounds(50, 150, 100, 30);
        this.panel.add(statusLabel);

        this.statusTF = new JTextField();
        this.statusTF.setBounds(150, 150, 150, 30);
        this.panel.add(statusTF);

        this.balanceLabel = new JLabel("Balance:");
        this.balanceLabel.setBounds(50, 200, 100, 30);
        this.panel.add(balanceLabel);

        this.balanceTF = new JTextField();
        this.balanceTF.setBounds(150, 200, 150, 30);
        this.panel.add(balanceTF);

        this.addBtn = new JButton("Create Account");
        this.addBtn.setBounds(150, 250, 150, 30);
        this.addBtn.addActionListener(this);
        this.panel.add(addBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(320, 250, 100, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);

        this.add(panel);
        this.u = u;
    }

    public void actionPerformed(ActionEvent ae) 
	{
        String command = ae.getActionCommand();

        if (command.equals(addBtn.getText())) 
		{
            String accNo, userId, status;
            double balance;

            if (!userIdTF.getText().isEmpty() && !accNoTF.getText().isEmpty() && !statusTF.getText().isEmpty() && !balanceTF.getText().isEmpty()) {
                userId = userIdTF.getText();
                AccountRepo arp = new AccountRepo();
                Account existingAccount = arp.searchAccountByUserId(userId);
                if (existingAccount == null) 
				{
                    try 
					{
                        accNo = accNoTF.getText();
                        status = statusTF.getText();
                        balance = Double.parseDouble(balanceTF.getText());

                        Account newAccount = new Account(accNo, userId, status, balance);
                        arp.createAccount(newAccount);
                        JOptionPane.showMessageDialog(this, "Account Created Successfully");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Invalid balance. Please provide a valid number.","Massage",JOptionPane.ERROR_MESSAGE);
                    }
                } else 
				{
                    JOptionPane.showMessageDialog(this, "User Id Already Exists.");
                }
            } 
			else 
			{
                JOptionPane.showMessageDialog(this, "Please Fill Up All The Fields Properly","Massage",JOptionPane.WARNING_MESSAGE);
            }
        } 
		else if (command.equals(backBtn.getText())) 
		{
            LoginFrame lf = new LoginFrame();
            this.setVisible(false);
            lf.setVisible(true);
        }
    }

}
