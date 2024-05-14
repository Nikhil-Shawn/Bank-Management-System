package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pinNumber;

    Deposit(String pinNumber){

        this.pinNumber = pinNumber;
        setLayout(null);
        setUndecorated(true);

        ImageIcon l1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image l2 = l1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon l3 = new ImageIcon(l2);
        JLabel bgImage = new JLabel(l3);
        bgImage.setBounds(0,0, 900, 900);
        add(bgImage);

        JLabel headingText = new JLabel("Enter the amount you want to deposit");
        headingText.setForeground(Color.white);
        headingText.setFont(new Font("Raleway",Font.BOLD, 16));
        headingText.setBounds(170,300,400,20);
        bgImage.add(headingText);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD, 16));
        amount.setBounds(170,350,320,25);
        bgImage.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355, 483, 150, 30);
        deposit.addActionListener(this);
        bgImage.add(deposit);

        back = new JButton("Back");
        back.setBounds(355, 518, 150, 30);
        back.addActionListener(this);
        bgImage.add(back);

        setSize(900,900);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==deposit){
            String depositedAmount = amount.getText();
// Get the current date
            Date currentDate = new Date();
// Define the date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
// Format the date
            String formattedDate = dateFormat.format(currentDate);
// Convert the formatted date string to a Timestamp object
            Timestamp date = Timestamp.valueOf(formattedDate);
            if(depositedAmount.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter valid amount (More than 1)");
            }else {
                Connection conn = new Connection();
                String query = "insert into bank values('"+pinNumber+"','"+date+"', 'Deposit', '"+depositedAmount+"')";
                try{
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Amount "+depositedAmount+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
