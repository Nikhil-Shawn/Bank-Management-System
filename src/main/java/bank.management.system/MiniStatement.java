package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinNumber;

    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);


        JLabel bank = new JLabel("Bank of Nikhil");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 600, 200);
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 320, 20);
        add(balance);

        try{
            Connection connection = new Connection();
            ResultSet rs = connection.s.executeQuery("Select * from login where pin_number = '"+pinNumber+"'");
            while (rs.next()){
                card.setText("Card Number: " + rs.getString("card_number").substring(0, 4) + "-XXXX-XXXX-" + rs.getString("card_number").substring(12));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }

        try{
            Connection connection = new Connection();
            int bal = 0;
            ResultSet rs = connection.s.executeQuery("Select * from bank where pin_number = '"+pinNumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }

            }
            balance.setText("Your current account balance is Euro " + bal);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }


        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
