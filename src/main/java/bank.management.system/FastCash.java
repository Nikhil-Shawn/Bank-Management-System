package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        } else {
           String amount = ((JButton)ae.getSource()).getText().substring(2);
           Connection conn = new Connection();
           try{
               ResultSet account = conn.s.executeQuery("select * from bank where pin_number ='"+pinNumber+"'");
               int balance = 0;
               while (account.next()){
                   if(account.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(account.getString("amount"));
                   } else {
                       balance -= Integer.parseInt(account.getString("amount"));
                   }
               }

               if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }

               Date currentDate = new Date();
               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               String formattedDate = simpleDateFormat.format(currentDate);
               Timestamp date = Timestamp.valueOf(formattedDate);

               String query = "INSERT INTO bank (pin_number, date, type, amount) VALUES (?, ?, ?, ?)";
               PreparedStatement pstmt = conn.s.getConnection().prepareStatement(query);
               pstmt.setString(1, pinNumber);
               pstmt.setTimestamp(2, date);
               pstmt.setString(3, "Withdraw");
               pstmt.setInt(4, Integer.parseInt(amount));
               pstmt.executeUpdate();
               JOptionPane.showMessageDialog(null,"€ "+amount+" Debited Successfully");

               setVisible(false);
               new Transaction(pinNumber).setVisible(true);
           }catch (Exception e){
               System.out.println(e);
           }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
