import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.Random;

public class tictacto implements ActionListener {
    JFrame frame = new JFrame();
    Random random = new Random();
    JPanel titPanel = new JPanel();
    JPanel buttonpanel = new JPanel();
    JLabel ltextfield = new JLabel();
    JButton buttons[] = new JButton[9];
    boolean player1_turn;

    tictacto() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50)); // this is how
        // you change background
        // color of frame.
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        ltextfield.setBackground(new Color(25, 25, 25));
        ltextfield.setForeground(new Color(25, 255, 0));
        ltextfield.setOpaque(true);
        ltextfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        ltextfield.setHorizontalAlignment(JLabel.CENTER);
        ltextfield.setText("TIC-TAC-TOE");

        titPanel.setLayout(new BorderLayout());
        titPanel.setBounds(0, 0, 800, 100);
        titPanel.add(ltextfield);

        buttonpanel.setLayout(new GridLayout(3, 3));
        buttonpanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonpanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli ", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        frame.add(titPanel, BorderLayout.NORTH);
        frame.add(buttonpanel);

        firstturn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn == true) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText(("X"));
                        player1_turn = false;
                        ltextfield.setText("O turn");
                        check();

                    }
                }

                else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText(("O"));
                        player1_turn = true;
                        ltextfield.setText("X turn");
                        check();

                    }
                }

            }
        }
    }

    public void check() {
        if (buttons[0].getText() == "X" &&
                buttons[1].getText() == "X" &&
                buttons[2].getText() == "X")

        {
            xwins(0, 1, 2);

        } else if (buttons[3].getText() == "x" &&
                buttons[4].getText() == "X" &&
                buttons[5].getText() == "X") {
            xwins(3, 4, 5);

        } else if (buttons[6].getText() == "X" &&
                buttons[7].getText() == "X" &&
                buttons[8].getText() == "X") {
            xwins(6, 7, 8);

        } else if (buttons[0].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[8].getText() == "X") {
            xwins(0, 4, 8);

        } else if (buttons[2].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[6].getText() == "X") {
            xwins(2, 4, 6);

        } else if (buttons[0].getText() == "X" &&
                buttons[3].getText() == "X" &&
                buttons[6].getText() == "X") {
            xwins(0, 3, 6);

        } else if (buttons[1].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[7].getText() == "X") {
            xwins(1, 4, 7);

        } else if (buttons[2].getText() == "X" &&
                buttons[5].getText() == "X" &&
                buttons[8].getText() == "X") {
            xwins(2, 5, 8);

        }

        // "****************"
        if (buttons[0].getText() == "O" &&
                buttons[1].getText() == "O" &&
                buttons[2].getText() == "O")

        {
            owins(0, 1, 2);

        } else if (buttons[3].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[5].getText() == "O") {
            owins(3, 4, 5);

        } else if (buttons[6].getText() == "O" &&
                buttons[7].getText() == "O" &&
                buttons[8].getText() == "O") {
            owins(6, 7, 8);

        } else if (buttons[0].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[8].getText() == "O") {
            owins(0, 4, 8);

        } else if (buttons[2].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[6].getText() == "O") {
            owins(2, 4, 6);

        } else if (buttons[0].getText() == "O" &&
                buttons[3].getText() == "O" &&
                buttons[6].getText() == "O") {
            owins(0, 3, 6);

        } else if (buttons[1].getText() == "O" &&
                buttons[4].getText() == "O" &&
                buttons[7].getText() == "O") {
            owins(1, 4, 7);

        } else if (buttons[2].getText() == "O" &&
                buttons[5].getText() == "O" &&
                buttons[8].getText() == "O") {
            owins(2, 5, 8);

        }

    }

    public void firstturn() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            ltextfield.setText("O turn");
        } else {
            player1_turn = false;
            ltextfield.setText("O turn");
        }

    }

    public void xwins(int x, int y, int z) {
        buttons[x].setBackground(Color.green);
        buttons[y].setBackground(Color.green);
        buttons[z].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);

        }
        ltextfield.setText("X Wins");
    }

    public void owins(int x, int y, int z) {
        buttons[x].setBackground(Color.RED);
        buttons[y].setBackground(Color.RED);
        buttons[z].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);

        }
        ltextfield.setText("O Wins");

    }

    public static void main(String[] args) {

        tictacto obj = new tictacto();
    }

}
