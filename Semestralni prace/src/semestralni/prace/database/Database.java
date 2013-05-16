/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace.database;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import semestralni.prace.Matice;

/**
 *
 * @author Moje
 * 
 * Třída obsahující samotné spojení s databází
 */
public class Database {
    String url = "jdbc:derby://localhost:1527/matice",pwd="calculator",usr="matrix";
    Connection conn;
    
    Connection GetConnect() throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException{      
        /*Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        conn=DriverManager.getConnection(url, usr, pwd);*/
        return conn;
    }
    
    /**
     *
     * @param m
     * @param s
     * 
     * Uloží do databáze na nové místo matici m a pojmenuje ji textem s
     */
    public void saveMatrix(Matice m, String s){
        try {
           // System.out.println(s);
            int k=m.GetPole().length,l=m.GetPole()[0].length;
            String insertSQL = "INSERT INTO APP.MATRICES (NAZEV, X, Y, MATRIX) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
            preparedStatement.setString(1, s);
            preparedStatement.setInt(2, l);
            preparedStatement.setInt(3, k);
            s=new String();
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < l; j++) {
                    s+=String.format("%.4f",m.GetPole()[i][j])+" ";
                }
                s+="; ";
            }
            preparedStatement.setString(4, s);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @throws InstantiationException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws SQLException
     * 
     * Vytvoří připojení k databázi
     */
    public void connect() throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException{      
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        conn = DriverManager.getConnection(url, usr, pwd);
    }
    
    /**
     *
     * @throws SQLException
     * 
     * 
     * uzavře připojení k databázi
     */
    public void disconnect() throws SQLException{
        conn.close();
    }
    
    Matice loadMatAtRow(int row){
        try{
            Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT APP.MATRICES.NAZEV, APP.MATRICES.X, APP.MATRICES.Y, APP.MATRICES.MATRIX FROM APP.MATRICES");
            rs.absolute(row);
            int i,j;
            i=rs.getInt(2);
            j=rs.getInt(3);
            String str = rs.getString(4);
            Scanner s = new Scanner(new ByteArrayInputStream(str.getBytes("UTF-8")));
            Matice m = new Matice(j,i);
            for (int l = 0; l < j; l++) {
                while(!s.hasNextDouble()){
                    if(s.hasNext()){
                        s.next();
                    }
                }
                for (int k = 0; k < i; k++) {
                    m.nastavHodnotu(k,l,s.nextDouble());
                }
            }
            st.close();
            return m;
        }catch(SQLException | UnsupportedEncodingException e){
            JOptionPane.showMessageDialog(null, "Záznam má nesprávný formát, nebo je poškozen!", "Chyba vstupních dat", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    

    
    /**
     *
     * @param rowToBeDeleted
     * 
     * Smaže z databáze řadu o zadaném indexu (indexováno od 1)
     */
    public void removeRow(int rowToBeDeleted){
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=st.executeQuery("SELECT * FROM APP.MATRICES");
            rs.absolute(rowToBeDeleted);
            rs.deleteRow();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Chyba mazání");
            ex.printStackTrace();
        }
    }
    
}
