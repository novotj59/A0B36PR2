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
 * 
 * Metoda pro ruční zadávání matic
 */
public class MatrixEntering extends JDialog {

    JTextField[] pole;
    int row, col;
    private Matice m;
    JPanel top = new JPanel();
    JPanel mid = new JPanel();
    JPanel bot = new JPanel();

    /**
     *
     * @return
     * 
     * Vrací vytvořenou matici
     */
    public Matice getM() {
        return m;
    }

    /**
     *
     * @param row
     * @param col
     * 
     * vytvoří okno pro zadání matice ze zadaných rozměrů
     */
    public MatrixEntering(int row, int col) {
        this(new Matice(row,col));
    }
    /**
     *
     * @param m
     * 
     * Vytvoří okno pro zadávání matice a načte do něj zadanou matici
     */
    public MatrixEntering(Matice m) {
        this.m=m;
        this.col = this.m.GetPole()[0].length;
        this.row = this.m.GetPole().length;
        //this.setBounds(100, 100, 50+(60*col), 150+30*row);
        Container kon = getContentPane();
 //       kon.setSize(50+col*70, 150+30*row);
        this.setBounds(100, 100, 150+(40*col), 150+30*row);
        kon.setLayout(new BorderLayout());
        //      kon.add(new JFrame(),srb.CENTER);
        //  Container con=getContentPane();
        //    GridLayout mid = new GridLayout(row,col);
        top.add(new JLabel("Zadej matici"));
        mid.setLayout(new GridLayout(row, col));
        pole = new JTextField[row * col];
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                pole[i*col+j] = new JTextField(String.format("%.3f",m.GetPole()[i][j]));
                mid.add(pole[i*col+j]);
            }
        }
        
        JButton vytvor = new JButton("Vytvoř");
        vytvor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                vytvor(evt);
            }
        });
        
        JButton rand = new JButton("Náhodně");
        rand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                random(evt);
            }
        });
        bot.setLayout(new java.awt.FlowLayout());
        bot.add(vytvor);
        bot.add(rand);
        kon.add(top, BorderLayout.NORTH);
        kon.add(mid, BorderLayout.CENTER);
        kon.add(bot, BorderLayout.SOUTH);
    }

    
    
    /**
     *
     * @param e
     * 
     * naplní matici náhodnými hodnotami mezi -5 a +5
     */
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

    void vytvor(ActionEvent e) {
        try {
            String s;
            m = new Matice(row, col);
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < row; k++) {
                    s=pole[(k*col)+j].getText();
                    s=s.replace(',', '.');
                    m.nastavHodnotu(j, k, Double.parseDouble(s));
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
