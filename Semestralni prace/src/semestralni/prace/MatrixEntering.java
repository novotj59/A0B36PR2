/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Moje
 */
public class MatrixEntering extends JDialog {

    JTextField[] pole;
    int row, col;
    private Matice m;
    JPanel top = new JPanel();
    JPanel mid = new JPanel();
    JPanel bot = new JPanel();

    public Matice getM() {
        return m;
    }

    public MatrixEntering(int row, int col) {
        this.col = col;
        this.row = row;
        this.setBounds(100, 100, 50+60*col, 150+30*row);
        Container kon = getContentPane();
        kon.setLayout(new BorderLayout());
        //      kon.add(new JFrame(),srb.CENTER);
        //  Container con=getContentPane();
        //    GridLayout mid = new GridLayout(row,col);
        top.add(new JLabel("Zadej matici"));
        mid.setLayout(new GridLayout(row, col));
        pole = new JTextField[row * col];
        for (int i = 0; i < col * row; i++) {
            //  JTextField i= new JTextField(i.toString());
            pole[i] = new JTextField(/*String.format("%d",i)*/);
            mid.add(pole[i]);
        }
        JButton vytvor = new JButton("Vytvoř");
        vytvor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                vytvor(evt);
            }
        });
        
        JButton rand = new JButton("Náhodně");
        rand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                random(evt);
            }
        });
        
        bot.add(vytvor);
        bot.add(rand);
        kon.add(top, BorderLayout.NORTH);
        kon.add(mid, BorderLayout.CENTER);
        kon.add(bot, BorderLayout.SOUTH);
        pack();
    }
    
    public void random(ActionEvent e) {
        m = new Matice(row, col);
        m.naplnMaticiNahodne(-5, 5);
        int i=0;
        for (int j = 0; j < col; j++) {
                for (int k = 0; k < row; k++) {
                    pole[(k*col)+j].setText(String.format("%.3f",m.GetPole()[k][j]));
                  //  i++;
                }
            }
        mid.updateUI();
    }

    public void vytvor(ActionEvent e) {
        try {
            String s;
            m = new Matice(row, col);
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < row; k++) {
                    s=pole[(k*col)+j].getText();
                    s=s.replace(',', '.');
                    m.nastavHodlotu(j, k, Double.parseDouble(s));
                }
            }
            this.dispose();
            //i=Double.parseDouble(pole[1].getText());
        } catch (NumberFormatException ex) {
                //System.out.println("chyba:\n" + ex));
                JOptionPane.showMessageDialog(this, "Musí být zadaná čísla!", "Chyba vstupních dat", JOptionPane.WARNING_MESSAGE);
        }
        
    }
}
