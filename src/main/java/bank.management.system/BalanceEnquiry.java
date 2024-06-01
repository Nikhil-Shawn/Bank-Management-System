package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
     String pinNumber;

     JButton back;

    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel mainImage = new JLabel(i3);
        mainImage.setBounds(0, 0, 900, 900);
        add(mainImage);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        mainImage.add(back);

        Connection conn = new Connection();
        int balance = 0;
        try {
            ResultSet account = conn.s.executeQuery("select * from bank where pin_number ='" + pinNumber + "'");
            while (account.next()) {
                if (account.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(account.getString("amount"));
                } else {
                    balance -= Integer.parseInt(account.getString("amount"));
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "An error occured " +e.getMessage());
        }

        JLabel currentBalanceText = new JLabel("Your current Account Balance is Euro " + balance);
        currentBalanceText.setBounds(170, 300, 400, 30);
        currentBalanceText.setForeground(Color.white);
        mainImage.add(currentBalanceText);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        setVisible(false);
        new Transaction(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
