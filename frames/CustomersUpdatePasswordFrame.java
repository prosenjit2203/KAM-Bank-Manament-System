package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class CustomersUpdatePasswordFrame extends JFrame implements ActionListener
{
    private JLabel userIdLabel, currentPassLabel, newPassLabel;
    private JTextField userTF;
    private JPasswordField currentPassPF, newPassPF;
    private JButton confirmBtn, backBtn;
    private JPanel panel;
    private User u;

    public CustomersUpdatePasswordFrame(User u)
    {
        super("Customers Update Password");
        this.setSize(600, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.userIdLabel = new JLabel("User Id:");
        this.userIdLabel.setBounds(50, 50, 120, 30);
        this.panel.add(userIdLabel);

        this.userTF = new JTextField();
        this.userTF.setBounds(180, 50, 150, 30);
        this.userTF.setText(u.getUserId());
        this.userTF.setEditable(false);
        this.panel.add(userTF);

        this.currentPassLabel = new JLabel("Current Password:");
        this.currentPassLabel.setBounds(50, 100, 120, 30);
        this.panel.add(currentPassLabel);

        this.currentPassPF = new JPasswordField();
        this.currentPassPF.setBounds(180, 100, 150, 30);
        this.panel.add(currentPassPF);

        this.newPassLabel = new JLabel("New Password:");
        this.newPassLabel.setBounds(50, 150, 120, 30);
        this.panel.add(newPassLabel);

        this.newPassPF = new JPasswordField();
        this.newPassPF.setBounds(180, 150, 150, 30);
        this.panel.add(newPassPF);

        this.confirmBtn = new JButton("Confirm");
        this.confirmBtn.setBounds(50, 200, 120, 30);
        this.confirmBtn.addActionListener(this);
        this.panel.add(confirmBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(210, 200, 120, 30);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);

        this.add(panel);
        this.u = u;
    }

    public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();

        if(command.equals(confirmBtn.getText()))
        {
            if((!currentPassPF.getText().isEmpty()) && (!newPassPF.getText().isEmpty()))
            {
                if(currentPassPF.getText().equals(u.getPassword()))
                {
                    u.setPassword(newPassPF.getText());
                    UserRepo urp = new UserRepo();
                    urp.updateUser(u);
                    JOptionPane.showMessageDialog(this, "Password Updated Successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Current Password Doesn't Match!!!");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please Fill Up All The Fields Properly");
            }
        }

        if(command.equals(backBtn.getText()))
        {
            CustomersHomeFrame chf = new CustomersHomeFrame(this.u);
            this.setVisible(false);
            chf.setVisible(true);
        }
    }
}
