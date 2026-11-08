package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class CheckBalanceFrame extends JFrame implements ActionListener 
{
    private JLabel userIdLabel, balanceLabel;
    private JTextField userIdTF;
    private JPanel panel;
    private JButton checkBtn, backBtn;
    private AccountRepo arp;
    private Account ac;
    private User u;

    public CheckBalanceFrame(Account ac,User u) 
    {
        super("Check Balance");
        this.setSize(1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.userIdLabel = new JLabel("User ID:");
        this.userIdLabel.setBounds(50, 50, 60, 30);
        this.panel.add(userIdLabel);

        this.userIdTF = new JTextField();
        this.userIdTF.setBounds(120, 50, 100, 30);
		this.userIdTF.setText(u.getUserId());
        this.userIdTF.setEditable(false);
        this.panel.add(userIdTF);

        this.checkBtn = new JButton("Check Balance");
        this.checkBtn.setBounds(120, 100, 150, 30);
        this.checkBtn.addActionListener(this);
        this.panel.add(checkBtn);

        this.balanceLabel = new JLabel("Balance:");
        this.balanceLabel.setBounds(50, 150, 400, 30);
        this.panel.add(balanceLabel);
        this.balanceLabel.setVisible(false);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(50, 200, 100, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);

        this.add(panel);
        this.setVisible(true);

        this.arp = arp;
        this.u = u;
        this.ac = ac;
    }

    public void actionPerformed(ActionEvent ae) 
    {
        String command = ae.getActionCommand();
        if (command.equals(checkBtn.getText())) 
        {
            if (!userIdTF.getText().isEmpty()) 
            {
                String userId = userIdTF.getText();
                AccountRepo arp = new AccountRepo();
                double balance = arp.checkBalance(userId);
                balanceLabel.setText("Balance for userId " + userId + ": " + balance);
                balanceLabel.setVisible(true);
            }
            else 
            {
                JOptionPane.showMessageDialog(this, "Please enter a User ID.");
            }
        } 
        else if (command.equals(backBtn.getText())) 
        {
            CustomersHomeFrame chf = new CustomersHomeFrame(this.u);
            this.setVisible(false);
            chf.setVisible(true);
        }
    }
}
