/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;



//import javax.swing.

/**
 *
 * @author Moje
 */





public class SemestralniPrace{

    /**
     */
    public SemestralniPrace(){
 //       Container kon = getContentPane();
        
        new MainWindow().setVisible(true);
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
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

      /*  try{
            Database db=new Database();
            
            //JOptionPane.showOptionDialog(null, db.vypis(), "Výsledek",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,new Object[]{},null);
        }
        catch(Exception e){
            System.out.println("Chyba\n");
            e.printStackTrace();
        }*/
        new SemestralniPrace();
    }
}
