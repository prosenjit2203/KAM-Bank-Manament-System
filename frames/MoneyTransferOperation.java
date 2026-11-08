package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class MoneyTransferOperation extends JFrame implements ActionListener
{
	private JLabel moneyTransferIdLabel,senderAccNoLabel, receiverAccNoLabel,amountLabel;
	private JTextField senderAccNoTF, receiverAccNoTF,amountTF,moneyTransferIdTF;
	private JButton transferBtn, backBtn,searchByAccNoBtn,searchByMoneyTransferIdBtn;
	private JTable moneyTransferTable;
	private JScrollPane moneyTransferTableSP;
	private MoneyTransfer mt;
	private JPanel panel;
	private User u;
	
	
	
	public MoneyTransferOperation(MoneyTransfer mt)
	{
		super("Money Transfer Operation");
		this.setSize(1300,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		this.moneyTransferIdLabel=new JLabel("Money Transfer Id:");
		this.moneyTransferIdLabel.setBounds(50,50,110,30);
		this.panel.add(moneyTransferIdLabel);
		
		this.moneyTransferIdTF=new JTextField();
		this.moneyTransferIdTF.setBounds(210,50,100,30);
		this.panel.add(moneyTransferIdTF);
		
		this.senderAccNoLabel=new JLabel("Sender Account No:");
		this.senderAccNoLabel.setBounds(50,100,150,30);
		this.panel.add(senderAccNoLabel);
		
		this.senderAccNoTF=new JTextField();
		this.senderAccNoTF.setBounds(210,100,100,30);
		this.panel.add(senderAccNoTF);
		
		this.receiverAccNoLabel=new JLabel("Receiver Account No:");
		this.receiverAccNoLabel.setBounds(50,150,150,30);
		this.panel.add(receiverAccNoLabel);
		
		this.receiverAccNoTF=new JTextField();
		this.receiverAccNoTF.setBounds(210,150,100,30);
		this.panel.add(receiverAccNoTF);
		
		this.amountLabel=new JLabel("Amount:");
		this.amountLabel.setBounds(50,200,60,30);
		this.panel.add(amountLabel);
		
		this.amountTF=new JTextField();
		this.amountTF.setBounds(210,200,100,30);
		this.panel.add(amountTF);
		
		
		this.transferBtn=new JButton("Transfer");
		this.transferBtn.setBounds(65,300,100,30);
		this.transferBtn.addActionListener(this);
		this.panel.add(transferBtn);
		
		
		this.searchByAccNoBtn=new JButton("SearchByAccNo");
		this.searchByAccNoBtn.setBounds(175,300,150,30);
		this.searchByAccNoBtn.addActionListener(this);
		this.panel.add(searchByAccNoBtn);
		
		
		this.searchByMoneyTransferIdBtn=new JButton("SearchByMoneyTransferId");
		this.searchByMoneyTransferIdBtn.setBounds(335,300,200,30);
		this.searchByMoneyTransferIdBtn.addActionListener(this);
		this.panel.add(searchByMoneyTransferIdBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(545,300,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		MoneyTransferRepo mtrp=new MoneyTransferRepo();
		MoneyTransfer[] moneyTransferList=mtrp.getAllMoneyTransfer();
		String moneyTransferData1[][]=new String[moneyTransferList.length][4];
		for(int i=0;i<moneyTransferList.length;i++)
		{
		
			if(moneyTransferList[i]!=null)
			{
				System.out.println(moneyTransferList[i].toStringMoneyTransfer());
				moneyTransferData1[i][0]=moneyTransferList[i].getMoneyTransferId();
				moneyTransferData1[i][1]=moneyTransferList[i].getSenderAccNo();
				moneyTransferData1[i][2]=moneyTransferList[i].getReceiverAccNo();
				moneyTransferData1[i][3]=String.valueOf(moneyTransferList[i].getAmount());
				
				
			}
		}
			
			
			
		String head1[]={"TransferId","SenderAccNo","ReceiverAccNo","Amount"};
		this.moneyTransferTable=new JTable(moneyTransferData1,head1);
		this.moneyTransferTableSP=new JScrollPane(moneyTransferTable);
		this.moneyTransferTableSP.setBounds(50,380,700,200);
		this.moneyTransferTable.setEnabled(false);
		this.panel.add(moneyTransferTableSP);
		
		this.panel.revalidate();
		this.panel.repaint();
		
		this.add(panel);
		
		this.mt=mt;
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(transferBtn.getText()))
		{    
	        MoneyTransferRepo mtrp=new MoneyTransferRepo();
			String senderAccNo,receiverAccNo,moneyTransferId;
			moneyTransferId=moneyTransferIdTF.getText();
			senderAccNo = senderAccNoTF.getText();
            receiverAccNo = receiverAccNoTF.getText();
            double amount = 0;
            try 
			{
                amount = Double.parseDouble(amountTF.getText());
            } catch (Exception e) 
			{
                JOptionPane.showMessageDialog(this,"Invalid Amount","Massage",JOptionPane.WARNING_MESSAGE);
                return;
			}
			 MoneyTransfer mt = new MoneyTransfer(moneyTransferId,senderAccNo, receiverAccNo, amount);
			 mtrp.transfer(mt);
             JOptionPane.showMessageDialog(this,"Money Transfer Processed.");
		}
		
			if(command.equals(searchByAccNoBtn.getText()))
			{
				String senderAccNo,receiverAccNo;
			
				senderAccNo=senderAccNoTF.getText();
				receiverAccNo=receiverAccNoTF.getText();
				MoneyTransferRepo mtrp=new MoneyTransferRepo();
				MoneyTransfer[] mt = mtrp.searchByAccNo(senderAccNo);
				 mt = mtrp.searchByAccNo(receiverAccNo);
				StringBuilder result = new StringBuilder("Transactions for user ID " + senderAccNo + ":\n");
				result = new StringBuilder("Transactions for user ID " + receiverAccNo + ":\n");
				for (MoneyTransfer mtr : mt) 
				{
					if (mtr!=null) 
					{
						JOptionPane.showMessageDialog(this,"Found MoneyTransafer");
					}
					else if(mtr!=null)
					{
						JOptionPane.showMessageDialog(this,"Found MoneyTransafer");
					}
					
				}
				JOptionPane.showMessageDialog(this,"MoneyTransfer Not Found","Message",JOptionPane.ERROR_MESSAGE);
			}
			if(command.equals(searchByMoneyTransferIdBtn.getText()))
			{
				String moneyTransferId;
				moneyTransferId=moneyTransferIdTF.getText();
				MoneyTransferRepo mtrp=new MoneyTransferRepo();
				MoneyTransfer mt = mtrp.searchByMoneyTransferId(moneyTransferId);
				if (mt != null && mt.getMoneyTransferId().equals(moneyTransferId)) 
				{
					JOptionPane.showMessageDialog(this,"MoneyTransfer found ");
				} else 
				{
					JOptionPane.showMessageDialog(this,"MoneyTransferId not found.","Message",JOptionPane.ERROR_MESSAGE);
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