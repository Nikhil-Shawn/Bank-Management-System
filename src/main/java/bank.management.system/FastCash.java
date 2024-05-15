package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastCash extends JFrame implements ActionListener {

    JButton withdraw10, withdraw20, withdraw50, withdraw100, withdraw500, withdraw1000, back;
    String pinNumber;

    FastCash(String pinNumber){

        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel finalMainTransactionImage = new JLabel(i3);
        finalMainTransactionImage.setBounds(0, 0, 900, 800);
        add(finalMainTransactionImage);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(200, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.white);
        finalMainTransactionImage.add(text);

        withdraw10 = new JButton("€ 10");
        withdraw10.setBounds(170, 366,150, 30);
        withdraw10.addActionListener(this);
        finalMainTransactionImage.add(withdraw10);

        withdraw20 = new JButton("€ 20");
        withdraw20.setBounds(355, 366,150, 30);
        withdraw20.addActionListener(this);
        finalMainTransactionImage.add(withdraw20);

        withdraw50 = new JButton("€ 50");
        withdraw50.setBounds(170, 400,150, 30);
        withdraw50.addActionListener(this);
        finalMainTransactionImage.add(withdraw50);

        withdraw100 = new JButton("€ 100");
        withdraw100.setBounds(355, 400,150, 30);
        withdraw100.addActionListener(this);
        finalMainTransactionImage.add(withdraw100);

        withdraw500 = new JButton("€ 500");
        withdraw500.setBounds(170, 434,150, 30);
        withdraw500.addActionListener(this);
        finalMainTransactionImage.add(withdraw500);

        withdraw1000 = new JButton("€ 1000");
        withdraw1000.setBounds(355, 434,150, 30);
        withdraw1000.addActionListener(this);
        finalMainTransactionImage.add(withdraw1000);

        back = new JButton("Back");
        back.setBounds(355, 468,150, 30);
        back.addActionListener(this);
        finalMainTransactionImage.add(back);


        setSize(900,900);
        setUndecorated(true);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==back){
            System.exit(0);
        } else if (ae.getSource()== withdraw10) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource()==withdraw20) {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
