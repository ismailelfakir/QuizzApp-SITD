package QuizzApplc;

import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;

public class Login extends JFrame implements ActionListener{

    JButton rules , back ;
    JTextField tfname ;
    Login (){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        try {
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
          JLabel image = new JLabel(i1);
          image.setBounds(0,-30,500,500);
          add(image);
        }catch (Exception e){
            JLabel err = new JLabel("image not found");
            err.setBounds(200,200, 300,45);
            err.setFont(new Font("Mongolian Baiti",Font.BOLD,16));
            err.setForeground(Color.RED);
            add(err);
        }

        JLabel heading = new JLabel("Train your brain");
        heading.setBounds(500,80, 300,45);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(550,150, 300,45);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        name.setForeground(Color.BLUE);
        add(name);

        tfname = new JTextField();
        tfname.setBounds(550,200,300,25);
        tfname.setFont(new Font("Time new Roman",Font.BOLD,20));
        add(tfname);

        rules = new JButton("Next");
        rules.setBounds(550,270,120,25);
        rules.setBackground(new Color(30,144,254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(730,270,120,25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1000,500);
        setLocation(200,150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== rules){
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);

        } else if(ae.getSource()== back){
            setVisible(false);
        }
    }



    public static void main(String[] args){
        new Login();
    }
}
