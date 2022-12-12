package QuizzApplc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel( name + " your brain is thanking you");
        heading.setBounds(180, 50, 700, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblscore = new JLabel("Your score is " + score);
        lblscore.setBounds(280, 200, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(lblscore);

        JButton submit = new JButton("Play Again");
        submit.setBounds(305, 300, 120, 30);
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
