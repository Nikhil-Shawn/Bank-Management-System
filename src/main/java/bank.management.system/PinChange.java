package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JTextField pin, repin;
    JButton change, back;

    PinChange(String pinchange){
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel mainImage = new JLabel(i3);
        mainImage.setBounds(0,0, 900,900);
        add(mainImage);

        JLabel changePin = new JLabel("CHANGE YOUR PIN");
        changePin.setForeground(Color.white);
        changePin.setFont(new Font("System", Font.BOLD, 16));
        changePin.setBounds(250, 280, 500,35);
        mainImage.add(changePin);

        JLabel newPin = new JLabel("NEW PIN");
        newPin.setForeground(Color.white);
        newPin.setFont(new Font("System", Font.BOLD, 16));
        newPin.setBounds(165, 320, 180,25);
        mainImage.add(newPin);

        pin = new JTextField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        mainImage.add(pin);

        JLabel renewPin = new JLabel("RE-ENTER NEW PIN");
        renewPin.setForeground(Color.white);
        renewPin.setFont(new Font("System", Font.BOLD, 16));
        renewPin.setBounds(165, 360, 180,25);
        mainImage.add(renewPin);

        repin = new JTextField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        mainImage.add(repin);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        mainImage.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        mainImage.add(back);

        setSize(900, 900);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed (ActionEvent ae){

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
