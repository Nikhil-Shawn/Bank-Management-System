package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signUp, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        setTitle("GELDAUTOMAT");
        setLayout(null);

        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image scaledLogo = logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon scaledLogoImage = new ImageIcon(scaledLogo);
        JLabel label = new JLabel(scaledLogoImage);
        label.setBounds(50, 10, 100, 100);
        add(label);

        JLabel headTitle = new JLabel("Welcome to GELDAUTOMAT");
        headTitle.setFont(new Font("Osward", Font.BOLD, 34));
        headTitle.setBounds(150, 40, 500, 40);
        add(headTitle);

        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNo.setBounds(120, 150, 200, 40);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(320, 150, 250, 40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pinNo = new JLabel("PIN:");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 28));
        pinNo.setBounds(120, 220, 200, 28);
        add(pinNo);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(320, 220, 250, 40);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(320, 300, 100, 40);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(470, 300, 100, 40);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(320, 360, 250, 40);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.white);

        setSize(850, 550);
        setVisible(true);
        setLocation(350, 100);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            Connection conn = new Connection();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();

            String query = "select * from login where card_number = '"+cardNumber+"' and pin_number = '"+pinNumber+"'";
            try {
               ResultSet rs = conn.s.executeQuery(query);
               // next if lot of data we wait till it read
               if(rs.next()){
                   setVisible(false);
                   new Transaction(pinNumber).setVisible(true);
               } else {
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}