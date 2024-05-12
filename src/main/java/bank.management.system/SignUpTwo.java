package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUpTwo extends JFrame implements ActionListener {

    JTextField passportTextField, registrationNoTextField;
    JButton nextButton;
    JRadioButton seniorCitizenYes, seniorCitizenNo, existingAccountYes, existingAccountNo;
    JComboBox religionBox, incomeBox, incomeCostBox, educationQualificationBox, occupationBox;
    String formNo;

    SignUpTwo(String formNo){

        this.formNo = formNo;

        setLayout(null);
        setTitle("APPLICATION FORM - PAGE 2");

        JLabel additionalDetail = new JLabel("Page 2: Additional Details");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD, 30));
        additionalDetail.setBounds(225, 80, 400, 30);
        add(additionalDetail);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(220, 150, 100, 30);
        add(religion);

        String[] valReligion = {"Christian", "Buddhism", "Hindu","Islam"};
        religionBox = new JComboBox<>(valReligion);
        religionBox.setBounds(400, 150, 300, 30);
        religionBox.setBackground(Color.white);
        add(religionBox);

        JLabel incomeClass = new JLabel("Income Class:");
        incomeClass.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeClass.setBounds(220, 190, 200, 30);
        add(incomeClass);

        String[] valIncomeClass = {"Upper", "Medium", "Lower"};
        incomeBox = new JComboBox<>(valIncomeClass);
        incomeBox.setBounds(400, 190, 300, 30);
        incomeBox.setBackground(Color.white);
        add(incomeBox);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(220, 230, 200, 30);
        add(income);

        String[] valIncome = {"< $ 20000", "< $ 50000", "< $ 100000", "Above $100000"};
        incomeCostBox = new JComboBox<>(valIncome);
        incomeCostBox.setBounds(400, 230, 300, 30);
        incomeCostBox.setBackground(Color.white);
        add(incomeCostBox);

        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(220, 270, 200, 30);
        add(education);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(220, 310, 200, 30);
        add(qualification);

        String[] valEducationQualification = {"Non Graduate", "Graduate", "Post Graduate", "PhD", "Other"};
        educationQualificationBox = new JComboBox<>(valEducationQualification);
        educationQualificationBox.setBounds(400, 310, 300, 30);
        educationQualificationBox.setBackground(Color.white);
        add(educationQualificationBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(220, 350, 200, 30);
        add(occupation);

        String[] valOccupation = {"Salaried", "Self-Employed", "Student", "Business","Retired", "Other"};
        occupationBox = new JComboBox<>(valOccupation);
        occupationBox.setBounds(400, 350, 300, 30);
        occupationBox.setBackground(Color.white);
        add(occupationBox);

        JLabel passport = new JLabel("Passport No:");
        passport.setFont(new Font("Raleway", Font.BOLD, 20));
        passport.setBounds(220, 390, 200, 30);
        add(passport);

        passportTextField = new JTextField();
        passportTextField.setFont(new Font("Raleway", Font.PLAIN, 20));
        passportTextField.setBounds(400, 390, 300, 30);
        add(passportTextField);

        JLabel registrationNo = new JLabel("Registration No:");
        registrationNo.setFont(new Font("Raleway", Font.BOLD, 20));
        registrationNo.setBounds(220, 430, 200, 30);
        add(registrationNo);

        registrationNoTextField = new JTextField();
        registrationNoTextField.setFont(new Font("Raleway", Font.PLAIN, 20));
        registrationNoTextField.setBounds(400, 430, 300, 30);
        add(registrationNoTextField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(220, 470, 200, 30);
        add(seniorCitizen);

        seniorCitizenYes = new JRadioButton("Yes");
        seniorCitizenYes.setBounds(400, 470, 80, 30);
        seniorCitizenYes.setBackground(Color.white);
        add(seniorCitizenYes);

        seniorCitizenNo = new JRadioButton("No");
        seniorCitizenNo.setBounds(490, 470, 100, 30);
        seniorCitizenNo.setBackground(Color.white);
        add(seniorCitizenNo);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(seniorCitizenYes);
        seniorCitizenGroup.add(seniorCitizenNo);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(220, 510, 200, 30);
        add(existingAccount);

        existingAccountYes = new JRadioButton("Yes");
        existingAccountYes.setBounds(400, 510, 80, 30);
        existingAccountYes.setBackground(Color.white);
        add(existingAccountYes);

        existingAccountNo = new JRadioButton("No");
        existingAccountNo.setBounds(490, 510, 100, 30);
        existingAccountNo.setBackground(Color.white);
        add(existingAccountNo);

        ButtonGroup existingAccountGroup = new ButtonGroup();
        existingAccountGroup.add(existingAccountYes);
        existingAccountGroup.add(existingAccountNo);

        nextButton = new JButton("NEXT");
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButton.setBounds(600, 600, 100, 40);
        nextButton.addActionListener(this);
        add(nextButton);

        getContentPane().setBackground(Color.white);
        setSize(850, 700);
        setLocation(350, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String religion = (String) religionBox.getSelectedItem();
        String incomeClass = (String) incomeBox.getSelectedItem();
        String income = (String) incomeCostBox.getSelectedItem();
        String educationalQualification = (String) educationQualificationBox.getSelectedItem();
        String occupation = (String) occupationBox.getSelectedItem();

        String seniorCitizen = null;
        if(seniorCitizenYes.isSelected()){
            seniorCitizen = "Yes";
        } else if (seniorCitizenNo.isSelected()) {
            seniorCitizen = "No";
        }

        String existingAccount = null;
        if(existingAccountYes.isSelected()){
            existingAccount = "Yes";
        } else if (existingAccountNo.isSelected()) {
            existingAccount = "No";
        }

        String passport = passportTextField.getText();
        String registration = registrationNoTextField.getText();

        try{
            if(passport.isEmpty()){
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Connection con = new Connection();
                String query = "insert into signuptwo values('"+formNo+"','"+religion+"','"+incomeClass+"','"+income+"','"+educationalQualification+"','"+occupation+"','"+passport+"','"+registration+"','"+seniorCitizen+"','"+existingAccount+"')";
                System.out.println("query executed successfully");
                con.s.executeUpdate(query);

                //SignUp3 Object
                setVisible(false);
                new SignUpThree(formNo).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public static void main(String[] args) {
        new SignUpTwo("");
    }

}
