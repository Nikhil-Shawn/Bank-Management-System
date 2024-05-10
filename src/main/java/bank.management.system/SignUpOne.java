package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame {

    SignUpOne(){

        setLayout(null);

        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L)+1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO." + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 30));
        formNo.setBounds(185, 20, 500, 40);
        add(formNo);

        JLabel personalDetail = new JLabel("Page 1: Personal Details");
        personalDetail.setFont(new Font("Raleway", Font.BOLD, 30));
        personalDetail.setBounds(225, 80, 400, 30);
        add(personalDetail);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(220, 150, 100, 30);
        add(name);

        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.PLAIN, 20));
        nameTextField.setBounds(400, 150, 300, 30);
        add(nameTextField);

        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setFont(new Font("Raleway", Font.BOLD, 20));
        fatherName.setBounds(220, 190, 200, 30);
        add(fatherName);

        JTextField fatherTextField = new JTextField();
        fatherTextField.setFont(new Font("Raleway", Font.PLAIN, 20));
        fatherTextField.setBounds(400, 190, 300, 30);
        add(fatherTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(220, 230, 200, 30);
        add(dob);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(400, 230, 300, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(220, 270, 200, 30);
        add(gender);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(400, 270, 60, 30);
        male.setBackground(Color.white);
        add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(490, 270, 100, 30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(220, 310, 200, 30);
        add(email);

        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.PLAIN, 20));
        emailTextField.setBounds(400, 310, 300, 30);
        add(emailTextField);

        JLabel martial = new JLabel("Martial Status:");
        martial.setFont(new Font("Raleway", Font.BOLD, 20));
        martial.setBounds(220, 350, 200, 30);
        add(martial);

        JRadioButton single = new JRadioButton("Single");
        single.setBounds(400, 350, 80, 30);
        single.setBackground(Color.white);
        add(single);

        JRadioButton married = new JRadioButton("Married");
        married.setBounds(490, 350, 100, 30);
        married.setBackground(Color.white);
        add(married);

        ButtonGroup martialGroup = new ButtonGroup();
        martialGroup.add(single);
        martialGroup.add(married);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(220, 390, 200, 30);
        add(address);

        JTextField addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.PLAIN, 20));
        addressTextField.setBounds(400, 390, 300, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(220, 430, 200, 30);
        add(city);

        JTextField cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.PLAIN, 20));
        cityTextField.setBounds(400, 430, 300, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(220, 470, 200, 30);
        add(state);

        JTextField stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.PLAIN, 20));
        stateTextField.setBounds(400, 470, 300, 30);
        add(stateTextField);

        JLabel country = new JLabel("Country:");
        country.setFont(new Font("Raleway", Font.BOLD, 20));
        country.setBounds(220, 510, 200, 30);
        add(country);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(220, 550, 200, 30);
        add(pincode);

        JTextField pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.PLAIN, 20));
        pincodeTextField.setBounds(400, 550, 300, 30);
        add(pincodeTextField);

        JButton nextButton = new JButton("NEXT");
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButton.setBounds(600, 600, 100, 40);
        add(nextButton);

        getContentPane().setBackground(Color.white);
        setSize(850, 700);
        setLocation(350, 50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpOne();
    }

}
