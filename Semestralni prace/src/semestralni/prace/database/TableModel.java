/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Moje
 */
public class TableModel extends AbstractTableModel {

    private String[] colNames={"Název","Sloupců","Řádek","Matice"};
    private ArrayList<String[]> data=new ArrayList<>();
    
    //private ArrayList<DBDataList> data;

    /**
     *
     * @param conn
     * @throws SQLException
     * 
     * konstruktor, který vytvoří obsah tabulky obsahem získaným ze zadaného spojení
     */
    public TableModel(Connection conn) throws SQLException{
        Statement st=conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT APP.MATRICES.NAZEV, APP.MATRICES.X, APP.MATRICES.Y, APP.MATRICES.MATRIX FROM APP.MATRICES");
        ArrayList<String[]> al=new ArrayList<>();
        //int j=0;
        while (rs.next()) {
            String[] aux=new String[colNames.length];
            for (int i = 0; i < colNames.length; i++) {
                aux[i]=rs.getString(i+1);
            }
            al.add(aux);
        }
        for (int i = 0; i < al.size(); i++) {
            data.add(al.get(i));
        }
        st.close();
    }
    
    
    /**
     *
     * @return
     * 
     * Vrací počet řádek taulky
     */
    @Override
    public int getRowCount() {
        return data.size();
    }

    /**
     *
     * @return
     * 
     * Vrací počet sloupců tabulky
     */
    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    /**
     *
     * @param row
     * @param col
     * @return
     * 
     * Vrací hodnotu v tabulce na zadaném místě
     */
    @Override
    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }
    
    /**
     *
     * @param col
     * @return
     * 
     * Vrací nácev sloupce o zadaném indexu
     */
    @Override
    public String getColumnName(int col){
        return colNames[col];
    }
    
    /**
     *
     * @param row
     * 
     * Odstraní z tabulky celou zadanou řadu (indexováno od 0)
     */
    public void removeRow(int row){
        data.remove(row);
    }
}
