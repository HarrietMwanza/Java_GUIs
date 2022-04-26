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
        JLabel lblName = new JLabel("Name");
        JLabel lblPassword = new JLabel("Password");
        JLabel lblConfirmPassword = new JLabel("Confirm Password");

        // we set the size and location of the labels using setBounds() method 
        lblName.setBounds(10, 10, 100, 30);
        lblPassword.setBounds(10, 50, 100, 30);
        lblConfirmPassword.setBounds(10, 100, 150, 30);
        
        // we add the labels to the frame using add() method
        

        // we have buttons for signup, login, and logout and a label to display the
        // message to the user
        JButton signup, login, logout;
        // add buttons to the frame and label to the frame
        signup = new JButton("Sign Up");
//  we add action listener and action performed method to the signuo and cancel buttons

btnSignup.addActionListener (new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        signup signup = new signup();
        signup.signup();


        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(signup.this, "You have cancelled the signup", "Cancel", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
        JLabel lbl = new JLabel("");

        // create frame
        frame = new JFrame("Sign Up");
        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(signup);
        frame.add(cancel);
        frame.add(logout);
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
        btnSignup.addActionListener(e -> signup());

        // add components to frame
        frame.add(tfName);
        frame.add(tfPassword);
        frame.add(tfConfirmPassword);
        frame.add(btnSignup);
        frame.add(btnCancel);

        // set bounds for the components
        btnSignup.setBounds(100, 100, 100, 20);
        btnCancel.setBounds(100, 130, 100, 20);

        // username - top left
        // password - top right
        // confirm password - bottom left
        // sign up - bottom right
        // cancel - bottom left

        tfName.setBounds(150, 10, 100, 50);

        // password - top left + 50
        tfPassword.setBounds(150, 60, 100, 50);

        // confirm password - top left + 100
        tfConfirmPassword.setBounds(150, 110, 100, 50);

        // sign up - top left + 150
        btnSignup.setBounds(10, 160, 100, 50);
        btnCancel.setBounds(120, 160, 100, 50);

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
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

                // create a statement
                Statement statement = connection.createStatement();

                // create a query to check if the username is already in the database
                String query = "SELECT * FROM users WHERE username = '" + username + "'";

                // execute the query
                ResultSet resultSet = statement.executeQuery(query);

                // check if the username is already in the database
                if (resultSet.next()) {
                    // if the username is already in the database, display an error message
                    JOptionPane.showMessageDialog(null, "Username already exists");
                } else {
                    // if the username is not already in the database, add the user to the database
                    String query2 = "INSERT INTO users (username, password) VALUES ('" + username + "', '" + password
                            + "')";
                    statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "ALU Account created");
                    frame.dispose();
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
    // otherwise display an error message and don't add the user to the database
    public void signup() {
        accountcreate();
    }

    // method to cancel the sign up process
    public void cancel() {
        frame.dispose();
    }

    // method to start the sign up process
    public static void main(String[] args) {
        signup signup = new signup();
        signup.signup();

    }
}
}

