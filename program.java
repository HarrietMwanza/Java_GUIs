import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class program {
     JFrame frame;
     JButton students, programs, logout;
     JLabel lbl;

     // textarea for display users
     JTextArea ta;

     program() {
          // create a new frame
          frame = new JFrame("STUDENT SIGNUP Form TO ALU");
          students = new JButton("STUDENTS");
          // size and location of the button
          students.setSize(100, 30);
          students.setBounds(10, 10, 100, 30);
          // add the button to the frame
          programs = new JButton("PROGRAMS");
          // size and location of the button
          programs.setSize(100, 30);
          programs.setBounds(10, 50, 100, 30);
          logout = new JButton("LOGOUT");
          // size and location of the button
          logout.setSize(100, 30);
          logout.setBounds(10, 100, 100, 30);
          lbl = new JLabel("");
          ta = new JTextArea();
          ta.setSize(600, 500);
          ta.setBounds(10, 150, 600, 500);
          frame.setLayout(null);
          frame.setSize(600, 800);
          frame.add(ta);
          frame.add(programs);
          frame.add(programs);
          frame.add(logout);
          frame.add(lbl);

          // setDefaultCloseOperation(JFrame.EXIT_NO_CLOSE);
          ButtonHandler bh = new ButtonHandler();
          programs.addActionListener(bh);
          programs.addActionListener(bh);
          programs.addActionListener(bh);
          logout.addActionListener(bh);
     }

     class ButtonHandler implements ActionListener {
          public void actionPerformed(ActionEvent ae) {
               if (ae.getSource() == programs) {
                    try {
                         retrieveData();
                    } catch (SQLException e) {
                         // TODO Auto-generated catch block
                         e.printStackTrace();
                    }
               }
               if (ae.getSource() == programs) {
                    lbl.setText("Button programsx is pressed");
               }
               if (ae.getSource() == logout) {
                    System.exit(0);
               }
          }
     }

     // we need to retrieve data from the database to view the programs and other
     // students
     public void retrieveData() throws SQLException {
          // we need to retrieve data from the database to view the programs and other
          // students
          Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Liplan2020");
          // create a statement
          Statement statement = connection.createStatement();
          // create a query - select * from students
          String query = "select * from students";
          // execute the query
          ResultSet resultSet = statement.executeQuery(query);
          // display the data in the text area - ta - show email, grade, and major
          while (resultSet.next()) {
               ta.append(resultSet.getString("email") + " " + resultSet.getString("grade") + " " + resultSet.getString("major")
                       + "\n");
          }


     }

     public void initialize() {
          frame.setVisible(true);
     }

     public static void main(String[] args) {
          program program = new program();
          program.initialize();
     }
}
