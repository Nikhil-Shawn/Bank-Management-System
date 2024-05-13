package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class Transaction extends JFrame {

    Transaction(){

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel finalMainTransactionImage = new JLabel(i3);
        finalMainTransactionImage.setBounds(0, 0, 900, 800);
        add(finalMainTransactionImage);

        setSize(900,800);
        setLocation(350,10);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Transaction();
    }
}
