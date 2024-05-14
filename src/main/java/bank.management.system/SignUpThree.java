package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {

    JRadioButton savingAccount, fixedDepositAccount, currentAccount, recurringDepositAccount;
    JCheckBox atm, internetBanking, mobileBanking, emailAlert, checkBook, estatement, agreement;
    JButton submit, cancel;
    String formNo;

    SignUpThree(String formNo){

        this.formNo = formNo;

        setLayout(null);

        JLabel title = new JLabel("Page 3: Account Details");
        title.setFont(new Font("Raleway", Font.BOLD, 22));
        title.setBounds(280, 40, 400, 40);
        add(title);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100, 140, 200, 30);
        add(accountType);

        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        savingAccount.setBounds(100, 180, 200, 30);
        savingAccount.setBackground(Color.white);
        add(savingAccount);

        fixedDepositAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        fixedDepositAccount.setBounds(350, 180, 250, 30);
        fixedDepositAccount.setBackground(Color.white);
        add(fixedDepositAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        currentAccount.setBounds(100, 220, 200, 30);
        currentAccount.setBackground(Color.white);
        add(currentAccount);

        recurringDepositAccount = new JRadioButton("Recurring Deposit Account");
        recurringDepositAccount.setFont(new Font("Raleway", Font.BOLD, 16));
        recurringDepositAccount.setBounds(350, 220, 250, 30);
        recurringDepositAccount.setBackground(Color.white);
        add(recurringDepositAccount);

        ButtonGroup groupAccountType = new ButtonGroup();
        groupAccountType.add(savingAccount);
        groupAccountType.add(fixedDepositAccount);
        groupAccountType.add(currentAccount);
        groupAccountType.add(recurringDepositAccount);

        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 270, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4141");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 270, 300, 30);
        add(number);

        JLabel cardInfo = new JLabel("Your 16 Digit Card Number");
        cardInfo.setFont(new Font("Raleway", Font.BOLD, 14));
        cardInfo.setBounds(100, 290, 200, 30);
        add(cardInfo);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 350, 200, 30);
        add(pin);

        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNumber.setBounds(330, 350, 300, 30);
        add(pinNumber);

        JLabel pinInfo = new JLabel("Your 4 Digit Pin Number");
        pinInfo.setFont(new Font("Raleway", Font.BOLD, 14));
        pinInfo.setBounds(100, 370, 200, 30);
        add(pinInfo);

        JLabel serviceRequired = new JLabel("Services  Required: ");
        serviceRequired.setFont(new Font("Raleway", Font.BOLD, 22));
        serviceRequired.setBounds(100, 430, 300, 30);
        add(serviceRequired);

        atm = new JCheckBox("ATM CARD");
        atm.setBackground(Color.white);
        atm.setFont(new Font("Raleway", Font.BOLD, 14));
        atm.setBounds(100, 470, 150, 30);
        add(atm);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.white);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 14));
        internetBanking.setBounds(250, 470, 150, 30);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.white);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 14));
        mobileBanking.setBounds(100, 510, 150, 30);
        add(mobileBanking);

        emailAlert = new JCheckBox("Email & SMS Alerts");
        emailAlert.setBackground(Color.white);
        emailAlert.setFont(new Font("Raleway", Font.BOLD, 14));
        emailAlert.setBounds(250, 510, 200, 30);
        add(emailAlert);

        checkBook = new JCheckBox("Cheque Book");
        checkBook.setBackground(Color.white);
        checkBook.setFont(new Font("Raleway", Font.BOLD, 14));
        checkBook.setBounds(100, 550, 150, 30);
        add(checkBook);

        estatement = new JCheckBox("E-Statement");
        estatement.setBackground(Color.white);
        estatement.setFont(new Font("Raleway", Font.BOLD, 14));
        estatement.setBounds(250, 550, 200, 30);
        add(estatement);

        agreement = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        agreement.setBackground(Color.white);
        agreement.setFont(new Font("Raleway", Font.BOLD, 12));
        agreement.setBounds(100, 600, 600, 30);
        add(agreement);

        submit = new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 650, 100, 40);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(450, 650, 100, 40);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850, 750);
        getContentPane().setBackground(Color.white);
        setLocation(350, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(savingAccount.isSelected()){
                accountType = "Saving Account";
            } else if (fixedDepositAccount.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (currentAccount.isSelected()) {
                accountType = "Current Account";
            } else if (recurringDepositAccount.isSelected())   {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040901000000000L);

            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 10000L);

            String facility = "";
            if (atm.isSelected()) {
                facility += " ATM Card";
            }
            if (internetBanking.isSelected()) {
                if (!facility.isEmpty()) {
                    facility += ",";
                }
                facility += " Internet Banking";
            }
            if (mobileBanking.isSelected()) {
                if (!facility.isEmpty()) {
                    facility += ",";
                }
                facility += " Mobile Banking";
            }
            if (emailAlert.isSelected()) {
                if (!facility.isEmpty()) {
                    facility += ",";
                }
                facility += " Email & SMS Alerts";
            }
            if (checkBook.isSelected()) {
                if (!facility.isEmpty()) {
                    facility += ",";
                }
                facility += " Cheque Book";
            }
            if (estatement.isSelected()) {
                if (!facility.isEmpty()) {
                    facility += ",";
                }
                facility += " E-Statement";
            }


            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                } else {
                    Connection conn = new Connection();
                    String query = "insert into signupthree values('"+formNo+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String queryLogin = "insert into login values('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";
                    conn.s.execute(query);
                    System.out.println("Sign Up Query executed successfully");
                    conn.s.execute(queryLogin);
                    System.out.println("Login Query executed successfully");

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n PIN: " + pinNumber);

                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new SignUpThree("");
    }
}
