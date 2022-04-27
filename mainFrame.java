import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class mainFrame {
    JFrame frame;
    String[] gender = { "Male", "Female" };
    JLabel nameLabel = new JLabel("NAME");
    JLabel gradeNameLabel = new JLabel("GRADE");
    JLabel emailLabel = new JLabel("EMAIL");
    JTextField nameTextField = new JTextField();
    JTextField gradeTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JButton registerButton = new JButton("REGISTER");
    JButton resetButton = new JButton("RESET");

    mainFrame() {

        createWindow();
        setLocationAndSize();
        addComponentsToFrame();

    }

    // we initialize the frame here
    public void createWindow() {
        frame = new JFrame();
        frame.setTitle("STUDENT SIGNUP Form TO ALU");
        frame.setBounds(40, 40, 380, 600);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void setLocationAndSize() {
        nameLabel.setBounds(20, 20, 40, 70);
        gradeNameLabel.setBounds(20, 120, 100, 70);
        emailLabel.setBounds(20, 320, 200, 70);
        nameTextField.setBounds(180, 43, 165, 50);
        gradeTextField.setBounds(180, 143, 165, 50);
        emailTextField.setBounds(180, 343, 165, 50);
        registerButton.setBounds(70, 400, 100, 35);
        // add action - registerUser()
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        resetButton.setBounds(220, 400, 100, 35);
    }

    public void addComponentsToFrame() {
        frame.add(nameLabel);
        frame.add(gradeNameLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(gradeTextField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }

    public void registerUser() {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String grade = gradeTextField.getText();
        int gradeInt = Integer.parseInt(grade);
        String major = "";
        if (gradeInt >= 18 && gradeInt <= 20) {
            major = "CS";
        } else if (gradeInt >= 15 && gradeInt <= 17) {
            major = "GC";
        } else if (gradeInt >= 12 && gradeInt <= 14) {
            major = "IBT";
        } else if (gradeInt < 12) {
            JOptionPane.showMessageDialog(null, "You are not assigned to any program");
        }

        //
        System.out.println(name + " " + email + " " + grade + " " + major);
        insertTo(email, grade, major);
    }

    public void insertTo(String email, String grade, String major) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Liplan2020");
            Statement stmt = con.createStatement();
            String query = "INSERT INTO students (email, grade, major) VALUES ('" + email + "', '"
                    + grade + "', '" + major + "')";
            //TODO: call program
            new program();
            program program = new program();
            program.initialize();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "You have successfully registered for " + major + " program");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    public static void main(String[] args) {
        mainFrame mainFrame = new mainFrame();
        // mainFrame.createWindow();

    }

}