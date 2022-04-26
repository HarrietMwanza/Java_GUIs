import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class mainFrame implements ActionListener {
    JFrame frame;
    String[] gender = { "Male", "Female" };
    JLabel nameLabel = new JLabel("NAME");
    JLabel gradeNameLabel = new JLabel("GRADE OUT OF 20");
    JLabel emailLabel = new JLabel("EMAIL");
    JTextField nameTextField = new JTextField();
    JComboBox genderComboBox = new JComboBox(gender);
    JTextField gradeTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JTextField countryTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JButton registerButton = new JButton("REGISTER");
    JButton resetButton = new JButton("RESET");

    mainFrame() {

        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    // we initialize the frame here
    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("STUDENT SIGNUP Form TO ALU");
        frame.setBounds(40, 40, 380, 600);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {
        nameLabel.setBounds(20, 20, 40, 70);
        gradeNameLabel.setBounds(20, 120, 100, 70);
        emailLabel.setBounds(20, 320, 100, 70);
        nameTextField.setBounds(180, 43, 165, 23);
        genderComboBox.setBounds(180, 93, 165, 23);
        gradeTextField.setBounds(180, 143, 165, 23);
        passwordField.setBounds(180, 193, 165, 23);
        confirmPasswordField.setBounds(180, 243, 165, 23);
        countryTextField.setBounds(180, 293, 165, 23);
        emailTextField.setBounds(180, 343, 165, 23);
        registerButton.setBounds(70, 400, 100, 35);
        resetButton.setBounds(220, 400, 100, 35);
    }

    public void addComponentsToFrame() {
        frame.add(nameLabel);
        frame.add(gradeNameLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(gradeTextField);
        frame.add(passwordField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }

    public void actionEvent() {
        // Adding Action Listener to buttons
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    // class with an handler and action listener to assign programs when students
    // enter their grades
    // if student has a grade between 18 and 20, they are assigned to the CS program
    // and we have a message to tell them and a student number is given to them
    // having the year and unique number
    // if student has a grade between 15 and 17 , they are assigned to the GC
    // program and we have a message to tell them and a student number is given to
    // them having the year and unique number
    // if student has a grade between 12 and 14 , they are assigned to the IBT
    // program and we have a message to tell them and a student number is given to
    // them having the year and unique number
    // if student has a grade less than 12 they are not assigned to any program and

    class gradehandler implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String grade = gradeTextField.getText();
            int gradeInt = Integer.parseInt(grade);
            if (gradeInt >= 18 && gradeInt <= 20) {
                JOptionPane.showMessageDialog(null, "You are assigned to the CS program");
            } else if (gradeInt >= 15 && gradeInt <= 17) {
                JOptionPane.showMessageDialog(null, "You are assigned to the GC program");
            } else if (gradeInt >= 12 && gradeInt <= 14) {
                JOptionPane.showMessageDialog(null, "You are assigned to the IBT program");
            } else if (gradeInt < 12) {
                JOptionPane.showMessageDialog(null, "You are not assigned to any program");

            }

        }
        // once student registers, we have a message to tell them that they have been
        // registered and a student number is given to them having the year and unique
        // number
        // we also have a message to tell them that they have been registered and a
        // student number is given to them having the year and unique number
        // we assign a student id number using the year and a unique number and showoing
        // it to the student
        // assign a student an id

        class registerhandler implements ActionListener {
            public void actionPerformed(ActionEvent ae)
            {
                String name = nameTextField.getText();
                String name;
                String stu_id;
                int score;

            public registerhandler() {
                    this(" ", " ", 0);

            public registerhandler(String initName, String initId, int initScore) {
                String name = initName;
                String stu_id = initId;

                for (int i = 0; i < n; i++) {
                    name = nameTextField.getText();
                    String year;
                    stu_id = name + year + i;
                    System.out.println(stu_id);
                    // joptionpane to show the student id to the student
                    JOptionPane.showMessageDialog(null, "You have been registered and your student id is " + stu_id);

                }
            }
        }

    }

    public static void main(String[] args) {
        mainFrame mainFrame = new mainFrame();
        mainFrame.createWindow();

    }

}