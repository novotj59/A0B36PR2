/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import javax.swing.GroupLayout;

/**
 *
 * @author Moje
 */
public class MainWindow extends javax.swing.JFrame {

    private Matice m1 = new Matice(2, 2), m2 = new Matice(2, 2);
    private int operation = 1;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel1  = new javax.swing.JPanel();
        jPanel2  = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        solve = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        m1.vypis(jPanel21);
        m2.vypis(jPanel22);



        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 160, Short.MAX_VALUE)
                .addComponent(jPanel21));
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 160, Short.MAX_VALUE)
                .addComponent(jPanel21));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 160, Short.MAX_VALUE)
                .addComponent(jPanel22));
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 160, Short.MAX_VALUE)
                .addComponent(jPanel22));

        //  jPanel11.add(jPanel21);
        //  jPanel12.add(jPanel22);

        jButton1.setText("Nacti A");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nacti B");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.setText("Změň A");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.setText("Změň B");
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Součet", "Rozdíl", "Násobení", "Transponovaná", "Determinant"}));
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
                        .addComponent(solve)));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jComboBox1)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1)
                    .addComponent(jPanel2)));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(jComboBox1)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(jPanel1)
                        .addComponent(jPanel2))));
        /*
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
            //.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            // .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addComponent(jButton3)))
                            .addComponent(solve)
                            //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addComponent(jPanel2))
                
                            
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(solve)
                       .addComponent(jPanel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton3))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));*/
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            VyberRozmeru vr = new VyberRozmeru();
            vr.setModal(true);
            vr.setVisible(true);
            jPanel21.removeAll();
            m1 = vr.getM();
            m1.vypis(jPanel21);
            jPanel11.updateUI();
            pack();
        }
        catch(Exception e){
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            VyberRozmeru vr = new VyberRozmeru();
            vr.setModal(true);
            vr.setVisible(true);
            jPanel22.removeAll();
            m2 = vr.getM();
            m2.vypis(jPanel22);
            jPanel12.updateUI();
            pack();
        }
        catch(Exception e){
        }
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        switch (jComboBox1.getSelectedIndex()){
            case 0:
            case 1:
            case 2:
                operation=1;
                jPanel2.setVisible(true);
                pack();
                break;
            case 3:
            case 4:
                operation=2;
                jPanel2.setVisible(false);
                pack();
                break;
        }
    }    
        
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Not ready yet");
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Not ready yet");
    }
    
    private void solveActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println(operation);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        new MainWindow().setVisible(true);
        //new MatrixTyping().setVisible(true);
        // System.out.println("main");

        /* Create and display the form 
         java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
         new Okno().setVisible(true);
         }
         });*/
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
    // End of variables declaration
}
