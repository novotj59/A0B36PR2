/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.BorderLayout;
import java.awt.Window;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import semestralni.prace.database.Database;

/**
 *
 * @author Moje
 */
public class MainWindow extends javax.swing.JFrame {

    private Matice m1 = new Matice(2, 2), m2 = new Matice(2, 2),m3;
   // private int operation = 1;
    /**
     * Konstruktor vytvoří hlavní okno maticové kalkulačky
     * 
     * Třída zároveň obsahuje obsluhu všech tlačítek na hlavním okně
     */
    public MainWindow() {
        initComponents();
    }

        // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel1  = new javax.swing.JPanel();
        jPanel2  = new javax.swing.JPanel();
        jPanel3  = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        solve = new javax.swing.JButton();
        skalar = new javax.swing.JTextArea("0");
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        m1.vypis(jPanel21);
        m2.vypis(jPanel22);


        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 200, Short.MAX_VALUE)
                .addComponent(jPanel21));
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 200, Short.MAX_VALUE)
                .addComponent(jPanel21));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 200, Short.MAX_VALUE)
                .addComponent(jPanel22));
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 200, Short.MAX_VALUE)
                .addComponent(jPanel22));
        
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 80, Short.MAX_VALUE)
                .addComponent(skalar));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(skalar));

        //  jPanel11.add(jPanel21);
        //  jPanel12.add(jPanel22);

        jButton1.setText("Načti / vytvoř");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Načti / vytvoř");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.setText("Změň hodnoty");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.setText("Změň hodnoty");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        
        solve.setText("Vypočti");
        solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solveActionPerformed(evt);
            }
        });

        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        jComboBox1.setRenderer(dlcr);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Součet", "Rozdíl", "Násobení maticí","Násobení skalárem", "Transponovaná", "Determinant"}));
        //jComboBox1.seta
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout2 = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(layout2);
        layout2.setHorizontalGroup(
            layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout2.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout2.createSequentialGroup()
                            .addComponent(jButton2)
                            .addComponent(jButton4)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        layout2.setVerticalGroup(
            layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout2.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout2.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
       // pack();
        
        javax.swing.GroupLayout layout1 = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(layout1);
        layout1.setHorizontalGroup(
            layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout1.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout1.createSequentialGroup()
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addComponent(solve)
                    .addComponent(jPanel3)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        layout1.setVerticalGroup(
            layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout1.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout1.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(solve))
                .addGroup(layout1.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3)
                    .addGap(160)));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jComboBox1)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1)
                    .addComponent(jPanel2)));
                  //  .addComponent(jPanel3)));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jComboBox1)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(jPanel1)
                        .addComponent(jPanel2))));
                        //.addComponent(jPanel3))));
        jPanel3.setVisible(false);
        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { //načtení první matice
        try{
            VyberVstupu vr = new VyberVstupu();
            vr.setModal(true);
            vr.setVisible(true);
            jPanel21.removeAll();
            m3=vr.getM();
            if(m3.matice!=null)
                m1 = m3;
            m1.vypis(jPanel21);
            jPanel11.updateUI();
            pack();
        }
        catch(Exception e){
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) { //načtení druhé matice
        try{
            VyberVstupu vr = new VyberVstupu();
            vr.setModal(true);
            vr.setVisible(true);
            jPanel22.removeAll();
            m3=vr.getM();
            if(m3.matice!=null)
                m2 = m3;
            m2.vypis(jPanel22);
            jPanel12.updateUI();
            pack();
        }
        catch(Exception e){
        }
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) { //výběr prováděné operace
        switch (jComboBox1.getSelectedIndex()){
            case 0:
            case 1:
            case 2:
                jPanel2.setVisible(true);
                jPanel3.setVisible(false);
                break;
            case 3:
                jPanel3.setVisible(true);
                jPanel2.setVisible(false);
                break;
            case 4:
            case 5:
                jPanel2.setVisible(false);
                jPanel3.setVisible(false);
                break;
        }
        pack();
    }    
        
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) { //úprava 1. rovnice
        MatrixEntering me = new MatrixEntering(m1);
        me.setModal(true);
        me.setVisible(true);
        jPanel21.removeAll();
        m3=me.getM();
        if(m3.matice!=null)
            m1 = m3;
        m1.vypis(jPanel21);
        jPanel11.updateUI();
        pack();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) { //úprava 2. rovnice
        MatrixEntering me = new MatrixEntering(m2);
        me.setModal(true);
        me.setVisible(true);
        jPanel22.removeAll();
        m3=me.getM();
        if(m3.matice!=null)
            m2 = m3;
        m2.vypis(jPanel22);
        jPanel12.updateUI();
        pack();
    }
    
    private void solveActionPerformed(java.awt.event.ActionEvent evt) { //vyřešení aktuálního výpočtu
        switch (jComboBox1.getSelectedIndex()){
            case 0:
                m3 = m1.maticeSecti(m2,this);
                break;
            case 1:
                m3 = m1.maticeSecti(m2.vynasob(-1),this);
                break;
            case 2:
                m3 = m1.vynasob(m2);
                break;
            case 3:
                try{
                    m3 = m1.vynasob(Double.parseDouble(skalar.getText()));
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(this, "Skalár musí být číslo", "Chyba vstupních dat", JOptionPane.WARNING_MESSAGE);
                    m3=null;
                }
                break;
            case 4:
                 m3 = m1.transponovana();
                break;
            default:
                m3 = new Matice(1,1);
                m3.nastavHodnotu(0,0,m1.determinant());
                if(m3.GetPole()[0][0]==Double.MAX_VALUE){
                    m3=null;
                }
        }
        try{  //výpis okna pro zobrazení výsledku
            JPanel vysledek=new JPanel(), vystup=new JPanel(),south=new JPanel();
            javax.swing.JButton uloz = new javax.swing.JButton("Ulož soubor", createImageIcon("image/save.gif"));
            final javax.swing.JButton db = new javax.swing.JButton("Ulož do databáze"), op = new javax.swing.JButton("Použij jako operand");
            m3.vypis(vysledek);
            south.setLayout(new java.awt.FlowLayout());
            vystup.setLayout(new BorderLayout());
            vystup.add(vysledek,BorderLayout.NORTH);
            south.add(uloz);
            uloz.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    ulozActionPerformed(evt);
                }
            });
            db.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    String s = (String)JOptionPane.showInputDialog(null,"Zadejte název matice","Database save",JOptionPane.PLAIN_MESSAGE,null,null,"");
                    if(s!=null){
                        Window w = SwingUtilities.getWindowAncestor(op);
                        if (w != null) {
                            w.dispose();
                        }
                        databaseSave(s,m3);
                    }
                }
            });
            op.addActionListener(new java.awt.event.ActionListener() { //použije výsledek jako operand pro nový výpočet
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Window w = SwingUtilities.getWindowAncestor(op);
                    if (w != null) {
                        w.dispose();
                    }
                    m1=m3;
                    jPanel21.removeAll();
                    m1.vypis(jPanel21);
                    jPanel11.updateUI();
                }
            });
            south.add(db);
            south.add(op);
            vystup.add(south,BorderLayout.SOUTH);
     //       new javax.swing.JDialog();
            JOptionPane.showOptionDialog(this, vystup, "Výsledek",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,new Object[]{},null);
        }
        catch(Exception e){
        }
    }
    
    private boolean databaseSave(String s, Matice m){ //vytvoří připojení k třídě database a uloží matici do souboru
        try {
            Database db= new Database();
            db.connect();
            db.saveMatrix(m, s);
            db.disconnect();
            return true;
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Nezdařilo se připojení k databázi.", "Chyba databáze", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    private void ulozActionPerformed(java.awt.event.ActionEvent evt) {
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            m1.ulozSoubor(fc.getSelectedFile().getAbsolutePath(),this);
        }
    }
    
    /**
     *
     * @param path
     * @return icon
     * 
     * Vytvoří ikonu z obrázku na zadané cestě
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = semestralni.prace.MainWindow.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            return null;
        }
    }
    
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton solve;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextArea skalar;
    // End of variables declaration
}
