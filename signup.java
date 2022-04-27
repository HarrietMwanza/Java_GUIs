import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class signup {

    // Create a new JFrame object
    // we create variables for the components

    JFrame frame;
    JTextField tfName;
    JTextField tfPassword;
    JTextField tfConfirmPassword;
    JButton btnSignup;
    JButton btnCancel;

    // constructor - create the frame and add the components to it

    public signup() {
        // create labels for name, password and confirm password
        JLabel lblName = new JLabel("Email");
        JLabel lblPassword = new JLabel("Password");
        JLabel lblConfirmPassword = new JLabel("Confirm Password");

        // we set the size and location of the labels using setBounds() method
        lblName.setBounds(10, 10, 100, 30);
        lblPassword.setBounds(10, 50, 100, 30);
        lblConfirmPassword.setBounds(10, 100, 150, 30);

        // we add the labels to the frame using add() method

        // we have buttons for signup, login, and logout and a label to display the
        // message to the user

        // add buttons to the frame and label to the frame
        // signup = new JButton("Sign Up");
        // we add action listener and action performed method to the signuo and cancel
        // buttons

        // btnSignup.addActionListener (new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // // TODO Auto-generated method stub
        // signup signup = new signup();
        // signup.signup();

        // }
        // });

        // JButton cancel = new JButton("Cancel");
        // cancel.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // // TODO Auto-generated method stub
        // JOptionPane.showMessageDialog(signup.this, "You have cancelled the signup",
        // "Cancel", JOptionPane.INFORMATION_MESSAGE);
        // }
        // });
        JLabel lbl = new JLabel("");

        // create frame        
        frame = new JFrame("Sign Up");
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // frame.add(cancel);
        // frame.add(logout);
        frame.add(lbl);

        frame.add(lblName);
        frame.add(lblPassword);
        frame.add(lblConfirmPassword);

        // create components
        tfName = new JTextField();
        tfPassword = new JTextField();
        tfConfirmPassword = new JTextField();
        btnSignup = new JButton("Sign Up");
        btnCancel = new JButton("Cancel");

        // add components to frame
        frame.add(tfName);
        frame.add(tfPassword);
        frame.add(tfConfirmPassword);
        frame.add(btnSignup);
        frame.add(btnCancel);

        // call method signUp when button is clicked
        btnSignup.addActionListener(e -> accountcreate());

        // add components to frame
        frame.add(tfName);
        frame.add(tfPassword);
        frame.add(tfConfirmPassword);
        frame.add(btnSignup);
        frame.add(btnCancel);

        // set bounds for the components
        btnSignup.setBounds(100, 100, 120, 20);
        btnCancel.setBounds(100, 130, 120, 20);

        // username - top left
        // password - top right
        // confirm password - bottom left
        // sign up - bottom right
        // cancel - bottom left

        tfName.setBounds(150, 10, 100, 40);

        // password - top left + 50
        tfPassword.setBounds(150, 60, 100, 40);

        // confirm password - top left + 100
        tfConfirmPassword.setBounds(150, 110, 100, 40);

        // sign up - top left + 150
        btnSignup.setBounds(10, 160, 90, 50);
        btnCancel.setBounds(200, 160, 90, 50);

        // set frame properties
        frame.setSize(700, 500);
        frame.setLayout(null);
    }

    // method to sign up the user and add them to the database if
    // the password and confirm password match and the username is not already in
    // the database
    // otherwise display an error message and don't add the user to the database

    public void accountcreate() {
        String username = tfName.getText();
        String password = tfPassword.getText();
        String confirmPassword = tfConfirmPassword.getText();

        // check if the password and confirm password match
        if (password.equals(confirmPassword)) {

            // check if the username is already in the database
            try {
                // create a connection to the database
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Liplan2020");

                // create a statement
                Statement statement = connection.createStatement();

                // create a query to check if the username is already in the database
                String query = "SELECT * FROM users WHERE email = '" + username + "'";

                // execute the query
                ResultSet resultSet = statement.executeQuery(query);

                // check if the username is already in the database
                if (resultSet.next()) {
                    // if the username is already in the database, display an error message
                    JOptionPane.showMessageDialog(null, "Name already exists");
                } else {
                    // if the username is not already in the database, add the user to the database
                    String query2 = "INSERT INTO users (email, password) VALUES ('" + username + "', '" + password
                            + "')";
                    statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "ALU Account created");
                    frame.dispose();
                    // open login page
                    loginForm loginForm = new loginForm();
                    loginForm.initialize();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            // if the password and confirm password do not match, display an error message
            JOptionPane.showMessageDialog(null, "Passwords do not match");
        }
    }

    // method to sign up the user and add them to the database if
    // the password and confirm password match and the username is not already in
    // the database

    // method to cancel the sign up process
    public void cancel() {
        frame.dispose();
    }

    // method to start the sign up process
    public static void main(String[] args) {
        System.out.println("Hello");
        signup signup = new signup();
        signup.show();

    }

    public void show() {
        frame.setVisible(true);
    }
}