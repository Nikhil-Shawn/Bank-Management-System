package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit, withdrawal, miniStatement, pinChange, fastCash, balanceEnquiry, exit;

    Transaction(){

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel finalMainTransactionImage = new JLabel(i3);
        finalMainTransactionImage.setBounds(0, 0, 900, 800);
        add(finalMainTransactionImage);

        JLabel text = new JLabel("Please select your Transaction Type");
        text.setBounds(200, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        finalMainTransactionImage.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 366,150, 30);
        deposit.addActionListener(this);
        finalMainTransactionImage.add(deposit);

        withdrawal = new JButton("Cash Withdraw");
        withdrawal.setBounds(355, 366,150, 30);
        withdrawal.addActionListener(this);
        finalMainTransactionImage.add(withdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170, 400,150, 30);
        fastCash.addActionListener(this);
        finalMainTransactionImage.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355, 400,150, 30);
        miniStatement.addActionListener(this);
        finalMainTransactionImage.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170, 434,150, 30);
        pinChange.addActionListener(this);
        finalMainTransactionImage.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355, 434,150, 30);
        balanceEnquiry.addActionListener(this);
        finalMainTransactionImage.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 468,150, 30);
        exit.addActionListener(this);
        finalMainTransactionImage.add(exit);


        setSize(900,900);
        setUndecorated(true);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transaction();
    }
}
