package QuizzApplc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name ;
    JButton back,start;

    Rules(String name){
        this.name = name;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome "+name+" to this QUIZZ test");
        heading.setBounds(50,40, 700,30);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20,50, 700,350);
        rules.setFont(new Font("Tahoma",Font.PLAIN,16));
        rules.setText(
             "<html>" +
                     "1 - The team members can discuss before giving the answer" +"<br><br>"+
                     "2 - If a team cannot answer a question they can pass it or after 30 seconds it gets automatically passed to the next team" +"<br><br>"+
                     "3 -  If a team is answering a question and the time passes, then the team gets to complete the answer and is awarded points for the right answer "+"<br><br>" +
                     "</html>"

        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(230,500,100,30);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400,500,100,30);
        start.setBackground(new Color(30,144,254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(750,600);
        setLocation(290,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== start){
            setVisible(false);
            new Quiz(name);

        } else if(ae.getSource()== back){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args){
        new Rules("user");
    }
}
