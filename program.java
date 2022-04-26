import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class program extends JFrame
{
     JButton students,programs,logout;
     JLabel lbl;
     program()
     {
          students = new JButton("STUDENTS");
          programs = new JButton ("PROGRAMS");
          logout = new JButton ("LOGOUT");
          lbl = new JLabel ("");
          setLayout (new GridLayout(4,1));
          setSize (400,200);
          add(programs);
          add(programs);
          add(logout);
          add(lbl);

          //setDefaultCloseOperation(JFrame.EXIT_NO_CLOSE);
          ButtonHandler bh = new ButtonHandler();
          programs.addActionListener(bh);
          programs.addActionListener(bh);
          programs.addActionListener(bh);
          logout.addActionListener(bh);
     }
     class ButtonHandler implements ActionListener
     {
          public void actionPerformed(ActionEvent ae)
          {
               if (ae.getSource()==programs)
               {
                    lbl.setText("Button students is pressed");
               }
               if (ae.getSource()==programs)
               {
                    lbl.setText("Button programsx is pressed");
               }
               if (ae.getSource()==logout)
               {
                    System.exit(0);
               }
          }
     }

    public void initialize() {
     setVisible(true);
    }
}

