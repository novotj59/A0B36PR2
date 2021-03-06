/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import semestralni.prace.database.DBDialog;


/**
 *
 * @author Moje
 * 
 * Třída pro výběr zadání nové matice
 */
public class VyberVstupu extends javax.swing.JDialog {
    
    private Matice m=new Matice();

    /**
     * Creates new form Main_window
     * 
     * Vytvoří okno peo výběr a zadání nové matice
     */
    public VyberVstupu() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")                        
    private void initComponents() {

        colsBox = new javax.swing.JTextField();
        rowsBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        colsBox.setText("2");
        rowsBox.setText("2");
        jLabel1.setText("Sloupce");

        jLabel2.setText("Řádky");

        jButton1.setText("Vytvoř");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Vyber rozměry");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("matice");
        
        JPanel rucne = new JPanel();
        
        
        //<editor-fold defaultstate="collapsed" desc=" Layout setting code ">
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(rucne);
        rucne.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(colsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rowsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rowsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pack();
        //</editor-fold>
        
        JPanel fromFile=new JPanel();
        JPanel database=new JPanel();
        JButton loadFile=new JButton("Načti soubor",createImageIcon("image/load.png")); 
        loadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileActionPerformed();
            }
        });
        JButton loadDatabase=new JButton("Načti z databáze",createImageIcon("image/database.png")); 
        loadDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseActionPerformed();
            }
        });
        fromFile.add(loadFile);
        fromFile.setLayout(new FlowLayout());
        database.add(loadDatabase);
       // database.setLayout(new FlowLayout());
        
        JTabbedPane tabP = new JTabbedPane();
        tabP.addTab("Ručně", rucne);
        tabP.addTab("Ze souboru",fromFile);
        tabP.addTab("Databáze",database);
        this.add(tabP);
        pack();
    }  
    
    private void fileActionPerformed(){
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            m.nactiSoubor(fc.getSelectedFile().getAbsolutePath(),this);
            this.dispose();
        }
    }     
    
    private void databaseActionPerformed(){
        try{
            DBDialog p = new DBDialog();
            p.setModal(true);
            p.setVisible(true);
            m=p.getM();
            if (m!=null){
                try {
                    p.getDb().disconnect();
                    this.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(VyberVstupu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Nezdařilo se připojení k databázi", "Chyba vstupních dat", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            //Integer.parseInt(str);
            MatrixEntering me = new MatrixEntering(Integer.parseInt(rowsBox.getText()),Integer.parseInt(colsBox.getText()));
            me.setModal(true);
            me.setVisible(true);
            m=me.getM();
            if(m!=null){
                this.dispose();
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Musí být zadaná čísla!", "Chyba vstupních dat", JOptionPane.WARNING_MESSAGE);
        }
        
    }                                        

    /**
     *
     * @return
     */
    public Matice getM() {
        return m;
    }

    
    /**
     *
     * @param path
     * @return
     * 
     * Vrací ikonu vytvořenou z obrázku na zadané cestě
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
    private javax.swing.JTextField colsBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField rowsBox;
    // End of variables declaration                   
}
