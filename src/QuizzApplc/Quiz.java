package QuizzApplc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 20, 1200, 700);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quizz.jpeg"));
            JLabel image = new JLabel(i1);
            image.setBounds(0, 0, 1200, 300);
            add(image);
        }catch (Exception e){
            JLabel err = new JLabel("image not found");
            err.setBounds(500,150, 300,45);
            err.setFont(new Font("Mongolian Baiti",Font.BOLD,16));
            err.setForeground(Color.RED);
            add(err);
        }

        qno = new JLabel();
        qno.setBounds(100, 330, 40, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 330, 1000, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(question);

        questions[0][0] = "Quel composant effectue la tâche de conversion du bytecode en code machine ?";
        questions[0][1] = "JDK";
        questions[0][2] = "JDB";
        questions[0][3] = "JVM";
        questions[0][4] = "JRE";

        questions[1][0] = "Quel est le composant utilisé pour la compilation, le débogage et l’exécution des programmes java ?";
        questions[1][1] = "JDK";
        questions[1][2] = "JVM";
        questions[1][3] = "JRE";
        questions[1][4] = "JDB";

        questions[2][0] = "Parmi les propositions suivantes, quelle est la fonctionnalité de l’interpréteur Java?";
        questions[2][1] = "Il lit le code de haut niveau et l’exécute";
        questions[2][2] = "Il effectue la conversion du code octet en code machine";
        questions[2][3] = "L’interpréteur n’est rien d’autre qu’un compilateur JIT";
        questions[2][4] = "Il agit comme un intermédiaire entre la JVM et le JIT";

        questions[3][0] = "Quelle est la fonctionnalité de Class.getInstance()?";
        questions[3][1] = "Elle invoque le constructeur";
        questions[3][2] = "Il a la même fonctionnalité que l’opérateur new";
        questions[3][3] = "Elle crée un objet si la classe n’a pas de constructeur défini";
        questions[3][4] = "Aucune de ces réponses";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Les expressions lambda dans java 8 sont basées sur _____?";
        questions[5][1] = "Programmation procédurale";
        questions[5][2] = "Programmation fonctionnelle";
        questions[5][3] = "Programmation des données";
        questions[5][4] = "Tout les réponses sont vrais";

        questions[6][0] = "Exception est une __________?";
        questions[6][1] = "Classe";
        questions[6][2] = "Interface";
        questions[6][3] = "Classe abstraite";
        questions[6][4] = "Autres";

        questions[7][0] = "Lequel de ces mots-clés est utilisé pour créer une classe?";
        questions[7][1] = "Struct";
        questions[7][2] = "Class";
        questions[7][3] = "int";
        questions[7][4] = "autre reponse";

        questions[8][0] = "Lequel de ces opérateurs est utilisé pour allouer de la mémoire à un objet?";
        questions[8][1] = "new";
        questions[8][2] = "malloc";
        questions[8][3] = "alloc";
        questions[8][4] = "realloc";

        questions[9][0] = "Quel mot clé est utilisé pour déclarer une interface en Java?";
        questions[9][1] = "interface";
        questions[9][2] = "implements";
        questions[9][3] = "abstract";
        questions[9][4] = "class";

        answers[0][1] = "JVM";
        answers[1][1] = "JDK";
        answers[2][1] = "Il lit le code de haut niveau et l’exécute";
        answers[3][1] = "Elle crée un objet si la classe n’a pas de constructeur défini";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Programmation fonctionnelle";
        answers[6][1] = "Classe";
        answers[7][1] = "Class";
        answers[8][1] = "new";
        answers[9][1] = "interface";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 400, 550, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 440, 550, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 480, 550, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 520, 550, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(950, 440, 150, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("Help");
        lifeline.setBounds(950, 500, 150, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(950, 560, 150, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 18));

        if (timer > 0) {
            g.drawString(time, 100, 650);
        } else {
            g.drawString("Times up!!", 100, 650);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}
