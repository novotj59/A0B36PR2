/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 *
 * @author Moje
 */
public class VyberRozmeru extends javax.swing.JDialog {
    
    private Matice m=new Matice();

    /**
     * Creates new form Main_window
     */
    public VyberRozmeru() {
        initComponents();
    }
    
   /* public VyberRozmeru(Matice m) {
        this.m=m;
        initComponents();
    }*/

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

 //       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        colsBox.setText("2");
        colsBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colsBoxActionPerformed(evt);
            }
        });

        rowsBox.setText("2");
        rowsBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowsBoxActionPerformed(evt);
            }
        });

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
        
        JPanel fromFile=new JPanel();
        JPanel database=new JPanel();
        fromFile.add(new JLabel("Ze souboru zatím není hotovo"));
        fromFile.setLayout(new FlowLayout());
        database.add(new JLabel("Databáze zatím není hotova"));
        database.setLayout(new FlowLayout());
        
        JTabbedPane tabP = new JTabbedPane();
        tabP.addTab("Ručně", rucne);
        tabP.addTab("Ze souboru",fromFile);
        tabP.addTab("Databáze",database);
        this.add(tabP);
        pack();
        
    }                  

    private void colsBoxActionPerformed(java.awt.event.ActionEvent evt) {                                        
 /*   try{
        Integer.parseInt(colsBox.getText());
    }catch(Exception e){
         JOptionPane.showMessageDialog(this, "Musí být zadaná čísla!", "Chyba vstupních dat", JOptionPane.WARNING_MESSAGE);
         System.out.println("chyba");
    }
        // TODO add your handling code here:*/
    }                                       

    private void rowsBoxActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
 /*       try{
        Integer.parseInt(rowsBox.getText());
        System.out.println("dobre");
    }catch(Exception e){
         JOptionPane.showMessageDialog(this, "Musí být zadaná čísla!", "Chyba vstupních dat", JOptionPane.WARNING_MESSAGE);
    }*/
    }                                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            //Integer.parseInt(str);
            MatrixEntering me = new MatrixEntering(Integer.parseInt(rowsBox.getText()),Integer.parseInt(colsBox.getText()));
            me.setModal(true);
            me.setVisible(true);
            m=me.getM();
            this.dispose();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Musí být zadaná čísla!", "Chyba vstupních dat", JOptionPane.WARNING_MESSAGE);
        }
        
    }                                        

    public Matice getM() {
        return m;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(semestralni.prace.Vyber_rozmeru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(semestralni.prace.Vyber_rozmeru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(semestralni.prace.Vyber_rozmeru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(semestralni.prace.Vyber_rozmeru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new semestralni.prace.Vyber_rozmeru().setVisible(true);
            }
        });
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